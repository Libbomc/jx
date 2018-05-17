package com.mall.controller.portal;

import com.github.pagehelper.PageInfo;
import com.mall.pojo.Introduction;
import com.mall.pojo.Message;
import com.mall.pojo.User;
import com.mall.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by  on 2018/5/4.
 * 用户留言
 */
@Controller
@RequestMapping(value = "/jx/Message/")
public class MessageController {

    @Autowired
    private MessageService messageService;

    //用户留言添加
    @RequestMapping(value = "addMessage.do", method = RequestMethod.POST)
    @ResponseBody
    private boolean addMessage(Message message) {
        return messageService.addMessage(message);
    }

    //用户留言更新
    @RequestMapping(value = "updateMessage.do", method = RequestMethod.POST)
    @ResponseBody
    private boolean updateMessage(Message message) {
        return messageService.updateMessage(message);
    }

    //用户留言删除
    @RequestMapping(value = "deleteMessage.do", method = RequestMethod.DELETE)
    @ResponseBody
    private boolean deleteMessage(int messageId) {
        return messageService.deleteMessage(messageId);
    }

    //用户留言查询单个，按名称来查
    @RequestMapping(value = "findByMessageName.do", method = RequestMethod.GET)
    @ResponseBody
    private List<Message> findByMessageName(String messageName) {
        return messageService.findByName(messageName);
    }

    //用户留言查询所有
    @RequestMapping(value = "findAllMessage.do", method = RequestMethod.GET)
    @ResponseBody
    private PageInfo<Message> findAllMessage(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                             @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        System.out.println("查询所有");
        return messageService.findAllMessage(pageNum, pageSize);
    }
}
