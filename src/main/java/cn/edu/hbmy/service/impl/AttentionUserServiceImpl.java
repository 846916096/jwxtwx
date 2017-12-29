package cn.edu.hbmy.service.impl;  

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import cn.edu.hbmy.utils.ConfigStatic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.hbmy.pojo.AttentionUser;
import cn.edu.hbmy.service.AttentionUserService;
import cn.edu.hbmy.utils.SerializeUtils;
import cn.edu.hbmy.utils.redis.JedisClientPool;

/**
 * 	关注用户实现类
 * Created: 2017年11月29日 下午3:47:04 <br/>  
 *  
 * @author 覃淼  
 * @version 1.0
 * @since JDK 1.7
 */
@Service
public class AttentionUserServiceImpl implements AttentionUserService {


	@Autowired
	JedisClientPool jedisPool;
	
	/**
	 * 保存关注者用户
	 */
	public void save(AttentionUser attentionUser) {
		jedisPool.set((ConfigStatic.WX+attentionUser.getOpenid()).getBytes(), SerializeUtils.serialize(attentionUser),2);
	}

	/**
	 * 根据用户OppenID查询用户
	 */
	public AttentionUser selectById(String oppenId) {
		byte[] bs = jedisPool.get((ConfigStatic.WX+oppenId).getBytes(),2);
		if(bs!=null){
			AttentionUser attentionUser = (AttentionUser)SerializeUtils.deSerialize(bs);
			return attentionUser;
		}
		return null;
	}


	/**
	 * 	根据用户昵称查询用户
     * 	@TODO 在redis中根据姓名查询  后期可能不用
	 */
	public AttentionUser selectByName(String name) {
		return null;/*attentionUserMapper.selectByName(name);*/
	}

	/**
	 * 在redis中查询所有用户
	 */
	public List<AttentionUser> selectAllUser() {
        Set<byte[]> keys = jedisPool.keys(2);
        Iterator<byte[]> iterator = keys.iterator();
        List<AttentionUser> list = new ArrayList<AttentionUser>();
        while (iterator.hasNext()){
            byte[] bs = jedisPool.get(iterator.next(), 2);
            AttentionUser user = (AttentionUser)SerializeUtils.deSerialize(bs);
            list.add(user);
        }
        return list;
	}

}
  
