package com.mall.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 关注表:follow
 */
@ApiModel(value = "Follow")
public class Follow {

    @ApiModelProperty(value = "ID")
    private Integer followId;

    @ApiModelProperty(value = "关注用户名")
    private String followName;

    public Follow(Integer followId, String followName) {
        this.followId = followId;
        this.followName = followName;
    }

    public Follow() {
        super();
    }

    public Integer getFollowId() {
        return followId;
    }

    public void setFollowId(Integer followId) {
        this.followId = followId;
    }

    public String getFollowName() {
        return followName;
    }

    public void setFollowName(String followName) {
        this.followName = followName == null ? null : followName.trim();
    }
}