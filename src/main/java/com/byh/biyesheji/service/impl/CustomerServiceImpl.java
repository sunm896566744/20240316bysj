package com.byh.biyesheji.service.impl;

import com.byh.biyesheji.dao.ApplicationDocumentsMap;
import com.byh.biyesheji.dao.CustomerMapper;
import com.byh.biyesheji.entity.ApplicationDocuments;
import com.byh.biyesheji.pojo.Customer;
import com.byh.biyesheji.pojo.CustomerExample;
import com.byh.biyesheji.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private ApplicationDocumentsMap applicationDocumentsMap;
    @Override
    public Customer foreLogin(Customer customer) {
        CustomerExample example = new CustomerExample();
        example.createCriteria().andNameEqualTo(customer.getName()).andPasswordEqualTo(customer.getPassword());
        List<Customer> customers = customerMapper.selectByExample(example);

        return customers.size()>0?customers.get(0):null;
    }

    @Override
    public void save(Customer customer) {
        customerMapper.insert(customer);
    }

    @Override
    public Customer get(int cstid) {
        return customerMapper.selectByPrimaryKey(cstid);
    }

    @Override
    public List<Customer> list() {
        return customerMapper.selectByExample(null);
    }

    @Override
    public void shezhihuiyuan(int id) {
        customerMapper.enableStatus(id);
    }

    @Override
    public void updateDeliveryById(int id, int status) {
        // 先查询一下 确定
        Customer customer = customerMapper.selectByPrimaryKey(id);
        customer.setDelivery(status);
        customer.setId(id);
        customerMapper.updateByPrimaryKey(customer);
    }

    @Override
    public String saveApplicationDocuments(ApplicationDocuments obj) {
        ApplicationDocuments param = new ApplicationDocuments();
        param.setStatus(0);
        param.setCustomer(obj.getCustomer());
        List<ApplicationDocuments> list = applicationDocumentsMap.queryAll(param);
        if(list != null && list.size() > 0) {
            return "您已有在审批的单据，请稍后在申请！";
        }
        return applicationDocumentsMap.insert(obj) > 0 ? "success" : "error";
    }

    @Override
    public List<ApplicationDocuments> getApplicationDocumentsList(ApplicationDocuments applicationDocuments) {
        return applicationDocumentsMap.queryAll(applicationDocuments);
    }

    @Override
    public String aApproved(ApplicationDocuments obj) {
        // 同意
        if(obj.getStatus() == 1){
            updateDeliveryById(Integer.parseInt(obj.getCustomer()),obj.getStatus());
        }

        return applicationDocumentsMap.updateByPrimaryKey(obj) > 0  ? "success" : "error";
    }


    @Override
    public void del(int id) {
        customerMapper.deleteByPrimaryKey(id);
    }


}
