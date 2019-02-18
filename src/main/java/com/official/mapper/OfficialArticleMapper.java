package com.official.mapper;

import java.util.List;

import com.official.model.OfficialArticle;

public interface OfficialArticleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OfficialArticle record);

    int insertSelective(OfficialArticle record);

    OfficialArticle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OfficialArticle record);

    int updateByPrimaryKey(OfficialArticle record);
    
    List<OfficialArticle> display(OfficialArticle officialArticle);
}