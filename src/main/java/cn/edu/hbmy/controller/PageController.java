package cn.edu.hbmy.controller;  

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	
	/**管理系统**/
	/**首页*/
	@RequestMapping(value="")
	public String index(){
		return "common/index";
	}
	
	/***用户管理*/
	@RequestMapping(value="/user")
	public String user(){
		return "common/user";
	}
	
	/***分组管理*/
	@RequestMapping(value="/group")
	public String group(){
		return "common/group";
	}
	/**系统管理**/
	@RequestMapping(value="/menu")
	public String menu(){
		return "common/menu";
	}
	
	/**文本消息发送**/
	@RequestMapping(value="/text")
	public String text(){
		return "common/text";
	}
	
	
	/***学生微信客户端***/
	/**微信登录页面*/
	@RequestMapping(value="wx/stu/login")
	public String Stulogin(){
		return "wx/stu/login";
	}
	
	/***学生微信首页*/
	@RequestMapping(value="wx/stu/index")
	public String wxindex(){
		return "wx/stu/home";
	}
	
////////////////////////////////////////////////////////
				// 管理员页面跳转//
///////////////////////////////////////////////////////
	@RequestMapping(value="wx/admin/login")
	public String Adminlogin(){
		return "wx/admin/login";
	}
	
	/***管理员微信首页*/
	@RequestMapping(value="wx/admin/index")
	public String adminindex(){
		return "wx/admin/home";
	}

	@RequestMapping(value="ceshi")
	public String ceshi(){
		return "ceshi";
	}

}