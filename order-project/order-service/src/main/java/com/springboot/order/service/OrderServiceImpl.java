package com.springboot.order.service;

import com.springboot.o2o.Vo.CategoryVo;
import com.springboot.o2o.Vo.FoodVo;
import com.springboot.o2o.pojo.Category;
import com.springboot.o2o.pojo.Food;
import com.springboot.order.dao.FoodDao;
import com.springboot.order.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <br>Title: OrderServiceImpl
 * <br>Description: 类功能描述
 * <br>Author:dream (983214499@qq.com)
 * <br>Date:2019/11/13/20:31
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private FoodDao foodDao;

    @Override
    public List<CategoryVo> list() {
        List<CategoryVo> CategoryVos = new ArrayList<>();
        List<Category> all = orderDao.findAll();
        all.forEach(category -> {
            CategoryVo categoryVo = new CategoryVo();
            categoryVo.setName(category.getCategoryName());
            categoryVo.setType(category.getCategoryType());

            List<FoodVo> FoodVos = new ArrayList<>();
            List<Food> foods = foodDao.findByCategoryType(category.getCategoryType());
            foods.forEach(food -> {
                FoodVo foodVo = new FoodVo();
                foodVo.setDescription(food.getProductDescription());
                foodVo.setIcon(food.getProductIcon());
                foodVo.setId(food.getProductId());
                foodVo.setName(food.getProductName());
                FoodVos.add(foodVo);
            });
            categoryVo.setFoods(FoodVos);
            CategoryVos.add(categoryVo);
        });
        return CategoryVos;
    }
}
