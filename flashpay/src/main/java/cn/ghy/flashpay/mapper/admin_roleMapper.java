package cn.ghy.flashpay.mapper;

import cn.ghy.flashpay.model.admin_role;
import cn.ghy.flashpay.model.admin_roleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface admin_roleMapper {
    int countByExample(admin_roleExample example);

    int deleteByExample(admin_roleExample example);

    int insert(admin_role record);

    int insertSelective(admin_role record);

    List<admin_role> selectByExample(admin_roleExample example);

    int updateByExampleSelective(@Param("record") admin_role record, @Param("example") admin_roleExample example);

    int updateByExample(@Param("record") admin_role record, @Param("example") admin_roleExample example);
}