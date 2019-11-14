package com.springboot.Account.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * <br>Title: Account
 * <br>Description: 类功能描述
 * <br>Author:dream (983214499@qq.com)
 * <br>Date:2019/11/9/15:00
 */

@Data
public class Account {

    private Integer id;
    private Integer price;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date created;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endtime;
    private Integer types;
    private String note;
    private String type;
    private String imgurl;
    private String name;

}
