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
 * 查看通知消息回复
 * @author MiaoQ
 * @create 2017-12-28-16:57
 */
public class watch_attentionHandler implements WxMessageHandler {

    //图片地址
    String filePath = null;
    //图文消息
    WxNews wxNews = null;

    public watch_attentionHandler(HttpServletRequest request, WxNews wxNews) {
        this.wxNews = wxNews;
        if(this.wxNews !=null){
            filePath = request.getScheme() + "://" + request.getServerName() + ":" +
                    request.getServerPort() + request.getContextPath()+ this.wxNews.getPicurl();
            System.out.println("filePath = " + filePath);
        }
    }

    public WxXmlOutMessage handle(WxXmlMessage wxMessage, Map<String, Object> context, IService iService) throws WxErrorException {
        WxXmlOutMessage xmlOutMsg = null;
        WxXmlOutNewsMessage.Item item = new WxXmlOutNewsMessage.Item();
        if(wxNews!=null){
            item.setTitle(wxNews.getTitle());
            item.setDescription(wxNews.getDescription());
            item.setPicUrl(filePath);
            item.setUrl(wxNews.getUrl());
        }
        if(item!=null){
            xmlOutMsg = WxXmlOutMessage.NEWS().addArticle(item).toUser(wxMessage.getFromUserName()).fromUser(wxMessage.getToUserName()).build();
            return  xmlOutMsg;
        }else{
            xmlOutMsg = WxXmlOutMessage.TEXT().content("暂无通知").toUser(wxMessage.getFromUserName()).fromUser(wxMessage.getToUserName()).build();
            return xmlOutMsg;
        }
    }
}
