package cn.edu.hbmy.matcher;

import com.soecode.wxtools.api.WxMessageMatcher;
import com.soecode.wxtools.bean.WxXmlMessage;

/**
 * 处理其他消息的回复
 * @author MiaoQ
 * @create 2017-12-26-9:32
 */
public class OtherMatcher implements WxMessageMatcher {
    public boolean match(WxXmlMessage message) {
        return true;
    }
}
