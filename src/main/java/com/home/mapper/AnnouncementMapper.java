package com.home.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;


import com.home.model.Announcement;

public interface AnnouncementMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Announcement announcement);

    Integer insertSelective(Announcement announcement);

    Announcement selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Announcement announcement);

    int updateByPrimaryKey(Announcement record);
    
    int save(Announcement announcement);
    
    List<Announcement> select(@RequestBody Announcement announcement);
    List<Announcement> select2(@Param("id")Integer id);
    List<Announcement> select3();
    List<Announcement> selectaccomplish(Integer uid);
    
    int deleteAnnc(@Param("id")int id,@Param("state")int state,@Param("invitation") String invitation);

    
}