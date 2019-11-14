package com.springboot.o2o.Vo;

import java.util.List;

/**
 * <br>Title: CategoryVo
 * <br>Description: 类功能描述
 * <br>Author:dream (983214499@qq.com)
 * <br>Date:2019/11/14/10:46
 */

public class CategoryVo {

    private String name;
    private Integer type;
    private List<FoodVo> foods;

    @Override
    public String toString() {
        return "CategoryVo{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", foods=" + foods +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public List<FoodVo> getFoods() {
        return foods;
    }

    public void setFoods(List<FoodVo> foods) {
        this.foods = foods;
    }
}
