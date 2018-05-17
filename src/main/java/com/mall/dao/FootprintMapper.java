package com.mall.dao;

import com.mall.pojo.Footprint;

public interface FootprintMapper {
    int deleteByPrimaryKey(Integer footprintId);

    int insert(Footprint record);

    int insertSelective(Footprint record);

    Footprint selectByPrimaryKey(Integer footprintId);

    int updateByPrimaryKeySelective(Footprint record);

    int updateByPrimaryKey(Footprint record);
}