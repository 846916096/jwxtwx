package cn.edu.hbmy.controller.wx.stu;  

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.hbmy.service.WxLoginService;
import cn.edu.hbmy.utils.ResponseMsg;
import cn.edu.hbmy.utils.redis.JedisClientPool;

import com.alibaba.druid.support.json.JSONUtils;

/***
 * 学生基本信息页面Controller
 * Created: 2017年12月11日 下午5:01:09 <br/>  
 *  
 * @author 覃淼  
 * @version 1.0
 * @since JDK 1.7
 */
@Controller
@RequestMapping("/wx/")
public class WxUserInfoController {
	@Autowired
	WxLoginService wxLoginService;
	@Autowired
	JedisClientPool jedisPool;
	
	@RequestMapping(value="user/info",method = RequestMethod.POST)
	@ResponseBody
	public ResponseMsg info(String token,HttpServletRequest request,HttpServletResponse response){
		ResponseMsg msg = new ResponseMsg();
        /**从缓存中读出数据*/
        String json = jedisPool.get(token,1);
        //判断json是否为空
        if(StringUtils.isBlank(json)){
            /**没有缓存 返回登录页面*/
            String loginUrl = request.getScheme() + "://" + request.getServerName()+ ":" + request.getServerPort() + request.getContextPath()+"/wx/stu/login";
            msg.setSuccess(false);
            msg.setMessage(loginUrl);
            return msg;
        }
        //将缓存的信息传给页面
        msg.setData(JSONUtils.parse(json));
		return msg;
	}
} 
