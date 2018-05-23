package com.mall.service;

import com.github.pagehelper.PageInfo;
import com.mall.common.ServerResponse;
import com.mall.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    //用户注册
    ServerResponse<User> addUser(User user);

    //用户登陆
    ServerResponse<User> findUserByuserName(String userName, String userPassword);

    //用户密码更新
    ServerResponse<String> update(String userName, String userPassword);

    public User getByUserName(String username);

    //管理员登陆
    List<User> selectByadminName(String userName, String userPassword, int userAdministrators);

    //检验用户名是否存在
    ServerResponse<User> checkuserNmae(String userName);

    //检验Email是否存在
    ServerResponse<User> checkuserEmail(String userEmail);


    ServerResponse<String> checkValid(String str, String type);

    //校验手机号
    ServerResponse<String> checkuserPhone(String userPhone);

    //根据ID修改信息
    ServerResponse<User> updateInformation(User user);

    //管理所有用户
    ServerResponse<PageInfo> gInformation(int pageNum, int pageSize);

}
