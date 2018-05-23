package com.mall.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 赛事公告表:notice
 */
@ApiModel(value = "Notice")
public class Notice {
    @ApiModelProperty(value = "ID")
    private Integer noticeId;

    @ApiModelProperty(value = "主题")
    private String noticeTitle;

    @ApiModelProperty(value = "内容")
    private String noticeContent;

    @ApiModelProperty(value = "图片地址")
    private String noticeUrl;

    public Notice(Integer noticeId, String noticeTitle, String noticeContent, String noticeUrl) {
        this.noticeId = noticeId;
        this.noticeTitle = noticeTitle;
        this.noticeContent = noticeContent;
        this.noticeUrl = noticeUrl;
    }

    public Notice() {
        super();
    }

    public Integer getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Integer noticeId) {
        this.noticeId = noticeId;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle == null ? null : noticeTitle.trim();
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent == null ? null : noticeContent.trim();
    }

    public String getNoticeUrl() {
        return noticeUrl;
    }

    public void setNoticeUrl(String noticeUrl) {
        this.noticeUrl = noticeUrl == null ? null : noticeUrl.trim();
    }
}