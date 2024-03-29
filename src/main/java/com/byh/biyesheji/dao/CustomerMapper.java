package com.byh.biyesheji.dao;

import com.byh.biyesheji.entity.ApplicationDocuments;
import com.byh.biyesheji.pojo.Customer;
import com.byh.biyesheji.pojo.CustomerExample;

import java.util.List;
import java.util.Map;

public interface CustomerMapper extends CrudDao<Customer>{

    List<Customer> selectByExample(CustomerExample example);

    /**
     * 开启用户会员状态
     * @param id
     */
    void enableStatus(int id);

    List<Map<String,Object>>deliveryCount();
}