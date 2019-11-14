package com.springboot.o2o.Vo;


public enum CodeMeg {

    //请求成功
    SUCCESS(200, "操作成功"),
    //请求失败
    INTERNAL_ERROR(500, "服务器内部错误"),
    //商品模块  100xxx
    PRODUCT_NOT_EXIST(100001, "商品不存在"),
    //订单模块   200xxx
    ORDER_CLOSED(200001, "交易已关闭"),
    //用户模块   300xx
    LOGIN_FAIL(300001, "用户名或密码输入错误");

    private Integer code;
    private String msg;


    CodeMeg(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
