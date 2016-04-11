package cn.ghy.flashpay.mapper;

import cn.ghy.flashpay.model.location;
import cn.ghy.flashpay.model.locationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface locationMapper {
    int countByExample(locationExample example);

    int deleteByExample(locationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(location record);

    int insertSelective(location record);

    List<location> selectByExample(locationExample example);

    location selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") location record, @Param("example") locationExample example);

    int updateByExample(@Param("record") location record, @Param("example") locationExample example);

    int updateByPrimaryKeySelective(location record);

    int updateByPrimaryKey(location record);
}