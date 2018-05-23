package com.mall.dao;

import com.github.pagehelper.PageInfo;
import com.mall.pojo.Activities;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ActivitiesMapper {
    int deleteByPrimaryKey(Integer activitiesId);

    int insert(Activities record);

    int insertSelective(Activities record);

    Activities selectByPrimaryKey(Integer activitiesId);

    int updateByPrimaryKeySelective(Activities record);

    int updateByPrimaryKey(Activities record);

    List<Activities> findActivitiesType(String activitiesType);

    List<Activities> findAllActivities();

    int activitiesa(@Param("activitiesUrl") String activitiesUrl, @Param("activitiesId") Integer activitiesId);
}