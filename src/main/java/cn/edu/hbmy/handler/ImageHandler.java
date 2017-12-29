package cn.edu.hbmy.handler;

import java.util.Map;

import com.soecode.wxtools.api.IService;
import com.soecode.wxtools.api.WxMessageHandler;
import com.soecode.wxtools.bean.WxXmlMessage;
import com.soecode.wxtools.bean.WxXmlOutMessage;
import com.soecode.wxtools.exception.WxErrorException;

public class ImageHandler implements WxMessageHandler {

	public WxXmlOutMessage handle(WxXmlMessage wxMessage,
			Map<String, Object> context, IService iService)
			throws WxErrorException {
		WxXmlOutMessage xmlOutMsg = WxXmlOutMessage.IMAGE().mediaId(wxMessage.getMediaId()).toUser(wxMessage.getFromUserName()).fromUser(wxMessage.getToUserName()).build();
        return xmlOutMsg;
	}
}
  
