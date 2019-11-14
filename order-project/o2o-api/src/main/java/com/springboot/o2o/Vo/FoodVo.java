package com.springboot.o2o.Vo;

import java.math.BigDecimal;

/**
 * <br>Title: FoodVo
 * <br>Description: 类功能描述
 * <br>Author:dream (983214499@qq.com)
 * <br>Date:2019/11/14/10:47
 */
public class FoodVo {

    private String id;
    private String name;
    private BigDecimal price;
    private String description;
    private String icon;

    @Override
    public String toString() {
        return "FoodVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
