package com.mall.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 自我挑战表:challenge
 */
@ApiModel(value = "Challenge")
public class Challenge {

    @ApiModelProperty(value = "ID")
    private Integer challengeId;

    @ApiModelProperty(value = "自我挑战的用户名")
    private String challengeName;

    @ApiModelProperty(value = "挑战")
    private String challengeChall;

    @ApiModelProperty(value = "开始时间")
    private Date challengeTime;

    public Challenge(Integer challengeId, String challengeName, String challengeChall, Date challengeTime) {
        this.challengeId = challengeId;
        this.challengeName = challengeName;
        this.challengeChall = challengeChall;
        this.challengeTime = challengeTime;
    }

    public Challenge() {
        super();
    }

    public Integer getChallengeId() {
        return challengeId;
    }

    public void setChallengeId(Integer challengeId) {
        this.challengeId = challengeId;
    }

    public String getChallengeName() {
        return challengeName;
    }

    public void setChallengeName(String challengeName) {
        this.challengeName = challengeName == null ? null : challengeName.trim();
    }

    public String getChallengeChall() {
        return challengeChall;
    }

    public void setChallengeChall(String challengeChall) {
        this.challengeChall = challengeChall == null ? null : challengeChall.trim();
    }

    public Date getChallengeTime() {
        return challengeTime;
    }

    public void setChallengeTime(Date challengeTime) {
        this.challengeTime = challengeTime;
    }

}