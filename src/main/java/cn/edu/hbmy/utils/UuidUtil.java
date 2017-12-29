package cn.edu.hbmy.utils;

import java.util.UUID;

public class UuidUtil {
	//获取UUID
    public static String getUUID32(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
