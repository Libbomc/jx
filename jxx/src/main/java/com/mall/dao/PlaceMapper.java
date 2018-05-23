package com.mall.dao;

import com.mall.pojo.Place;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PlaceMapper {
    int deleteByPrimaryKey(Integer placeId);

    int insert(Place record);

    int insertSelective(Place record);

    Place selectByPrimaryKey(Integer placeId);

    int updateByPrimaryKeySelective(Place record);

    int updateByPrimaryKey(Place record);

    List<Place> selectByPrimaryName(String placeName);

    List<Place> findAll();

    int placePhoto(@Param("placeUrl") String placeUrl, @Param("placeId") Integer placeId);
}