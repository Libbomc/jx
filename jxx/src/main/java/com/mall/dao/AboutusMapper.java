package com.mall.dao;

import com.mall.pojo.Aboutus;

public interface AboutusMapper {
    boolean deleteByPrimaryKey(Integer aboutusId);

    int insert(Aboutus record);

    int insertSelective(Aboutus record);

    Aboutus selectByPrimaryKey(Integer aboutusId);

    int updateByPrimaryKeySelective(Aboutus record);

    int updateByPrimaryKey(Aboutus record);
}