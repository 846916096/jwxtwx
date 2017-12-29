package cn.edu.hbmy.pojo;  

import java.io.Serializable;

/**
 * 	关注用户的po类
 * Created: 2017年11月29日 下午3:40:10 <br/>  
 *  
 * @author 覃淼  
 * @version 1.0
 * @since JDK 1.7
 */
public class AttentionUser implements Serializable {

	private static final long serialVersionUID = 1L;

	private String openid;
	private String nickname;
	private String headimgurl;
	private String city;
	private String province;
	private String country;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
}
  
