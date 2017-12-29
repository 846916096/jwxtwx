package cn.edu.hbmy.vo.user;  

import java.io.Serializable;
/**
 * 
 * 用户列表数据模型
 * Created: 2017年11月26日 下午1:17:11 <br/>  
 *  
 * @author 覃淼  
 * @version 1.0
 * @since JDK 1.7
 */
public class UserListVo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 用户openid
	 */
	private String openid;
	/**
	 * 用户昵称
	 */
	private String nickname;
	/**
	 * 用户头像URL
	 */
	private String headimgurl;
	/**
	 * 用户地址
	 */
	private String address;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getHeadimgurl() {
		return headimgurl;
	}
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
	@Override
	public String toString() {
		return "UserListVo [openid=" + openid + ", nickname=" + nickname
				+ ", headimgurl=" + headimgurl + ", address=" + address + "]";
	}
	
}
  
