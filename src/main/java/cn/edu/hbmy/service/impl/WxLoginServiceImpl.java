package cn.edu.hbmy.service.impl;

import cn.edu.hbmy.mapper.XsjbxxMapper;
import cn.edu.hbmy.pojo.Xsjbxx;
import cn.edu.hbmy.service.WxLoginService;
import cn.edu.hbmy.utils.ConfigStatic;
import cn.edu.hbmy.utils.JsonUtils;
import cn.edu.hbmy.utils.ResponseMsg;
import cn.edu.hbmy.utils.SerializeUtils;
import cn.edu.hbmy.utils.redis.JedisClientPool;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.Cache;

import java.util.UUID;

/**
 * 微信用户登录的实现类 Created: 2017年12月5日 上午9:10:10 <br/>
 * 第一次登录会访问数据库，之后将用户数据存入redis，以后直接在redis中访问
 *
 * @author 覃淼
 * @version 1.0
 * @since JDK 1.7
 */
@Service
public class WxLoginServiceImpl implements WxLoginService {
    /**
     * 单机版redis
     */
    @Autowired
    JedisClientPool jedisPool;

    @Autowired
    XsjbxxMapper xsjbxxMapper;

    public ResponseMsg login(String Xh, String password) {
        ResponseMsg msg = new ResponseMsg();
        try {
            if (jedisPool.get((ConfigStatic.USER + DigestUtils.md5Hex(Xh)).getBytes(), 0) != null) {
                byte[] userFromRedis = jedisPool.get((ConfigStatic.USER + DigestUtils.md5Hex(Xh)).getBytes(), 0);
                Xsjbxx deUser = (Xsjbxx) SerializeUtils.deSerialize(userFromRedis);
                if (!DigestUtils.md5Hex(password).equals(deUser.getXsjbxxMm())) {
                    msg.setSuccess(false);
                    return msg;
                }

                /**写入缓存*/
                //如果正确生成token
                String token = UUID.randomUUID().toString();
                //把用户写入redis，key：token  value:用户信息
                deUser.setXsjbxxMm(null);
                jedisPool.set(ConfigStatic.SESSION + token, JsonUtils.objectToJson(deUser), 1);
                //设置session过期时间
                jedisPool.expire(ConfigStatic.SESSION + token, 3600, 1);
                msg.setMessage(ConfigStatic.SESSION + token);
                msg.setSuccess(true);
                return msg;
            } else {
                Xsjbxx user = null;
                try {
                    user = xsjbxxMapper.selectByPrimaryKey(Xh);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (user == null) {
                    msg.setSuccess(false);
                    return msg;
                }
                if (!DigestUtils.md5Hex(password).equals(user.getXsjbxxMm())) {
                    msg.setSuccess(false);
                    return msg;
                }
                /** 用户第一次登录后，将数据存入redis 以学号MD5方式存入*/
                jedisPool.set((ConfigStatic.USER + DigestUtils.md5Hex(Xh)).getBytes(), SerializeUtils.serialize(user), 0);

                /**写入缓存*/
                //如果正确生成token
                String token = UUID.randomUUID().toString();
                //把用户写入redis，key：token  value:用户信息  并将用户密码设置为空

                user.setXsjbxxMm(null);
                jedisPool.set(ConfigStatic.SESSION + token, JsonUtils.objectToJson(user), 1);
                //设置session过期时间
                jedisPool.expire(ConfigStatic.SESSION + token, 3600, 1);
                //把token返回
                msg.setMessage(ConfigStatic.SESSION + token);
                msg.setSuccess(true);
                return msg;
            }
        }catch (Exception e){
            e.printStackTrace();
            msg.setSuccess(false);
            msg.setMessage("连接超时！请联系管理员");
            return msg;
        }
    }
}
