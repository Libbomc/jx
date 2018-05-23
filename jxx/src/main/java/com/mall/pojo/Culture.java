package com.mall.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 文化板块：culture
 */
@ApiModel(value = "Culture")
public class Culture {
    @ApiModelProperty(value = "ID")
    private Integer cultureId;

    @ApiModelProperty(value = "类别")
    private String cultureGenre;

    @ApiModelProperty(value = "名称")
    private String cultureName;

    @ApiModelProperty(value = "介绍")
    private String cultrueIntrodution;

    @ApiModelProperty(value = "图片")
    private String cultrueUrl;

    public Culture(Integer cultureId, String cultureGenre, String cultureName, String cultrueIntrodution, String cultrueUrl) {
        this.cultureId = cultureId;
        this.cultureGenre = cultureGenre;
        this.cultureName = cultureName;
        this.cultrueIntrodution = cultrueIntrodution;
        this.cultrueUrl = cultrueUrl;
    }
    public Culture() {
        super();
    }

    public Integer getCultureId() {
        return cultureId;
    }

    public void setCultureId(Integer cultureId) {
        this.cultureId = cultureId;
    }

    public String getCultureGenre() {
        return cultureGenre;
    }

    public void setCultureGenre(String cultureGenre) {
        this.cultureGenre = cultureGenre == null ? null : cultureGenre.trim();
    }

    public String getCultureName() {
        return cultureName;
    }

    public void setCultureName(String cultureName) {
        this.cultureName = cultureName == null ? null : cultureName.trim();
    }

    public String getCultrueIntrodution() {
        return cultrueIntrodution;
    }

    public void setCultrueIntrodution(String cultrueIntrodution) {
        this.cultrueIntrodution = cultrueIntrodution == null ? null : cultrueIntrodution.trim();
    }

    public String getCultrueUrl() {
        return cultrueUrl;
    }

    public void setCultrueUrl(String cultrueUrl) {
        this.cultrueUrl = cultrueUrl == null ? null : cultrueUrl.trim();
    }
}