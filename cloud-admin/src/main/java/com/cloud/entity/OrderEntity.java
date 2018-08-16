package com.cloud.entity;

import java.io.Serializable;

public class OrderEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    public OrderEntity(int id,String orderSn)
    {
        this.id=id;
        this.orderSn=orderSn;
    }

    private int id;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    private String orderSn;
}
