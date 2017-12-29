package cn.edu.hbmy.utils.redis;

import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisClientPool implements JedisClient {

    private JedisPool jedisPool;

	public JedisPool getJedisPool() {
		return jedisPool;
	}

	public void setJedisPool(JedisPool jedisPool) {
		this.jedisPool = jedisPool;
	}

	/**
	 * 0号DB:存储学生信息 1号DB:存储SESSION  2号DB:存储关注者用户
	 * @param key key
	 * @param value value
	 * @param index 第几个db数据库
	 * @return
	 */
	public String set(String key, String value,int index) {
        Jedis jedis = jedisPool.getResource();
		jedis.select(index);
		String result = jedis.set(key, value);
        jedis.close();
        return result;
	}

	/**
	 *0号DB:存储学生信息 1号DB:存储SESSION  2号DB:存储关注者用户
	 * @param key key
	 * @param index 第几个db数据库
	 * @return 返回值
	 */
	public String get(String key,int index) {
		Jedis jedis = jedisPool.getResource();
		jedis.select(index);
		String result = jedis.get(key);
		jedis.close();
		return result;
	}

	/**
	 * 0号DB:存储学生信息 1号DB:存储SESSION  2号DB:存储关注者用户
	 * 根据key判断数据库是否有值
	 * @param key
	 * @param index 第几个db数据库
	 * @return
	 */
	public Boolean exists(String key,int index) {
		Jedis jedis = jedisPool.getResource();
		jedis.select(index);
		Boolean result = jedis.exists(key);
		jedis.close();
		return result;
	}


	/***
	 * 0号DB:存储学生信息 1号DB:存储SESSION  2号DB:存储关注者用户
	 * 根据key设置数据库中的存储时间
	 * @param key
	 * @param seconds
	 * @param index
	 * @return
	 */
	public Long expire(String key, int seconds,int index) {
		Jedis jedis = jedisPool.getResource();
		jedis.select(index);
		Long result = jedis.expire(key, seconds);
		jedis.close();
		return result;
	}

	/**
	 * 0号DB:存储学生信息 1号DB:存储SESSION  2号DB:存储关注者用户
	 * @param key
	 * @param index
	 * @return
	 */
	public Long ttl(String key,int index) {
		Jedis jedis = jedisPool.getResource();
		jedis.select(index);
		Long result = jedis.ttl(key);
		jedis.close();
		return result;
	}

	/**
	 * 0号DB:存储学生信息 1号DB:存储SESSION  2号DB:存储关注者用户
	 * @param key
	 * @param index
	 * @return
	 */
	public Long incr(String key,int index) {
		Jedis jedis = jedisPool.getResource();
		jedis.select(index);
		Long result = jedis.incr(key);
		jedis.close();
		return result;
	}

	/**
	 * 0号DB:存储学生信息 1号DB:存储SESSION  2号DB:存储关注者用户
	 * @param key
	 * @param field
	 * @param value
	 * @param index
	 * @return
	 */
	public Long hset(String key, String field, String value,int index) {
		Jedis jedis = jedisPool.getResource();
		jedis.select(index);
		Long result = jedis.hset(key, field, value);
		jedis.close();
		return result;
	}

	/**
	 * 0号DB:存储学生信息 1号DB:存储SESSION  2号DB:存储关注者用户
	 * @param key
	 * @param field
	 * @param index
	 * @return
	 */
	public String hget(String key, String field,int index) {
		Jedis jedis = jedisPool.getResource();
		jedis.select(index);
		String result = jedis.hget(key, field);
		jedis.close();
		return result;
	}

	 
	public Long hdel(String key, String... field) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.hdel(key, field);
		jedis.close();
		return result;
	}

	/**
	 * 0号DB:存储学生信息 1号DB:存储SESSION  2号DB:存储关注者用户
	 * @param key
	 * @param field
	 * @param index
	 * @return
	 */
	public Boolean hexists(String key, String field,int index) {
		Jedis jedis = jedisPool.getResource();
		jedis.select(index);
		Boolean result = jedis.hexists(key, field);
		jedis.close();
		return result;
	}

	/**
	 * 0号DB:存储学生信息 1号DB:存储SESSION  2号DB:存储关注者用户
	 * @param key
	 * @param index
	 * @return
	 */
	public List<String> hvals(String key,int index) {
		Jedis jedis = jedisPool.getResource();
		jedis.select(index);
		List<String> result = jedis.hvals(key);
		jedis.close();
		return result;
	}

	/**
	 * 0号DB:存储学生信息 1号DB:存储SESSION  2号DB:存储关注者用户
	 * @param key
	 * @param index
	 * @return
	 */
	public Long del(String key,int index) {
		Jedis jedis = jedisPool.getResource();
		jedis.select(index);
		Long result = jedis.del(key);
		jedis.close();
		return result;
	}

	/**
	 * 0号DB:存储学生信息 1号DB:存储SESSION  2号DB:存储关注者用户
	 * @param key
	 * @param value
	 * @param index
	 * @return
	 */
	public String set(byte[] key, byte[] value,int index) {
		Jedis jedis = jedisPool.getResource();
		jedis.select(index);
		String result = jedis.set(key, value);
		jedis.close();
		return result;
	}

	/**
	 * 0号DB:存储学生信息 1号DB:存储SESSION  2号DB:存储关注者用户
	 * @param key
	 * @param index
	 * @return
	 */
	public byte[] get(byte[] key,int index) {
		Jedis jedis = jedisPool.getResource();
		jedis.select(index);
		byte[] result = jedis.get(key);
		jedis.close();
		return result;
	}

	/**
	 * 切换DB
	 * @see JedisClient#select(int)
	 */
	 
	public void select(int index) {
		Jedis jedis = jedisPool.getResource();
        jedis.select(index);
        jedis.close();
	}

	/**
	 * 获取第indexDB中所有的key
	 * @param index
	 * @return
	 */
	public Set<byte[]> keys(int index) {
		Jedis jedis = jedisPool.getResource();
		jedis.select(index);
		Set<byte[]> bytes = jedis.keys("*".getBytes());
		jedis.close();
		return bytes;
	}

	public Long sadd(byte[] key, byte[] value, int index) {
		Jedis jedis = jedisPool.getResource();
		jedis.select(index);
        Long sadd = jedis.sadd(key, value);
        jedis.close();
        return sadd;
	}
}
