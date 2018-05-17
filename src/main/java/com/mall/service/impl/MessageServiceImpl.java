package com.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mall.dao.MessageMapper;
import com.mall.pojo.Message;
import com.mall.pojo.User;
import com.mall.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by  on 2018/5/4.
 */
@Service("MessageService")
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper messageMapper;


    @Override
    public boolean addMessage(Message message) {
        boolean flag = false;

        try {
            messageMapper.insert(message);
            flag = true;
        } catch (Exception e) {
            System.out.println("留言失败");
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean deleteMessage(Integer messageId) {
        boolean flag = false;
        try {
            messageMapper.deleteByPrimaryKey(messageId);
            flag = true;
        } catch (Exception e) {
            System.out.println("删除失败");
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean updateMessage(Message message) {
        boolean flag = false;
        try {
            messageMapper.updateByPrimaryKeySelective(message);
            flag = true;
        } catch (Exception e) {
            System.out.println("更新失败");
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public PageInfo<Message> findAllMessage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Message> list = messageMapper.findAll();

        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Override
    public List<Message> findByName(String messageName) {
        return (List<Message>) messageMapper.findByMessageName(messageName);
    }
}
