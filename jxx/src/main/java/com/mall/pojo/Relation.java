package com.mall.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 关系表:relation
 */
@ApiModel(value = "Relation")
public class Relation {
    @ApiModelProperty(value = "ID")
    private Integer relationId;

    @ApiModelProperty(value = "关系uid")
    private Integer relationUid;

    @ApiModelProperty(value = "关系rid")
    private Integer relationRid;

    public Relation(Integer relationId, Integer relationUid, Integer relationRid) {
        this.relationId = relationId;
        this.relationUid = relationUid;
        this.relationRid = relationRid;
    }

    public Relation() {
        super();
    }

    public Integer getRelationId() {
        return relationId;
    }

    public void setRelationId(Integer relationId) {
        this.relationId = relationId;
    }

    public Integer getRelationUid() {
        return relationUid;
    }

    public void setRelationUid(Integer relationUid) {
        this.relationUid = relationUid;
    }

    public Integer getRelationRid() {
        return relationRid;
    }

    public void setRelationRid(Integer relationRid) {
        this.relationRid = relationRid;
    }
}