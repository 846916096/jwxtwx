package cn.edu.hbmy.utils.News;

import cn.edu.hbmy.pojo.AttentionUser;
import cn.edu.hbmy.pojo.wx.News;
import cn.edu.hbmy.utils.MessageUtil;
import cn.edu.hbmy.utils.ResponseMsg;
import com.soecode.wxtools.api.IService;
import com.soecode.wxtools.api.WxConsts;
import com.soecode.wxtools.api.WxService;
import com.soecode.wxtools.bean.SenderContent;
import com.soecode.wxtools.bean.WxOpenidSender;
import com.soecode.wxtools.exception.WxErrorException;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 给用户发送消息工具类
 *
 * @author MiaoQ
 * @create 2017-12-18-15:34
 */
public class SendNews {


    static IService iService = new WxService();

    public static ResponseMsg SendTextNews(String TextNews, List<AttentionUser> users) {
        ResponseMsg msg = new ResponseMsg();
        WxOpenidSender openidSender = new WxOpenidSender();
        try {
            if (users != null) {
                List<String> openidList = new ArrayList<String>();
                for (AttentionUser user : users) {
                    openidList.add(user.getOpenid());
                }
                // 群发文本内容
                openidSender.setText(new SenderContent.Text(TextNews));
                openidSender.setMsgtype(WxConsts.MASS_MSG_TEXT);
                openidSender.setTouser(openidList);

                try {
                    iService.sendAllByOpenid(openidSender);
                    msg.setSuccess(true);
                    return msg;
                } catch (WxErrorException e) {
                    e.printStackTrace();
                    msg.setSuccess(false);
                    return msg;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            msg.setSuccess(false);
            return msg;
        }
        msg.setSuccess(false);
        return msg;
    }
}
