package com.springboot.order.dao;

import com.springboot.o2o.pojo.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodDao extends JpaRepository {

    List<Food> findByCategoryType(Integer categoryType);

}
