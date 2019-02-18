package com.plan.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.plan.model.YearPlanNext;

public interface YearPlanNextMapper {
    int deleteByPrimaryKey(@Param("id")Integer id);

    int insert(YearPlanNext record);

    int insertSelective(YearPlanNext record);

    YearPlanNext selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(YearPlanNext record);

    int updateByPrimaryKey(YearPlanNext record);
    
    List<YearPlanNext> selectall(Integer mid);
    Integer creatyearplannext(List<YearPlanNext> yearplannext);
    
    List<YearPlanNext> selectbykey(@Param("yid")Integer yid,@Param("did")Integer did);
    List<YearPlanNext> selectbydept(@Param("did")Integer did,@Param("yid")Integer yid);

    List<YearPlanNext> yearplannextoverdue();
    
    List<YearPlanNext> selectgroup(Integer yid);
}