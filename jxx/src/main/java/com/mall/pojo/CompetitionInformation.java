package com.mall.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import sun.awt.SunHints;

/**
 * 比赛信息表：competitionInformation
 */
@ApiModel(value = "CompetitionInformation")
public class CompetitionInformation {

    @ApiModelProperty(value = "ID")
    private Integer competitionId;

    @ApiModelProperty(value = "比赛信息标题")
    private String competitionTitle;

    @ApiModelProperty(value = "比赛信息时间")
    private String competitionTime;

    @ApiModelProperty(value = "比赛信息种类")
    private String competitionType;

    public CompetitionInformation(Integer competitionId, String competitionTitle, String competitionTime, String competitionType) {
        this.competitionId = competitionId;
        this.competitionTitle = competitionTitle;
        this.competitionTime = competitionTime;
        this.competitionType = competitionType;
    }

    public CompetitionInformation() {
        super();
    }

    public Integer getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(Integer competitionId) {
        this.competitionId = competitionId;
    }

    public String getCompetitionTitle() {
        return competitionTitle;
    }

    public void setCompetitionTitle(String competitionTitle) {
        this.competitionTitle = competitionTitle == null ? null : competitionTitle.trim();
    }

    public String getCompetitionTime() {
        return competitionTime;
    }

    public void setCompetitionTime(String competitionTime) {
        this.competitionTime = competitionTime == null ? null : competitionTime.trim();
    }

    public String getCompetitionType() {
        return competitionType;
    }

    public void setCompetitionType(String competitionType) {
        this.competitionType = competitionType == null ? null : competitionType.trim();
    }
}