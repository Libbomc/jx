package com.mall.dao;

import com.mall.pojo.CompetitionInformation;

public interface CompetitionInformationMapper {
    int deleteByPrimaryKey(Integer competitionId);

    int insert(CompetitionInformation record);

    int insertSelective(CompetitionInformation record);

    CompetitionInformation selectByPrimaryKey(Integer competitionId);

    int updateByPrimaryKeySelective(CompetitionInformation record);

    int updateByPrimaryKey(CompetitionInformation record);
}