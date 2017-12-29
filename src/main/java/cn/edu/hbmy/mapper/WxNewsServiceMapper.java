package cn.edu.hbmy.mapper;

import cn.edu.hbmy.pojo.WxNews;
import cn.edu.hbmy.pojo.WxNewsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 微信消息mapper
 *
 * @author MiaoQ
 * @create 2017-12-25-17:01
 */
public interface WxNewsServiceMapper{

   /* int countByExample(WxNewsExample example);

    int deleteByExample(WxNewsExample example);

    int deleteByPrimaryKey(Integer id);*/

    int insert(WxNews record);

    /*int insertSelective(WxNews record);

    List<WxNews> selectByExample(WxNewsExample example);

    WxNews selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WxNews record, @Param("example") WxNewsExample example);

    int updateByExample(@Param("record") WxNews record, @Param("example") WxNewsExample example);

    int updateByPrimaryKeySelective(WxNews record);

    int updateByPrimaryKey(WxNews record);*/

    WxNews selectByLastNews();

}
