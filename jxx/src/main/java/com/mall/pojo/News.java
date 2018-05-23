package com.mall.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 赛事新闻表:news
 */
@ApiModel(value = "News")
public class News {
    @ApiModelProperty(value = "ID")
    private Integer newsId;

    @ApiModelProperty(value = "主题")
    private String newsTitle;

    @ApiModelProperty(value = "内容")
    private String newsContent;

    @ApiModelProperty(value = "图片地址")
    private String newUrl;

    public News(Integer newsId, String newsTitle, String newsContent, String newUrl) {
        this.newsId = newsId;
        this.newsTitle = newsTitle;
        this.newsContent = newsContent;
        this.newUrl = newUrl;
    }

    public News() {
        super();
    }

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle == null ? null : newsTitle.trim();
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent == null ? null : newsContent.trim();
    }

    public String getNewUrl() {
        return newUrl;
    }

    public void setNewUrl(String newUrl) {
        this.newUrl = newUrl == null ? null : newUrl.trim();
    }
}