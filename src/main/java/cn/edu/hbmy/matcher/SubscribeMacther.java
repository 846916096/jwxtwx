package cn.edu.hbmy.matcher;

import com.soecode.wxtools.api.WxMessageMatcher;
import com.soecode.wxtools.bean.WxXmlMessage;
import com.sun.xml.internal.ws.api.policy.SourceModel;

/**
 * 处理关注消息
 * @author MiaoQ
 * @create 2017-12-24-14:43
 */
public class SubscribeMacther implements WxMessageMatcher {
    public boolean match(WxXmlMessage message) {
        if("subscribe".equals(message.getEvent())){
            return true;
        }else{
            return false;
        }
    }
}
