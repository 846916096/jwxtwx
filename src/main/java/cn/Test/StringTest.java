package cn.Test;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * 字符串截取测试
 *
 * @author MiaoQ
 * @create 2018-01-02-12:56
 */
public class StringTest {
    String str = "031440405@2017@春";
    @Test
    public void TestString(){
        String number = StringUtils.substringBefore(str, "@");
        System.out.println("number = " + number);

        String s = StringUtils.substringAfter(str, "@");

        String year = StringUtils.substringBefore(s,"@");
        System.out.println("year = " + year);

        String jidu = StringUtils.substringAfter(s, "@");
        System.out.println("jidu = " + jidu);
    }
}
