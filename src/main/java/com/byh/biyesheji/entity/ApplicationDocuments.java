package com.byh.biyesheji.entity;

import java.io.Serializable;

/**
 * (ApplicationDocuments)实体类
 *
 * @author sunming
 * @since 2024-03-16 11:00:50
 */
public class ApplicationDocuments implements Serializable {
    private static final long serialVersionUID = 454836061264460440L;
    /**
     * 客户id
     */
    private String customer;
    
    private Integer id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 身份证
     */
    private String idnumber;
    /**
     * 电话
     */
    private String phone;
    /**
     * 理由
     */
    private String reason;
    /**
     * 状态
     */
    private Integer status;


    public ApplicationDocuments(String customer, String name, String idnumber, String phone, String reason, Integer status) {
        this.customer = customer;
        this.name = name;
        this.idnumber = idnumber;
        this.phone = phone;
        this.reason = reason;
        this.status = status;
    }
    public ApplicationDocuments(){

    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}

