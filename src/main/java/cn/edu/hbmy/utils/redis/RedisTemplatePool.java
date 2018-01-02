package cn.edu.hbmy.utils.redis;

import org.springframework.data.redis.connection.RedisConnectionCommands;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.List;
import java.util.Set;

/**
 * redisTemplate 实现类
 *
 * @author MiaoQ
 * @create 2018-01-02-10:38
 */
public class RedisTemplatePool implements RedisClient {
    private RedisTemplate redisTemplate;


    public RedisTemplate getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void set(String key, String value) {

    }

    public void set(byte[] key, byte[] value) {

    }
}

