package com.springcloud.task;

/**
 * <br>Title: LiuDeHua
 * <br>Description: 类功能描述
 * <br>Author:dream (983214499@qq.com)
 * <br>Date:2019/11/6/10:14
 */
public class LiuDeHua implements proxys {


    @Override
    public String sing(String name) {
        System.out.println("给我一杯忘情水");
        return "唱完";
    }

    @Override
    public String dance(String name) {
        System.out.println("开心的马骝");
        return "跳完";
    }
}
