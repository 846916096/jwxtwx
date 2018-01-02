package cn.Test;

import cn.edu.hbmy.pojo.Xsjbxx;
import cn.edu.hbmy.utils.JsonUtils;
import com.soecode.wxtools.util.crypto.MD5;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

/**
 * 测试Spring-data-redis
 *
 * @author MiaoQ
 * @create 2018-01-02-11:31
 */
public class RedisTest {
    ClassPathXmlApplicationContext appCtx = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-redistem.xml");
    final RedisTemplate<Object, Object> redisTemplate = appCtx.getBean("redisTemplate",RedisTemplate.class);
    @Test
    public void testSet(){
        ValueOperations<Object, Object> stringObjectValueOperations = redisTemplate.opsForValue();
        stringObjectValueOperations.set("测试1",123456);

        Object o = stringObjectValueOperations.get("测试1");
        System.out.println("o = " + o);

        Xsjbxx xsjbxx = new Xsjbxx();
        xsjbxx.setXsjbxxMm("123456");
        xsjbxx.setXsjbxxXb("男");
        xsjbxx.setXsjbxxXh("031440405");
        xsjbxx.setXsjbxxXm("覃淼");
        xsjbxx.setXsjbxxZymc("计算机科学与技术");

        System.out.println("JsonUtils.objectToJson(user)    =  " + JsonUtils.objectToJson(xsjbxx));
        stringObjectValueOperations.set(xsjbxx.getXsjbxxXh().getBytes(), JsonUtils.objectToJson(xsjbxx));

        Object o1 = stringObjectValueOperations.get(xsjbxx.getXsjbxxXh().getBytes());
        System.out.println("o1 = " + o1);
    }
}
