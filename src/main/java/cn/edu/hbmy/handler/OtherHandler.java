package cn.edu.hbmy.handler;

import com.soecode.wxtools.api.IService;
import com.soecode.wxtools.api.WxMessageHandler;
import com.soecode.wxtools.bean.WxXmlMessage;
import com.soecode.wxtools.bean.WxXmlOutMessage;
import com.soecode.wxtools.exception.WxErrorException;

import java.util.Map;

/**
 * @author MiaoQ
 * @create 2017-12-26-9:32
 */
public class OtherHandler implements WxMessageHandler {
    public WxXmlOutMessage handle(WxXmlMessage wxMessage, Map<String, Object> context, IService iService) throws WxErrorException {
        WxXmlOutMessage xmlOutMsg = WxXmlOutMessage.TEXT().content("本订阅号还没有开发您所需要的应用\n" +
                "敬请期待！").toUser(wxMessage.getFromUserName()).fromUser(wxMessage.getToUserName()).build();
        return xmlOutMsg;
    }
}
