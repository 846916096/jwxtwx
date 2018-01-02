/*package cn.edu.hbmy.controller.pc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.hbmy.utils.ResponseMsg;

import com.soecode.wxtools.api.IService;
import com.soecode.wxtools.api.WxService;
import com.soecode.wxtools.bean.result.WxMenuResult;

@Controller
@RequestMapping(value="/menu/")
public class MenuController {
	IService iService = new WxService();
	@RequestMapping(value="getAllMenu")
	@ResponseBody
	public ResponseMsg getAllMenu(){
		ResponseMsg msg = new ResponseMsg();
		try {
			WxMenuResult menu = iService.getMenu();
			msg.setData(menu);	
			return msg;
		} catch (Exception e) {
			msg.setSuccess(false);
			msg.setMessage("菜单加载失败！");
		}
		return msg;
	}
}
  */
