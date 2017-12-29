package cn.edu.hbmy.handler;

import cn.edu.hbmy.pojo.WxNews;
import com.soecode.wxtools.api.IService;
import com.soecode.wxtools.api.WxMessageHandler;
import com.soecode.wxtools.bean.WxXmlMessage;
import com.soecode.wxtools.bean.WxXmlOutMessage;
import com.soecode.wxtools.bean.WxXmlOutNewsMessage;
import com.soecode.wxtools.exception.WxErrorException;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author MiaoQ
 * @create 2017-12-24-14:19
 */
public class TextHandler implements WxMessageHandler {

    //图片地址
    String filePath = null;
    //图文消息
    WxNews wxNews = null;

    public TextHandler(HttpServletRequest request, WxNews wxNews) {
        if(this.wxNews !=null){
            filePath = request.getScheme() + "://" + request.getServerName() + ":" +
                    request.getServerPort() + request.getContextPath()+ this.wxNews.getPicurl();
        }
    }

    public WxXmlOutMessage handle(WxXmlMessage wxMessage, Map<String, Object> context, IService iService) throws WxErrorException {

        WxXmlOutMessage xmlOutMsg = null;

        if("1".equals(wxMessage.getContent())){

        }else if("2".equals(wxMessage.getContent())){
            WxXmlOutNewsMessage.Item item = new WxXmlOutNewsMessage.Item();
            if(wxNews!=null){
                item.setTitle(wxNews.getTitle());
                item.setDescription(wxNews.getDescription());
                item.setPicUrl(filePath);
                item.setUrl(wxNews.getUrl());
            }
            xmlOutMsg = WxXmlOutMessage.NEWS().addArticle(item).toUser(wxMessage.getFromUserName()).fromUser(wxMessage.getToUserName()).build();
        }else if("3".equals(wxMessage.getContent())){

        }else if("4".equals(wxMessage.getContent())){

        }else{
            xmlOutMsg = WxXmlOutMessage.TEXT().content("请选择正确的序号！").toUser(wxMessage.getFromUserName()).fromUser(wxMessage.getToUserName()).build();
        }
        return xmlOutMsg;
    }
}
