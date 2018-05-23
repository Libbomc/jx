package com.mall.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 联系方式表：contact
 */
@ApiModel(value = "Contact")
public class Contact {
    @ApiModelProperty(value = "ID")
    private Integer contactId;

    @ApiModelProperty(value = "用户名")
    private String contactName;

    @ApiModelProperty(value = "电子邮件")
    private String contactEmail;

    @ApiModelProperty(value = "电话")
    private Long contactPhone;

    @ApiModelProperty(value = "发送的信息")
    private String contactMessage;

    public Contact(Integer contactId, String contactName, String contactEmail, Long contactPhone, String contactMessage) {
        this.contactId = contactId;
        this.contactName = contactName;
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
        this.contactMessage = contactMessage;
    }

    public Contact() {
        super();
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail == null ? null : contactEmail.trim();
    }

    public Long getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(Long contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactMessage() {
        return contactMessage;
    }

    public void setContactMessage(String contactMessage) {
        this.contactMessage = contactMessage == null ? null : contactMessage.trim();
    }
}