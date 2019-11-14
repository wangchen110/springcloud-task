package com.springboot.order.dao;

import com.springboot.o2o.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<Category,Integer> {

}
