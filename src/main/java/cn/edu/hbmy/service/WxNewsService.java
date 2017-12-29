package cn.edu.hbmy.service;

import cn.edu.hbmy.pojo.WxNews;

/**
 * 微信消息服务类
 *
 * @author MiaoQ
 * @create 2017-12-25-16:59
 */
public interface WxNewsService {
    WxNews selectByLastNews();

    int insert(WxNews record);
}
