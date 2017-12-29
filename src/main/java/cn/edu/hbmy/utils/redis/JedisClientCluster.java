package cn.edu.hbmy.utils.redis;

import java.util.List;
import java.util.Set;

import redis.clients.jedis.JedisCluster;

public class JedisClientCluster implements JedisClient {
	
	private JedisCluster jedisCluster;
	

	public JedisCluster getJedisCluster() {
		return jedisCluster;
	}

	public void setJedisCluster(JedisCluster jedisCluster) {
		this.jedisCluster = jedisCluster;
	}

	 
	public String set(String key, String value) {
		return jedisCluster.set(key, value);
	}

	 
	public String get(String key) {
		return jedisCluster.get(key);
	}

	public Boolean exists(String key) {
		return jedisCluster.exists(key);
	}

	public Long expire(String key, int seconds) {
		return jedisCluster.expire(key, seconds);
	}

	public Long ttl(String key) {
		return jedisCluster.ttl(key);
	}

	public Long incr(String key) {
		return jedisCluster.incr(key);
	}

	 
	public Long hset(String key, String field, String value) {
		return jedisCluster.hset(key, field, value);
	}

	 
	public String hget(String key, String field) {
		return jedisCluster.hget(key, field);
	}


	public String set(String key, String value, int index) {
		return null;
	}

	public String get(String key, int index) {
		return null;
	}

	public Boolean exists(String key, int index) {
		return null;
	}

	public Long expire(byte[] key, int seconds, int index) {
		return null;
	}

	public Long expire(String key, int seconds, int index) {
		return null;
	}

	public Long ttl(String key, int index) {
		return null;
	}

	public Long incr(String key, int index) {
		return null;
	}

	public Long hset(String key, String field, String value, int index) {
		return null;
	}

	public String hget(String key, String field, int index) {
		return null;
	}

	public Long hdel(String key, String... field) {
		return jedisCluster.hdel(key, field);
	}

	public Boolean hexists(String key, String field, int index) {
		return null;
	}

	public List<String> hvals(String key, int index) {
		return null;
	}

	public Long del(String key, int index) {
		return null;
	}

	public String set(byte[] key, byte[] value, int index) {
		return null;
	}

	public byte[] get(byte[] key, int index) {
		return new byte[0];
	}


	public Boolean hexists(String key, String field) {
		return jedisCluster.hexists(key, field);
	}

	 
	public List<String> hvals(String key) {
		return jedisCluster.hvals(key);
	}
  
	 
	public Long del(String key) {
		return jedisCluster.del(key);
	}

	 
	public String set(byte[] key, byte[] value) {
		
		return null;
	}

	 
	public byte[] get(byte[] key) {
		  
		return null;
	}

	 
	public void select(int index) {
	}

	public Set<byte[]> keys(int index) {
		return null;
	}

	public Long sadd(byte[] key, byte[] value, int index) {
		return null;
	}

}
