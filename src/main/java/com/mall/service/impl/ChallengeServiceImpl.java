package com.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mall.dao.ChallengeMapper;
import com.mall.pojo.Challenge;
import com.mall.pojo.Culture;
import com.mall.service.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by  on 2018/5/7.
 */
@Service("ChallengeService")
public class ChallengeServiceImpl implements ChallengeService {

    @Autowired
    private ChallengeMapper challengeMapper;


    public boolean addChallenge(Challenge challenge) {
        boolean flag = false;
        try {
            challengeMapper.insert(challenge);
            flag = true;
        } catch (Exception e) {
            System.out.print("添加失败");
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean updateChallenge(Challenge challenge) {
        boolean flag = false;
        try {
            challengeMapper.updateByPrimaryKeySelective(challenge);
            flag = true;
        } catch (Exception e) {
            System.out.print("更新失败");
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean deleteChallenge(Integer challengeId) {
        boolean flag = false;
        try {
            challengeMapper.deleteByPrimaryKey(challengeId);
            flag = true;
        } catch (Exception e) {
            System.out.print("添加失败");
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public List<Challenge> findChallengeName(String challengeName) {
        return challengeMapper.selectByPrimaryName(challengeName);
    }

    @Override
    public PageInfo<Challenge> findAllChallenge(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Challenge> challengeList = challengeMapper.findAll();

        PageInfo<Challenge> pageResult = new PageInfo<>(challengeList);

        return pageResult;
    }

}
