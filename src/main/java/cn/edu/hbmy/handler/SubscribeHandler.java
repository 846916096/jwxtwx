package cn.edu.hbmy.handler;

import com.soecode.wxtools.api.IService;
import com.soecode.wxtools.api.WxMessageHandler;
import com.soecode.wxtools.bean.WxXmlMessage;
import com.soecode.wxtools.bean.WxXmlOutMessage;
import com.soecode.wxtools.exception.WxErrorException;

import java.util.Map;

/**
 * 处理关注消息 Handler
 * 用户关注之后自动发送消息给用户
 * @author MiaoQ
 * @create 2017-12-24-14:43
 */
public class SubscribeHandler implements WxMessageHandler {
    public WxXmlOutMessage handle(WxXmlMessage wxMessage, Map<String, Object> context, IService iService) throws WxErrorException {
        WxXmlOutMessage xmlOutMsg = WxXmlOutMessage.TEXT().content("感谢关注湖北民族学院教务系统公众号").toUser(wxMessage.getFromUserName()).fromUser(wxMessage.getToUserName()).build();
        return xmlOutMsg;
    }
}
