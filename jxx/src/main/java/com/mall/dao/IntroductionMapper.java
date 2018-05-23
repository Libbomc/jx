package com.mall.dao;

import com.mall.pojo.Introduction;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IntroductionMapper {
    int deleteByPrimaryKey(Integer introductionId);

    int insert(Introduction record);

    int insertSelective(Introduction record);

    Introduction selectByPrimaryKey(Integer introductionId);

    int updateByPrimaryKeySelective(Introduction record);

    int updateByPrimaryKey(Introduction record);

    List<Introduction> findAll();

    List<Introduction> selectByPrimaryTitle(String introductionTitle);

    int introductionPhoto(@Param("intoductionUrl") String intoductionUrl, @Param("introductionId") Integer introductionId);
}