package com.mall.dao;

import com.mall.pojo.News;

import java.util.List;

public interface NewsMapper {
    int deleteByPrimaryKey(Integer newsId);

    int insert(News record);

    int insertSelective(News record);

    News selectByPrimaryKey(Integer newsId);

    int updateByPrimaryKeySelective(News record);

    List<News> selectByPrimaryTitle(String newsTitle);

    int updateByPrimaryKey(News record);

    List<News> findAll();
}