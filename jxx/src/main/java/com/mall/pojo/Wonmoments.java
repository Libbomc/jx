package com.mall.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 精彩瞬间：Wonmoments
 */
@ApiModel(value = "Wonmoments")
public class Wonmoments {

    @ApiModelProperty(value = "ID")
    private Integer wonmomentId;

    @ApiModelProperty(value = "主题")
    private String wonmomentTitle;

    @ApiModelProperty(value = "内容")
    private String wonmomentContent;

    @ApiModelProperty(value = "图片地址")
    private String wonmomentUrl;

    public Wonmoments(Integer wonmomentId, String wonmomentTitle, String wonmomentContent, String wonmomentUrl) {
        this.wonmomentId = wonmomentId;
        this.wonmomentTitle = wonmomentTitle;
        this.wonmomentContent = wonmomentContent;
        this.wonmomentUrl = wonmomentUrl;
    }

    public Wonmoments() {
        super();
    }

    public Integer getWonmomentId() {
        return wonmomentId;
    }

    public void setWonmomentId(Integer wonmomentId) {
        this.wonmomentId = wonmomentId;
    }

    public String getWonmomentTitle() {
        return wonmomentTitle;
    }

    public void setWonmomentTitle(String wonmomentTitle) {
        this.wonmomentTitle = wonmomentTitle == null ? null : wonmomentTitle.trim();
    }

    public String getWonmomentContent() {
        return wonmomentContent;
    }

    public void setWonmomentContent(String wonmomentContent) {
        this.wonmomentContent = wonmomentContent == null ? null : wonmomentContent.trim();
    }

    public String getWonmomentUrl() {
        return wonmomentUrl;
    }

    public void setWonmomentUrl(String wonmomentUrl) {
        this.wonmomentUrl = wonmomentUrl == null ? null : wonmomentUrl.trim();
    }
}