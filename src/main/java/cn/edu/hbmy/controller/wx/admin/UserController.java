package cn.edu.hbmy.controller.wx.admin;

import cn.edu.hbmy.pojo.AttentionUser;
import cn.edu.hbmy.service.AttentionUserService;
import cn.edu.hbmy.utils.BeanUtil;
import cn.edu.hbmy.utils.ResponseMsg;
import cn.edu.hbmy.vo.user.UserListVo;
import com.soecode.wxtools.api.IService;
import com.soecode.wxtools.api.WxService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 关注用户Controller
 * Created: 2017年12月12日 上午9:22:55 <br/>  
 *  
 * @author 覃淼  
 * @version 1.0
 * @since JDK 1.7
 */
@Controller
@RequestMapping("wx/admin")
public class UserController {
	IService iService = new WxService();
	@Autowired
	private AttentionUserService attentionUserService;

	private static final Logger log = Logger.getLogger(UserController.class);

	//查询所有关注用户
	@RequestMapping(value="/getAllUser",method = RequestMethod.POST)
	@ResponseBody
	public ResponseMsg getAllUser(/*Integer page,Integer rows,*/){
			/*int offset = (page-1)*rows;
			PageHelper.offsetPage(offset, page);*/
            ResponseMsg msg = new ResponseMsg();
			List<AttentionUser> allUser = attentionUserService.selectAllUser();
			log.info(allUser);
            List<UserListVo> voList = BeanUtil.listConvert(allUser, UserListVo.class);
            msg.setData(voList);
            msg.setSuccess(true);
			/*List<AttentionUser> allUser = attentionUserService.selectAllUser();
			List<UserListVo> voList = BeanUtil.listConvert(allUser, UserListVo.class);*/
			/*UserPageVo userPageVo = new UserPageVo();
			userPageVo.setListVo(voList);*/
			return msg;
	}
}