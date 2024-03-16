package com.byh.biyesheji.service;

import com.byh.biyesheji.entity.ApplicationDocuments;
import com.byh.biyesheji.pojo.Customer;

import java.util.List;

public interface CustomerService extends CrudService<Customer>{

    /**
     * 返回登陆的用户
     * @param customer
     * @return
     */
    public Customer foreLogin(Customer customer);

    /**
     * 设置会员
     * @param id
     */
    public void shezhihuiyuan(int id);


    void updateDeliveryById(int id, int status);

    /**
     * 保存申请为配送员
     * @param obj
     * @return
     */
    String saveApplicationDocuments(ApplicationDocuments obj);

    /**
     * 查询配送员申请单
     * @return
     */
    List<ApplicationDocuments> getApplicationDocumentsList(ApplicationDocuments applicationDocuments);

    /**
     * 审批通过
     * @param obj
     * @return
     */
    String aApproved(ApplicationDocuments obj);
}
