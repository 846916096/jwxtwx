package cn.edu.hbmy.handler;

import com.soecode.wxtools.api.IService;
import com.soecode.wxtools.api.WxMessageHandler;
import com.soecode.wxtools.bean.WxXmlMessage;
import com.soecode.wxtools.bean.WxXmlOutMessage;
import com.soecode.wxtools.exception.WxErrorException;

import java.util.Map;

/**
 * 处理查看成绩消息回复
 * @author MiaoQ
 * @create 2017-12-28-16:55
 */
public class watch_gradeHandler implements WxMessageHandler{
    public WxXmlOutMessage handle(WxXmlMessage wxMessage, Map<String, Object> context, IService iService){
        WxXmlOutMessage xmlOutMsg = null;
        xmlOutMsg = WxXmlOutMessage.TEXT().content("回复\"学号@学年@季度\"查看成绩").toUser(wxMessage.getFromUserName()).fromUser(wxMessage.getToUserName()).build();
        return xmlOutMsg;
    }
}
