package cn.edu.hbmy.controller;

import cn.edu.hbmy.utils.ResponseMsg;
import com.soecode.wxtools.api.IService;
import com.soecode.wxtools.api.WxConfig;
import com.soecode.wxtools.api.WxService;
import com.soecode.wxtools.bean.WxJsapiConfig;
import com.soecode.wxtools.exception.WxErrorException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * 页面获取角色sdk-config的Controller  测试用
 *
 * @author MiaoQ
 * @create 2017-12-20-14:16
 */
@Controller
@RequestMapping("/js-sdk/")
public class WxJssdkController {

    @RequestMapping("getConfig")
    @ResponseBody
    public ResponseMsg getConfig(String url,HttpServletResponse response, HttpServletRequest request){
        ResponseMsg msg = new ResponseMsg();
        IService iService = new WxService();
        String appid = WxConfig.getInstance().getAppId();
        List<String> jsApiList = new ArrayList<String>();
        //需要用到哪些JS SDK API 就设置哪些
        jsApiList.add("chooseImage");//拍照或从手机相册中选图接口
        jsApiList.add("onMenuShareQZone");//获取“分享到QQ空间”按钮点击状态及自定义分享内容接口
        try {
            //把config返回到前端进行js调用即可。
            WxJsapiConfig config = iService.createJsapiConfig(url, jsApiList);
            msg.setData(config);
            msg.setMessage(appid);
            return msg;
        } catch (WxErrorException e) {
            e.printStackTrace();
            return null;
        }
    }
}
