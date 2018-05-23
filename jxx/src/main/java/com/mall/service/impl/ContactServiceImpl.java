package com.mall.service.impl;

import com.mall.common.ServerResponse;
import com.mall.dao.ContactMapper;
import com.mall.pojo.Contact;
import com.mall.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by  on 2018/4/10.
 */
@Service("ContactService")
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactMapper contactMapper;

    @Override
    public boolean addContact(Contact contact) {
        boolean flag = false;
        try {
            contactMapper.insert(contact);
            flag = true;
        } catch (Exception e) {
            System.out.println("添加失败");
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean updateContact(Contact contact) {
        boolean flag = false;
        try {
            contactMapper.updateByPrimaryKeySelective(contact);
            flag = true;
        } catch (Exception e) {
            System.out.println("修改失败");
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean deleteContact(Integer contactId) {
        boolean flag = false;
        try {
            contactMapper.deleteByPrimaryKey(contactId);
            flag = true;

        } catch (Exception e) {
            System.out.println("删除失败");
            e.printStackTrace();
        }

        return flag;
    }
}
