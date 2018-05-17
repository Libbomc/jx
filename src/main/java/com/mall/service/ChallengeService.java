package com.mall.service;

import com.github.pagehelper.PageInfo;
import com.mall.pojo.Challenge;

import java.util.List;

/**
 * Created by  on 2018/5/7.
 */
public interface ChallengeService {

    //个人已经自我挑战过的东西，进行添加
    boolean addChallenge(Challenge challenge);

    //个人自我挑战进行更新
    boolean updateChallenge(Challenge challenge);

    //个人自我挑战进行删除
    boolean deleteChallenge(Integer challengeId);

    //个人自我挑战通过名字进行查询
    List<Challenge> findChallengeName(String challengeName);

    //查询所有挑战者,包括所有记录
    PageInfo<Challenge> findAllChallenge(Integer pageNum, Integer pageSize);

}
