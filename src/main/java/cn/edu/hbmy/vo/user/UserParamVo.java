package cn.edu.hbmy.vo.user;  

import java.io.Serializable;

public class UserParamVo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 用户昵称，用于查询关注用户
	 */
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "UserParamVo [name=" + name + "]";
	}
}
  
