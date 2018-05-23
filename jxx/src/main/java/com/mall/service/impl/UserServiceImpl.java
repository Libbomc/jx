package com.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.mall.common.ServerResponse;
import com.mall.common.config.Const;
import com.mall.dao.UserMapper;

import com.mall.pojo.User;
import com.mall.service.UserService;
import com.mall.util.MD5Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public ServerResponse<User> addUser(User user) {
        ServerResponse response = this.checkValid(user.getUserName(), Const.USERNAME);
        System.out.println(user.getUserName());
        if (!response.isSuccess()) {
            return response;
        }
        ServerResponse response1 = this.checkValid(user.getUserEmail(), Const.EMAIL);
        if (!response1.isSuccess()) {
            return response1;
        }
        user.setUserRole(0);
        user.setUserPassword(MD5Util.MD5EncodeUtf8(user.getUserPassword()));
        int result = userMapper.insert(user);
        if (result == 0) {
            return ServerResponse.createByErrorMessage("注册失败");
        }
        return ServerResponse.createByErrorMessage("注册成功");
    }

    @Override
    public ServerResponse<User> findUserByuserName(String userName, String userPassword) {
        int result = userMapper.checkuserName(userName);
        if (result == 0) {
            ServerResponse.createByErrorMessage("用户名不存在");
        }
        String md5ps = MD5Util.MD5EncodeUtf8(userPassword);
        User user = userMapper.selectByuserName(userName, md5ps);
        if (user == null) {
            return ServerResponse.createByErrorMessage("密码错误");
        }
        return ServerResponse.createBySuccess("登陆成功", user);

    }

    @Override
    public ServerResponse<String> update(String userName, String userPassword) {
        int result = userMapper.updatePassword(userName, userPassword);
        if (result == 1) {
            ServerResponse.createBySuccessMessage("密码更改成功");
        }
        return ServerResponse.createBySuccessMessage("密码更改不成功");
    }

    @Override
    public User getByUserName(String username) {

        return userMapper.getByUserName(username);
    }

    @Override
    public List<User> selectByadminName(String userName, String userPassword, int userAdministrators) {
        System.out.println("serviceimpl");
        return userMapper.selectByadminName(userName, userPassword, userAdministrators);
    }

    @Override
    public ServerResponse<User> checkuserNmae(String userName) {
        return null;
    }

    @Override
    public ServerResponse<User> checkuserEmail(String userEmail) {
        return null;
    }

    @Override
    public ServerResponse<String> checkValid(String str, String type) {
        if (org.apache.commons.lang3.StringUtils.isNotBlank(type)) {
            //开始校验
            if (Const.USERNAME.equals(type)) {
                int resultCount = userMapper.checkuserName(str);
                if (resultCount > 0) {
                    return ServerResponse.createByErrorMessage("用户名已存在");
                }
            }
            if (Const.EMAIL.equals(type)) {
                int resultCount = userMapper.checkuserEmail(str);
                if (resultCount > 0) {
                    return ServerResponse.createByErrorMessage("email已存在");
                }
            }
        } else {
            return ServerResponse.createByErrorMessage("参数错误");
        }
        return ServerResponse.createBySuccessMessage("校验成功");
    }

    @Override
    public ServerResponse<String> checkuserPhone(String userPhone) {
        int result = userMapper.checkuserPhone(userPhone);
        if (result == 0) {
            return ServerResponse.createByErrorMessage("手机号不存在");
        }
        return ServerResponse.createBySuccess("手机号存在", userPhone);
    }

    @Override
    public ServerResponse<User> updateInformation(User user) {
        int getid = userMapper.getByUserId(user.getUserName());
        System.out.println(getid);
        User u = new User();
        u.setUserId(getid);
        u.setUserName(user.getUserName());
        u.setUserPassword(MD5Util.MD5EncodeUtf8(user.getUserPassword()));
        u.setUserEmail(user.getUserEmail());
        u.setUserPhone(user.getUserPhone());
        int result = userMapper.updateByPrimaryKey(u);
        if (result > 0) {
            return ServerResponse.createBySuccessMessage("更新成功");
        }
        return ServerResponse.createByErrorMessage("更新失败");
    }


    public List<User> UserListr(List<User> userList) {
        List<User> orderVoList = Lists.newArrayList();
        orderVoList.add((User) userList);
        return orderVoList;
    }

    @Override
    public ServerResponse<PageInfo> gInformation(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<PageInfo> userList = userMapper.gInformation();
        //List<User> userList1=this.UserListr(userList);
        PageInfo pageInfo = new PageInfo();
        pageInfo.setList(userList);
        return ServerResponse.createBySuccess(pageInfo);
    }


}
