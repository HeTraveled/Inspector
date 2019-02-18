package com.sys.mapper;

import com.sys.model.Propelling;
import java.util.Date;

import org.apache.ibatis.annotations.Param;

public interface PropellingMapper {
    int deleteByPrimaryKey(Date propellingTime);

    int insert(Propelling record);

    int insertSelective(Propelling record);
    
    int update(@Param("propelling") String propelling);
    
    Propelling selectid();
}