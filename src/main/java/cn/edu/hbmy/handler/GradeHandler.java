package cn.edu.hbmy.handler;

import com.soecode.wxtools.api.IService;
import com.soecode.wxtools.api.WxMessageHandler;
import com.soecode.wxtools.bean.WxXmlMessage;
import com.soecode.wxtools.bean.WxXmlOutMessage;
import com.soecode.wxtools.exception.WxErrorException;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * 学生成绩查看最终返回Handler
 * @author MiaoQ
 * @create 2017-12-29-14:44
 */
public class GradeHandler implements WxMessageHandler {
    public WxXmlOutMessage handle(WxXmlMessage wxMessage, Map<String, Object> context, IService iService) throws WxErrorException {
        String str = wxMessage.getContent();
        String number = StringUtils.substringBefore(str, "@"); //学号
        String s = StringUtils.substringAfter(str, "@");
        String year = StringUtils.substringBefore(s,"@"); //学年
        String jidu = StringUtils.substringAfter(s, "@"); //季度
        System.out.println("学号 = " + number +"学年 = "+year+"季度 = "+jidu);

        return null;
    }
}
