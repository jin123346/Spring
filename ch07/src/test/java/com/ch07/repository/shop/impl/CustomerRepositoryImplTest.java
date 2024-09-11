package com.ch07.repository.shop.impl;

import com.ch07.entity.shop.Customer;
import com.ch07.repository.shop.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerRepositoryImplTest {


    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void selectCustomers(){
        List<Customer> customers = customerRepository.selectCustomer();
        System.out.println(customers);
    }


    @Test
    public void selectProjectionCustomer(){
        List<Customer> customers = customerRepository.selectProjectionCustomer();
        System.out.println(customers);
    }
    @Test
    public void selectCustomer(){
       Customer customer= customerRepository.selectCustomer(1);
        System.out.println(customer);
    }


    @Test
    public void searchCustomer(){
        String namecondition = "길동";
        int agecondition = 11;

       List<Customer> customers= customerRepository.searchCustomer(namecondition, agecondition);

       System.out.println(customers);



    }


    @Test
    public void searchKeyword(){

        String keyword="길동";
        List<Customer> customers= customerRepository.searchKeyword(keyword);
        System.out.println(customers);
    }
}