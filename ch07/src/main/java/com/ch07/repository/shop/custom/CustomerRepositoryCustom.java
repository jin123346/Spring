package com.ch07.repository.shop.custom;

import com.ch07.entity.shop.Customer;

import java.util.List;


//customerRepository 확장 인터페이스 정의
public interface CustomerRepositoryCustom {

    public List<Customer> selectCustomer();
    public Customer selectCustomer(int custId);
    public List<Customer> selectProjectionCustomer();

    public List<Customer> searchCustomer(String nameCondition, int ageCondition);
    public List<Customer> searchKeyword(String keyword);

}
