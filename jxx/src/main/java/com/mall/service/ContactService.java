package com.mall.service;

import com.mall.common.ServerResponse;
import com.mall.pojo.Contact;

import java.util.List;

/**
 * Created by on 2018/4/10.
 */
public interface ContactService {
    /**
     * 联系方式添加
     */
    boolean addContact(Contact contact);

    /**
     * 修改
     */
    boolean updateContact(Contact contact);

    /**
     * 删除
     */
    boolean deleteContact(Integer contactId);

}
