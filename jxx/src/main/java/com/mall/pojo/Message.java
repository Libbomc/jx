package com.mall.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 留言表：message
 */
@ApiModel(value = "Message")
public class Message {
    @ApiModelProperty(value = "ID")
    private Integer messageId;

    @ApiModelProperty(value = "留言用户名")
    private String messageName;

    @ApiModelProperty(value = "问题描述")
    private String messageContent;

    @ApiModelProperty(value = "电话号码")
    private Long messagePhone;

    public Message(Integer messageId, String messageName, String messageContent, Long messagePhone) {
        this.messageId = messageId;
        this.messageName = messageName;
        this.messageContent = messageContent;
        this.messagePhone = messagePhone;
    }

    public Message() {
        super();
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public String getMessageName() {
        return messageName;
    }

    public void setMessageName(String messageName) {
        this.messageName = messageName == null ? null : messageName.trim();
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent == null ? null : messageContent.trim();
    }

    public Long getMessagePhone() {
        return messagePhone;
    }

    public void setMessagePhone(Long messagePhone) {
        this.messagePhone = messagePhone;
    }
}