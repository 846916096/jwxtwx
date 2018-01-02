package cn.edu.hbmy.utils.redis;

/**
 * redis客户端
 */
public interface RedisClient {

    void set(String key,String value);

    void set(byte[] key,byte[] value);

}
