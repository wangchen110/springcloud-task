package com.springboot.o2o.Vo;


/**
 * <br>Title: ResultVo
 * <br>Description: 类功能描述
 * <br>Author:dream (983214499@qq.com)
 * <br>Date:2019/11/13/20:37
 */

public class ResultVo<T> {

    private Integer code;
    private String msg;
    private T data;

    public static <T> ResultVo success(T data){//泛型方法
        ResultVo resultVo = new ResultVo();
        resultVo.setData(data);
        resultVo.setMsg(CodeMeg.SUCCESS.getMsg());
        resultVo.setCode(CodeMeg.SUCCESS.getCode());
        return resultVo;
    }

    public static <T> ResultVo error(CodeMeg codeMsg){//泛型方法
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(codeMsg.getCode());
        resultVo.setMsg(codeMsg.getMsg());
        return resultVo;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
