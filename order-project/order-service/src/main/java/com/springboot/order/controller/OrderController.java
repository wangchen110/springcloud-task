package com.springboot.order.controller;

import com.springboot.o2o.Vo.CategoryVo;
import com.springboot.o2o.Vo.CodeMeg;
import com.springboot.o2o.Vo.ResultVo;
import com.springboot.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * <br>Title: OrderController
 * <br>Description: 类功能描述
 * <br>Author:dream (983214499@qq.com)
 * <br>Date:2019/11/12/20:27
 */
@RestController
@CrossOrigin
public class OrderController {


    @Autowired
    private OrderService orderService;

   @RequestMapping("/list")
    public ResultVo<List<CategoryVo>> list()
   {
       List<CategoryVo> list = orderService.list();
       if(list!=null)
       {
           return ResultVo.success(list);
       }
       return ResultVo.error(CodeMeg.PRODUCT_NOT_EXIST);
   }

}
