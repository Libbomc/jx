package com.mall.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 足迹表:footprint
 */
@ApiModel(value = "Footprint")
public class Footprint {

    @ApiModelProperty(value = "ID")
    private Integer footprintId;

    @ApiModelProperty(value = "足迹用户名")
    private String footprintName;

    @ApiModelProperty(value = "足迹")
    private String footprintFoot;

    public Footprint(Integer footprintId, String footprintName, String footprintFoot) {
        this.footprintId = footprintId;
        this.footprintName = footprintName;
        this.footprintFoot = footprintFoot;
    }

    public Footprint() {
        super();
    }

    public Integer getFootprintId() {
        return footprintId;
    }

    public void setFootprintId(Integer footprintId) {
        this.footprintId = footprintId;
    }

    public String getFootprintName() {
        return footprintName;
    }

    public void setFootprintName(String footprintName) {
        this.footprintName = footprintName == null ? null : footprintName.trim();
    }

    public String getFootprintFoot() {
        return footprintFoot;
    }

    public void setFootprintFoot(String footprintFoot) {
        this.footprintFoot = footprintFoot == null ? null : footprintFoot.trim();
    }
}