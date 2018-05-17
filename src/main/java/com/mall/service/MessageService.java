package com.mall.service;

import com.github.pagehelper.PageInfo;
import com.mall.pojo.Message;

import java.util.List;

/**
 * Created by  on 2018/5/4.
 */
public interface MessageService {

    boolean addMessage(Message message);

    boolean deleteMessage(Integer messageId);

    boolean updateMessage(Message message);

    PageInfo<Message> findAllMessage(int pageNum, int pageSize);

    List<Message> findByName(String messageName);
}
