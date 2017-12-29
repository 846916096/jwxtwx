package cn.edu.hbmy.service.impl;

import cn.edu.hbmy.mapper.WxNewsServiceMapper;
import cn.edu.hbmy.pojo.WxNews;
import cn.edu.hbmy.service.WxNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 微信消息实现类
 *
 * @author MiaoQ
 * @create 2017-12-25-17:00
 */
@Service
public class WxNewsServiceImpl implements WxNewsService {
    @Autowired
    WxNewsServiceMapper wxNewsServiceMapper;

    public WxNews selectByLastNews() {
        WxNews wxNews = wxNewsServiceMapper.selectByLastNews();
        if(wxNews!=null){
            return wxNews;
        }
        return null;
    }

    public int insert(WxNews record) {
        int insert = wxNewsServiceMapper.insert(record);
        return insert;
    }
}
