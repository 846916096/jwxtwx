package cn.edu.hbmy.controller;

import cn.edu.hbmy.handler.*;
import cn.edu.hbmy.matcher.OtherMatcher;
import cn.edu.hbmy.matcher.SubscribeMacther;
import cn.edu.hbmy.matcher.watch_gradeMatcher;
import cn.edu.hbmy.service.WxNewsService;
import com.soecode.wxtools.api.IService;
import com.soecode.wxtools.api.WxConfig;
import com.soecode.wxtools.api.WxMessageRouter;
import com.soecode.wxtools.api.WxService;
import com.soecode.wxtools.bean.WxXmlMessage;
import com.soecode.wxtools.bean.WxXmlOutMessage;
import com.soecode.wxtools.util.xml.XStreamTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 验证微信服务器的有效性以及消息的发送控制Controller
 *
 * @author MiaoQ
 * @create 2017-12-25-13:45
 */
@Controller
@RequestMapping("wxServer")
public class WeiXinServerController {

    //统一业务API入口
    private IService iService = new WxService();

    @Autowired
    WxNewsService wxNewsService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 验证服务器的有效性
        PrintWriter out = response.getWriter();
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        if (iService.checkSignature(signature, timestamp, nonce, echostr)) {
            out.print(echostr);
        }
        out.close();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        // 返回消息给微信服务器
        PrintWriter out = response.getWriter();


        // 获取encrypt_type 消息加解密方式标识
        String encrypt_type = request.getParameter("encrypt_type");
        // 创建一个路由器
        WxMessageRouter router = new WxMessageRouter(iService);

        try {
            // 判断消息加解密方式，如果是加密模式。encrypt_type==aes
            if (encrypt_type != null && "aes".equals(encrypt_type)) {
                // String signature = request.getParameter("signature");
                String timestamp = request.getParameter("timestamp");
                String nonce = request.getParameter("nonce");
                String msg_signature = request.getParameter("msg_signature");

                // 微信服务器推送过来的加密消息是XML格式。使用WxXmlMessage中的decryptMsg()解密得到明文。
                WxXmlMessage wx = WxXmlMessage.decryptMsg(
                        request.getInputStream(), WxConfig.getInstance(),
                        timestamp, nonce, msg_signature);
                System.out.println("wx = \n" + wx.toString());
                // end()是指消息进入该规则后不再进入其他规则。 而next()是指消息进入了一个规则后，如果满足其他规则也能进入，处理。
                if("subscribe".equals(wx.getEvent())){
                    //关注回复
                    router.rule().matcher(new SubscribeMacther()).handler(new SubscribeHandler()).end();
                }else if("CLICK".equals(wx.getEvent())&& "watch_grade".equals(wx.getEventKey())){
                    //查看成绩消息回复
                    router.rule().handler(new watch_gradeHandler()).end();
                }else if("CLICK".equals(wx.getEvent())&& "watch_attention".equals(wx.getEventKey())){
                    //查看通知消息回复
                    router.rule().handler(new watch_attentionHandler(request,wxNewsService.selectByLastNews())).end();
                }else if("CLICK".equals(wx.getEvent())&& "Innovation_credits".equals(wx.getEventKey())){
                    //查看学分消息回复

                }else{
                    //其他消息回复
                    router.rule().matcher(new OtherMatcher()).handler(new OtherHandler()).end();
                }
                // 把消息传递给路由器进行处理，得到最后一个handler处理的结果
                WxXmlOutMessage xmlOutMsg = router.route(wx);
                if (xmlOutMsg != null) {
                    // 将要返回的消息加密，返回
                    out.print(WxXmlOutMessage.encryptMsg(
                            WxConfig.getInstance(), xmlOutMsg.toXml(),
                             timestamp, nonce));// 返回给用户。
                }
                // 如果是明文模式，执行以下语句
            } else {
                // 微信服务器推送过来的是XML格式。
                WxXmlMessage wx = XStreamTransformer.fromXml(
                        WxXmlMessage.class, request.getInputStream());
                // end()是指消息进入该规则后不再进入其他规则。 而next()是指消息进入了一个规则后，如果满足其他规则也能进入，处理。
                System.out.println("wx = \n" + wx.toString());
                if("subscribe".equals(wx.getEvent())){
                    //关注回复
                    router.rule().matcher(new SubscribeMacther()).handler(new SubscribeHandler()).end();
                }else if("CLICK".equals(wx.getEvent())&& "watch_grade".equals(wx.getEventKey())){
                    //查看成绩消息回复
                    router.rule().handler(new watch_gradeHandler()).end();
                }else if("CLICK".equals(wx.getEvent())&& "watch_attention".equals(wx.getEventKey())){
                    //查看通知消息回复
                    router.rule().handler(new watch_attentionHandler(request,wxNewsService.selectByLastNews())).end();
                }else if("CLICK".equals(wx.getEvent())&& "Innovation_credits".equals(wx.getEventKey())){
                    //查看学分消息回复

                }else{
                    router.rule().matcher(new watch_gradeMatcher()).handler(new GradeHandler()).end();
                    //其他消息回复
                    router.rule().matcher(new OtherMatcher()).handler(new OtherHandler()).end();
                }
                //编号处理回复
                //router.rule().rContent("^[0-9]*$").handler(new TextHandler(request,wxNewsService.selectByLastNews())).end();

                // 把消息传递给路由器进行处理
                WxXmlOutMessage xmlOutMsg = router.route(wx);
                System.out.println("xmlOutMsg = " + xmlOutMsg);
                if (xmlOutMsg != null) {
                    out.print(xmlOutMsg.toXml());// 因为是明文，所以不用加密，直接返回给用户。
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }
}
