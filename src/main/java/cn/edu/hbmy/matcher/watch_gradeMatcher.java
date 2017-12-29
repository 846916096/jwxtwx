package cn.edu.hbmy.matcher;

import com.soecode.wxtools.api.WxMessageMatcher;
import com.soecode.wxtools.bean.WxXmlMessage;

/**
 * 成绩查看处理Matcher
 * @author MiaoQ
 * @create 2017-12-29-14:39
 */
public class watch_gradeMatcher implements WxMessageMatcher {
    public boolean match(WxXmlMessage message) {
        //判断字符串中是否有@
        if(message.getContent().indexOf("@") > 0){
            return true;
        }
        return false;
    }
}
