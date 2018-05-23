package com.mall.common;


/**
 * Created by pritytime on 2018/1/17.
 */
public enum ResponseCode {
    SUCCESS(0, "SUCCESS"),//成功
    ERROR(1, "ERROR"),//错误
    MEED_LOGIN(10, "MEED_LOGIN"),//需要登录
    ILLEGAI_ARGUMENT(2, "ILLEGAI_ARGUMENT");//非法

    private final int code;
    private final String desc;

    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
