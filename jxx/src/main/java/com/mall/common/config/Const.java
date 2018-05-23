package com.mall.common.config;

public class Const {

    public static final String CURRENT_USER = "currentUser";

    public static final String EMAIL = "userEmail";
    public static final String USERNAME = "userName";

    public interface Role {
        int ROLE_CUSTOMER = 0; //普通用户
        int ROLE_ADMIN = 1;//管理员
    }


}
