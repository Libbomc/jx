package com.mall.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 活动信息表：activities
 */
@ApiModel(value = "Activities")
public class Activities {

    @ApiModelProperty(value = "ID")
    private Integer activitiesId;

    @ApiModelProperty(value = "活动信息标题")
    private String activitiesTitle;

    @ApiModelProperty(value = "活动信息内容")
    private String activitiesContent;

    @ApiModelProperty(value = "活动信息时间")
    private String activitiesTime;

    @ApiModelProperty(value = "活动信息类属")
    private String activitiesType;

    @ApiModelProperty(value = "活动图片地址")
    private String activitiesUrl;

    public Activities(Integer activitiesId, String activitiesTitle, String activitiesContent, String activitiesTime, String activitiesType, String activitiesUrl) {
        this.activitiesId = activitiesId;
        this.activitiesTitle = activitiesTitle;
        this.activitiesContent = activitiesContent;
        this.activitiesTime = activitiesTime;
        this.activitiesType = activitiesType;
        this.activitiesUrl = activitiesUrl;
    }

    public Activities() {
        super();
    }

    public Integer getActivitiesId() {
        return activitiesId;
    }

    public void setActivitiesId(Integer activitiesId) {
        this.activitiesId = activitiesId;
    }

    public String getActivitiesTitle() {
        return activitiesTitle;
    }

    public void setActivitiesTitle(String activitiesTitle) {
        this.activitiesTitle = activitiesTitle == null ? null : activitiesTitle.trim();
    }

    public String getActivitiesContent() {
        return activitiesContent;
    }

    public void setActivitiesContent(String activitiesContent) {
        this.activitiesContent = activitiesContent == null ? null : activitiesContent.trim();
    }

    public String getActivitiesTime() {
        return activitiesTime;
    }

    public void setActivitiesTime(String activitiesTime) {
        this.activitiesTime = activitiesTime == null ? null : activitiesTime.trim();
    }

    public String getActivitiesType() {
        return activitiesType;
    }

    public void setActivitiesType(String activitiesType) {
        this.activitiesType = activitiesType == null ? null : activitiesType.trim();
    }

    public String getActivitiesUrl() {
        return activitiesUrl;
    }

    public void setActivitiesUrl(String activitiesUrl) {
        this.activitiesUrl = activitiesUrl == null ? null : activitiesUrl.trim();
    }
}