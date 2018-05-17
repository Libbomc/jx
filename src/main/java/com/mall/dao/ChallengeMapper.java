package com.mall.dao;

import com.mall.pojo.Challenge;

import java.util.List;

public interface ChallengeMapper {
    int deleteByPrimaryKey(Integer challengeId);

    int insert(Challenge record);

    int insertSelective(Challenge record);

    Challenge selectByPrimaryKey(Integer challengeId);

    int updateByPrimaryKeySelective(Challenge record);

    int updateByPrimaryKey(Challenge record);

    List<Challenge> findAll();

    List<Challenge> selectByPrimaryName(String challengeName);
}