package cn.edu.hbmy.controller.wx.stu;

import cn.edu.hbmy.service.WxLoginService;
import cn.edu.hbmy.utils.ResponseMsg;
import cn.edu.hbmy.utils.ValidCodeUtils;
import cn.edu.hbmy.utils.redis.JedisClientPool;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/wx/user/")
public class WxLoginController {
    @Autowired
    WxLoginService wxLoginService;
    @Autowired
    JedisClientPool jedisPool;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMsg login(String Xh, String password, HttpServletRequest request, HttpServletResponse response) {
        ResponseMsg msg = new ResponseMsg();

        /**验证码判断 begin**/
        String checkNumber = request.getParameter("checkNumber");
        if (StringUtils.isBlank(checkNumber)) {
            msg.setSuccess(false);
            msg.setMessage("请输入验证码");
            return msg;
        }
        //从session中获取验证码
        String CHECK_NUMBER_KEY = (String) request.getSession().getAttribute("codeValue");
        if (StringUtils.isBlank(CHECK_NUMBER_KEY)) {
            msg.setSuccess(false);
            msg.setMessage("验证码获取失败,请联系管理员");
            return msg;
        }

        /**不区分大小写*/
        if (!checkNumber.equalsIgnoreCase(CHECK_NUMBER_KEY)) {
            msg.setSuccess(false);
            msg.setMessage("验证码错误,请重新输入");
            return msg;
        }
        /**验证码判断 end**/

        ResponseMsg result = wxLoginService.login(Xh, password);
        if (result.getSuccess()) {
            String homeUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/wx/stu/index";
            String token = result.getMessage();

            msg.setSuccess(true);
            msg.setData(homeUrl);
            msg.setMessage(token);
            return msg;
        } else {
                msg.setSuccess(false);
                msg.setMessage("用户名或密码错误");
                return msg;
        }
    }

    @RequestMapping("validCodeServlet")
    public void validCodeServlet(HttpServletRequest request, HttpServletResponse response) {
        try {
            ValidCodeUtils.getImage(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
} 
