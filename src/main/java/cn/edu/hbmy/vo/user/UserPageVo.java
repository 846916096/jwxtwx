package cn.edu.hbmy.vo.user;  

import java.util.List;

import cn.edu.hbmy.vo.PageVo;

/**
 * 
 * 用户分页数据模型
 * Created: 2017年11月26日 下午1:17:53 <br/>  
 *  
 * @author 覃淼  
 * @version 1.0
 * @since JDK 1.7
 */
public class UserPageVo extends PageVo{
	private static final long serialVersionUID = 1L;
	
	private List<UserListVo> list;

	public List<UserListVo> getListVo() {
		return list;
	}

	public void setListVo(List<UserListVo> list) {
		this.list = list;
		setData(list);
	}

	@Override
	public String toString() {
		return "UserPageVo [list=" + list + "]";
	}

}
  
