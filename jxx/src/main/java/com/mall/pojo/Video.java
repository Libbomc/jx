package com.mall.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 视频剪辑表:video
 */
@ApiModel(value = "Video")
public class Video {

    @ApiModelProperty(value = "ID")
    private Integer videoId;

    @ApiModelProperty(value = "主题")
    private String videoTitle;

    @ApiModelProperty(value = "内容表达")
    private String videoContent;

    @ApiModelProperty(value = "视频位置")
    private String videoLocation;

    public Video(Integer videoId, String videoTitle, String videoContent, String videoLocation) {
        this.videoId = videoId;
        this.videoTitle = videoTitle;
        this.videoContent = videoContent;
        this.videoLocation = videoLocation;
    }

    public Video() {
        super();
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle == null ? null : videoTitle.trim();
    }

    public String getVideoContent() {
        return videoContent;
    }

    public void setVideoContent(String videoContent) {
        this.videoContent = videoContent == null ? null : videoContent.trim();
    }

    public String getVideoLocation() {
        return videoLocation;
    }

    public void setVideoLocation(String videoLocation) {
        this.videoLocation = videoLocation == null ? null : videoLocation.trim();
    }
}