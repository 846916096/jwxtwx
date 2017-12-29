package cn.edu.hbmy.utils.redis;

import java.util.List;
import java.util.Set;

public interface JedisClient {

	String set(String key, String value,int index);
	String get(String key,int index);
	Boolean exists(String key,int index);
	Long expire(String key, int seconds,int index);
	Long ttl(String key,int index);
	Long incr(String key,int index);
	Long hset(String key, String field, String value,int index);
	String hget(String key, String field,int index);
	Long hdel(String key, String... field);
	Boolean hexists(String key, String field,int index);
	List<String> hvals(String key,int index);
	Long del(String key,int index);
	String set(byte[] key, byte[] value,int index);
	byte[] get(byte[] key,int index);
	void select(int index);
	Set<byte[]> keys(int index);
	Long sadd(byte[] key, byte[] value,int index);
}
