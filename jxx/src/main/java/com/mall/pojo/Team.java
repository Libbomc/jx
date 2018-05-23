package com.mall.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 组建团队：team
 */
@ApiModel(value = "Team")
public class Team {
    @ApiModelProperty(value = "ID")
    private Integer teamId;

    @ApiModelProperty(value = "团队的名称")
    private String teamName;

    @ApiModelProperty(value = "团队人员")
    private String teamPeople;

    public Team(Integer teamId, String teamName, String teamPeople) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.teamPeople = teamPeople;
    }

    public Team() {
        super();
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName == null ? null : teamName.trim();
    }

    public String getTeamPeople() {
        return teamPeople;
    }

    public void setTeamPeople(String teamPeople) {
        this.teamPeople = teamPeople == null ? null : teamPeople.trim();
    }
}