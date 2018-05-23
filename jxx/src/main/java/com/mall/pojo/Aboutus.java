package com.mall.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 关于我们表：aboutus
 */
@ApiModel(value = "Aboutus")
public class Aboutus {

    @ApiModelProperty(value = "ID")
    private Integer aboutusId;

    @ApiModelProperty(value = "内容")
    private String aboutContent;

    public Aboutus(Integer aboutusId, String aboutContent) {
        this.aboutusId = aboutusId;
        this.aboutContent = aboutContent;
    }

    public Aboutus() {
        super();
    }

    public Integer getAboutusId() {
        return aboutusId;
    }

    public void setAboutusId(Integer aboutusId) {
        this.aboutusId = aboutusId;
    }

    public String getAboutContent() {
        return aboutContent;
    }

    public void setAboutContent(String aboutContent) {
        this.aboutContent = aboutContent == null ? null : aboutContent.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", aboutusId=").append(aboutusId);
        sb.append(", aboutContent=").append(aboutContent);
        sb.append("]");
        return sb.toString();
    }
}