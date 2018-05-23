package com.mall.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 极限百科表：encyclopedia
 */
@ApiModel(value = "Encyclopedia")
public class Encyclopedia {

    @ApiModelProperty(value = "ID")
    private Integer encyclopediaId;

    @ApiModelProperty(value = "类别")
    private String encyclopediaGenre;

    @ApiModelProperty(value = "主题")
    private String encyclopediaTitle;

    @ApiModelProperty(value = "介绍")
    private String encyclopediaIntroduction;

    @ApiModelProperty(value = "图片地址")
    private String encyclopediaUrl;

    public Encyclopedia(Integer encyclopediaId, String encyclopediaGenre, String encyclopediaTitle, String encyclopediaIntroduction, String encyclopediaUrl) {
        this.encyclopediaId = encyclopediaId;
        this.encyclopediaGenre = encyclopediaGenre;
        this.encyclopediaTitle = encyclopediaTitle;
        this.encyclopediaIntroduction = encyclopediaIntroduction;
        this.encyclopediaUrl = encyclopediaUrl;
    }

    public Encyclopedia() {
        super();
    }

    public Integer getEncyclopediaId() {
        return encyclopediaId;
    }

    public void setEncyclopediaId(Integer encyclopediaId) {
        this.encyclopediaId = encyclopediaId;
    }

    public String getEncyclopediaGenre() {
        return encyclopediaGenre;
    }

    public void setEncyclopediaGenre(String encyclopediaGenre) {
        this.encyclopediaGenre = encyclopediaGenre == null ? null : encyclopediaGenre.trim();
    }

    public String getEncyclopediaTitle() {
        return encyclopediaTitle;
    }

    public void setEncyclopediaTitle(String encyclopediaTitle) {
        this.encyclopediaTitle = encyclopediaTitle == null ? null : encyclopediaTitle.trim();
    }

    public String getEncyclopediaIntroduction() {
        return encyclopediaIntroduction;
    }

    public void setEncyclopediaIntroduction(String encyclopediaIntroduction) {
        this.encyclopediaIntroduction = encyclopediaIntroduction == null ? null : encyclopediaIntroduction.trim();
    }

    public String getEncyclopediaUrl() {
        return encyclopediaUrl;
    }

    public void setEncyclopediaUrl(String encyclopediaUrl) {
        this.encyclopediaUrl = encyclopediaUrl == null ? null : encyclopediaUrl.trim();
    }
}