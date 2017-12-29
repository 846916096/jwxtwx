package cn.edu.hbmy.controller.wx.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.hbmy.service.WxLoginService;
import cn.edu.hbmy.utils.ResponseMsg;

@Controller
@RequestMapping(value="/wx/admin")
public class AdminLoginController {
	@Autowired
	WxLoginService wxLoginService;

	@RequestMapping(value="/user/login")
	@ResponseBody
	public ResponseMsg login(String Xh,String password,HttpServletRequest request){
		/** @TODO 改为管理员数据库验证登录*/
		ResponseMsg msg = new ResponseMsg();
		ResponseMsg result = wxLoginService.login(Xh, password);
		if(result.getSuccess()){
			String homeUrl = request.getScheme() + "://" + request.getServerName()+ ":" + request.getServerPort() + request.getContextPath()+"/wx/admin/index";
			String token = result.getMessage();
			//登陆成功把token写入cookie   微信页面不支持缓存，使用window.localStorage.setItem(key, value);  设置缓存
			//CookieUtils.setCookie(request, response, "token", token);
			msg.setSuccess(true);
			msg.setData(homeUrl);
			msg.setMessage(token);
			return msg;
		}else{
				msg.setSuccess(false);
				msg.setMessage("用户名或密码错误");
				return msg;
		}
	}
}
  
