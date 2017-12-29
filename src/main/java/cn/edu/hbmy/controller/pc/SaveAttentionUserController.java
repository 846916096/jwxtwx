package cn.edu.hbmy.controller.pc;  

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.hbmy.pojo.AttentionUser;
import cn.edu.hbmy.service.AttentionUserService;
import cn.edu.hbmy.utils.BeanUtil;
import cn.edu.hbmy.utils.ResponseMsg;
import cn.edu.hbmy.utils.SerializeUtils;
import cn.edu.hbmy.utils.redis.JedisClientPool;

import com.soecode.wxtools.api.IService;
import com.soecode.wxtools.api.WxService;
import com.soecode.wxtools.bean.WxUserList.WxUser;
import com.soecode.wxtools.bean.WxUserList.WxUser.WxUserGet;
import com.soecode.wxtools.bean.result.WxUserListResult;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 
 * 保存所有关注者用户
 * Created: 2017年11月29日 下午3:37:04 <br/>  
 *  
 * @author 覃淼  
 * @version 1.0
 * @since JDK 1.7
 */
@Controller
@RequestMapping(value="/AttentionUser")
public class SaveAttentionUserController {
	/**wx-tools公共接口*/
	IService iService = new WxService();
	@Resource
	AttentionUserService attentionUserService;
	@Autowired
	JedisClientPool jedisPool;
	@RequestMapping(value="/save")
	@ResponseBody
	public ResponseMsg saveAttentionUser(){
		try {
			WxUserListResult userListResult = iService.batchGetUserOpenId("");
			/**获取所有用户的openID*/
			String[] openid = userListResult.getData().getOpenid();
			for (String userOpenids : openid) {
				WxUserGet userGet = new WxUserGet(userOpenids, "");
				WxUser user = iService.getUserInfoByOpenId(userGet);
				AttentionUser attentionUser = BeanUtil.beanConvert(user, AttentionUser.class);
				StringBuffer address = new StringBuffer();
				if(user.getCountry()!=null&&user.getCountry()!=""){
					address.append(user.getCountry());
				}
				if(user.getProvince()!=null&&user.getProvince()!=""){
					address.append(user.getProvince());
				}
				if(user.getCity()!=null&&user.getCity()!=""){
					address.append(user.getCity());
				}
				if(address!=null){
					attentionUser.setAddress(address.toString());
				}
				attentionUserService.save(attentionUser);
				}
			return new ResponseMsg("保存成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseMsg("保存失败！请联系管理员");
		}
	}
}
  
