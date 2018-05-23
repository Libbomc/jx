package com.mall.controller.portal;

import com.github.pagehelper.PageInfo;
import com.mall.pojo.Challenge;
import com.mall.service.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by  on 2018/5/7.
 */
@Controller
@RequestMapping(value = "/jx/Challenge/")
public class ChallengeController {

    @Autowired
    private ChallengeService challengeService;

    @ResponseBody
    @RequestMapping(value = "addChallenge.do", method = RequestMethod.POST)
    public boolean addChallenge(Challenge challenge) {
        return challengeService.addChallenge(challenge);
    }

    @ResponseBody
    @RequestMapping(value = "updateChallenge.do", method = RequestMethod.POST)
    public boolean updateChallenge(Challenge challenge) {
        return challengeService.updateChallenge(challenge);
    }

    @ResponseBody
    @RequestMapping(value = "deleteChallenge.do", method = RequestMethod.DELETE)
    public boolean deleteChallenge(Integer challengeId) {
        return challengeService.deleteChallenge(challengeId);
    }

    @ResponseBody
    @RequestMapping(value = "findChallengeName.do", method = RequestMethod.GET)
    public List<Challenge> findChallengeName(String challengeName) {
        return challengeService.findChallengeName(challengeName);
    }

    @ResponseBody
    @RequestMapping(value = "findAllChallenge.do", method = RequestMethod.GET)
    public PageInfo<Challenge> findAllChallenge(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                                @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        return challengeService.findAllChallenge(pageNum, pageSize);
    }
}
