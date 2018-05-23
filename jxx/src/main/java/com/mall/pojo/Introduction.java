package com.mall.pojo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 运动介绍表：introduction
 */
@ApiModel(value = "Introduction")
public class Introduction {

    @ApiModelProperty(value = "Id")
    private Integer introductionId;

    @ApiModelProperty(value = "描述")
    private String introductionDescribe;

    @ApiModelProperty(value = "分类")
    private String introductionGenre;

    @ApiModelProperty(value = "主题")
    private String introductionTitle;

    @ApiModelProperty(value = "图片地址")
    private String intoductionUrl;

    public Introduction(Integer introductionId, String introductionDescribe, String introductionGenre, String introductionTitle, String intoductionUrl) {
        this.introductionId = introductionId;
        this.introductionDescribe = introductionDescribe;
        this.introductionGenre = introductionGenre;
        this.introductionTitle = introductionTitle;
        this.intoductionUrl = intoductionUrl;
    }

    public Introduction() {
        super();
    }

    public Integer getIntroductionId() {
        return introductionId;
    }

    public void setIntroductionId(Integer introductionId) {
        this.introductionId = introductionId;
    }

    public String getIntroductionDescribe() {
        return introductionDescribe;
    }

    public void setIntroductionDescribe(String introductionDescribe) {
        this.introductionDescribe = introductionDescribe == null ? null : introductionDescribe.trim();
    }

    public String getIntroductionGenre() {
        return introductionGenre;
    }

    public void setIntroductionGenre(String introductionGenre) {
        this.introductionGenre = introductionGenre == null ? null : introductionGenre.trim();
    }

    public String getIntroductionTitle() {
        return introductionTitle;
    }

    public void setIntroductionTitle(String introductionTitle) {
        this.introductionTitle = introductionTitle == null ? null : introductionTitle.trim();
    }

    public String getIntoductionUrl() {
        return intoductionUrl;
    }

    public void setIntoductionUrl(String intoductionUrl) {
        this.intoductionUrl = intoductionUrl == null ? null : intoductionUrl.trim();
    }
}