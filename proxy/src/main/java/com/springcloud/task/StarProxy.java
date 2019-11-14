package com.springcloud.task;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * <br>Title: StarProxy
 * <br>Description: 类功能描述
 * <br>Author:dream (983214499@qq.com)
 * <br>Date:2019/11/6/10:16
 */
public class StarProxy implements InvocationHandler {

    // 目标类，也就是被代理对象
    private Object target;

    public void setTarget(Object target)
    {
        this.target = target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
