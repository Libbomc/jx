package com.mall.controller.portal;

import com.mall.pojo.Contact;
import com.mall.service.ContactService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by  on 2018/4/11.
 */
@Controller
@RequestMapping(value = "/jx/Contact/")
@Api(value = "ContactInfo", description = "联系信息表信息")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @RequestMapping(value = "addContact.do", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "联系信息添加", notes = "联系信息添加")
    public boolean addContact(Contact contact) {
        System.out.println("添加成功");
        return contactService.addContact(contact);
    }

    @RequestMapping(value = "updateContact.do", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "联系信息修改", notes = "联系信息修改")
    public boolean updateContact(Contact contact) {
        System.out.println("修改成功");
        return contactService.updateContact(contact);
    }

    @RequestMapping(value = "deleteContact.do", method = RequestMethod.DELETE)
    @ResponseBody
    @ApiOperation(value = "联系信息删除", notes = "联系信息删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "类型（删除：delete；默认为查看）", required = false, paramType = "delete"),
            @ApiImplicitParam(name = "id", value = "信息id", required = true, paramType = "delete")
    })
    public boolean deletaContact(Integer contactId) {
        System.out.println("删除成功");
        return contactService.deleteContact(contactId);
    }
}
