package cn.edu.hbmy.service;  

import java.util.List;

import cn.edu.hbmy.pojo.AttentionUser;

public interface AttentionUserService {
	
	public void save(AttentionUser attentionUser);
	
	public AttentionUser selectById(String oppenId);
	
	public AttentionUser selectByName(String name);
	
	public List<AttentionUser> selectAllUser();
}
  
