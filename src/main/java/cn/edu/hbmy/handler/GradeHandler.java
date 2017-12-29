package cn.edu.hbmy.handler;

import com.soecode.wxtools.api.IService;
import com.soecode.wxtools.api.WxMessageHandler;
import com.soecode.wxtools.bean.WxXmlMessage;
import com.soecode.wxtools.bean.WxXmlOutMessage;
import com.soecode.wxtools.exception.WxErrorException;

import java.util.Map;

/**
 * 学生成绩查看最终返回Handler
 * @author MiaoQ
 * @create 2017-12-29-14:44
 */
public class GradeHandler implements WxMessageHandler {
    public WxXmlOutMessage handle(WxXmlMessage wxMessage, Map<String, Object> context, IService iService) throws WxErrorException {
        String str = wxMessage.getContent();
        int indexOf = str.indexOf("@"); //031440405@2017@春季



        return null;

    }
}
