package cn.edu.hbmy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.hbmy.pojo.Xsjbxx;
import cn.edu.hbmy.pojo.XsjbxxExample;

public interface XsjbxxMapper {
    int countByExample(XsjbxxExample example);

    int deleteByExample(XsjbxxExample example);

    int deleteByPrimaryKey(String xsjbxxXh);

    int insert(Xsjbxx record);

    int insertSelective(Xsjbxx record);

    List<Xsjbxx> selectByExampleWithBLOBs(XsjbxxExample example);

    List<Xsjbxx> selectByExample(XsjbxxExample example);

    /**
     * @param xsjbxxXh  学号
     * @return
     */
    Xsjbxx selectByPrimaryKey(String xsjbxxXh);

    int updateByExampleSelective(@Param("record") Xsjbxx record, @Param("example") XsjbxxExample example);

    int updateByExampleWithBLOBs(@Param("record") Xsjbxx record, @Param("example") XsjbxxExample example);

    int updateByExample(@Param("record") Xsjbxx record, @Param("example") XsjbxxExample example);

    int updateByPrimaryKeySelective(Xsjbxx record);

    int updateByPrimaryKeyWithBLOBs(Xsjbxx record);

    int updateByPrimaryKey(Xsjbxx record);
}