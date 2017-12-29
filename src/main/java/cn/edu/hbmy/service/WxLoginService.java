package cn.edu.hbmy.service;

import cn.edu.hbmy.utils.ResponseMsg;

public interface WxLoginService {
	
	public ResponseMsg login(String Xh, String password);
	
}
