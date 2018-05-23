package com.mall.dao;

import com.github.pagehelper.PageInfo;
import com.mall.common.ServerResponse;
import com.mall.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    //根据ID去查询，返回list列表
    int deleteByPrimaryKey(Integer userId);


    int insert(User record);

    int insertSelective(User record);

    int getByUserId(String userName);

    User selectByPrimaryKey(Integer userId);

    //用户登陆
    User selectByuserName(@Param("userName") String userName, @Param("userPassword") String userPassword);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    //用户密码更改
    int updatePassword(@Param("userName") String userName, @Param("userPassword") String userPassword);

    public User getByUserName(String username);

    //管理员登陆
    List<User> selectByadminName(@Param("userName") String userName, @Param("userPassword") String userPassword, @Param("userAdministrators") Integer userAdministrators);

    //检验用户名是否存在
    int checkuserName(String userName);

    //检验邮箱是否存在
    int checkuserEmail(String userEmail);

    //校验手机号
    int checkuserPhone(String userPhone);


    //获取所有用户
    List<PageInfo> gInformation();

}