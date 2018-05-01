package cn.edu.hbmy.controller.wx.admin;

import cn.edu.hbmy.pojo.AttentionUser;
import cn.edu.hbmy.pojo.WxNews;
import cn.edu.hbmy.service.AttentionUserService;
import cn.edu.hbmy.service.WxNewsService;
import cn.edu.hbmy.utils.News.SendNews;
import cn.edu.hbmy.utils.ResponseMsg;
import com.soecode.wxtools.api.IService;
import com.soecode.wxtools.api.WxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * 各种消息发送Controller
 * Created: 2017年12月8日 下午3:14:58 <br/>
 *
 * @author 覃淼
 * @version 1.0
 * @since JDK 1.7
 */
@Controller
@RequestMapping("/wx/admin/news/")
public class NewsController {

    @Autowired
    private AttentionUserService attentionUserService;

    @Autowired
    WxNewsService wxNewsService;

    IService iService = new WxService();

    /**
     * 发送文本消息
     */
    @RequestMapping(value = "text", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMsg SendTextToUser(String leixing, WxNews news, @RequestParam(value = "file", required = false) MultipartFile file,
                                      HttpServletRequest request, HttpServletResponse response) {
        ResponseMsg msg = new ResponseMsg();
        msg.setSuccess(false);
        msg.setMessage("系统异常！请联系管理员");
        List<AttentionUser> users = attentionUserService.selectAllUser();
        if ("文本消息".equals(leixing)) {
            ResponseMsg responseMsg = SendNews.SendTextNews(news.getDescription(), users);
            if (responseMsg.getSuccess()) {
                msg.setSuccess(true);
                msg.setMessage("文本消息发送成功");
                return msg;
            } else {
                msg.setSuccess(false);
                msg.setMessage("文本消息发送失败,或者您已发送该消息");
                return msg;
            }
        } else if ("图文消息".equals(leixing)) {
            // 获得原始文件名
            String fileName = file.getOriginalFilename();
            // 重命名文件
            String newfileName = new Date().getTime() + String.valueOf(fileName);
            String path = request.getSession().getServletContext().getRealPath("upload");
            File targetFile = new File(path, newfileName);
            if(!targetFile.exists()){
                targetFile.mkdir();
            }
            try {
                file.transferTo(targetFile);
                news.setPicurl("/upload/" + newfileName);
                wxNewsService.insert(news);
                msg.setSuccess(true);
                msg.setMessage("图文消息保存成功");
            } catch (Exception e) {
                e.printStackTrace();
                msg.setSuccess(false);
                msg.setMessage("图文消息保存失败！请联系管理员");
                return msg;
            }
        }
        return msg;
    }
}
