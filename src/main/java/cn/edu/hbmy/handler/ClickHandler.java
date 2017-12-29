package cn.edu.hbmy.handler;

import cn.edu.hbmy.pojo.WxNews;
import com.soecode.wxtools.api.IService;
import com.soecode.wxtools.api.WxMessageHandler;
import com.soecode.wxtools.bean.WxXmlMessage;
import com.soecode.wxtools.bean.WxXmlOutMessage;
import com.soecode.wxtools.exception.WxErrorException;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 处理点击菜单消息的Handler
 * @author MiaoQ
 * @create 2017-12-28-15:44
 */
public class ClickHandler implements WxMessageHandler {

    //图片地址
    String filePath = null;
    //图文消息
    WxNews wxNews = null;

    public ClickHandler(HttpServletRequest request, WxNews wxNews) {
        if(this.wxNews !=null){
            filePath = request.getScheme() + "://" + request.getServerName() + ":" +
                    request.getServerPort() + request.getContextPath()+ this.wxNews.getPicurl();
        }
    }

    public WxXmlOutMessage handle(WxXmlMessage wxMessage, Map<String, Object> context, IService iService) throws WxErrorException {

        WxXmlOutMessage xmlOutMsg = WxXmlOutMessage.TEXT().content("输入以下序号可快速进行操作\n" +
                "1: 查 看 成 绩\n" +
                "2: 查 看 通 知\n" +
                "3: 创 新 学 分\n" +
                "4: 圈 存 服 务").toUser(wxMessage.getFromUserName()).fromUser(wxMessage.getToUserName()).build();
        return xmlOutMsg;
    }
}
