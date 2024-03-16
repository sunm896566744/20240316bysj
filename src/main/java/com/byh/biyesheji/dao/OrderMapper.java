package com.byh.biyesheji.dao;

import com.byh.biyesheji.entity.ApplicationDocuments;
import com.byh.biyesheji.pojo.Order;
import com.byh.biyesheji.pojo.OrderExample;

import java.util.List;

public interface OrderMapper extends CrudDao<Order>{

    List<Order> selectByExample(OrderExample example);

    /**
     * 根据条件查询数据
     * @param order
     * @return
     */
    List<Order>  queryAll(Order order);

}