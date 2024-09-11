package com.ch07.repository.shop.impl;

import com.ch07.entity.shop.Order;
import com.ch07.repository.shop.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderRepositoryImplTest {

    @Autowired
    private OrderRepository repository;

    @Test
    void selectOrder() {
        List<Order> orders = repository.selectOrder();
        System.out.println(orders);
    }

    @Test
    void testSelectOrder() {
        Order order = repository.selectOrder(1);
        System.out.println(order);
    }

    @Test
    void selectProjectionOrder() {
        List<Order> orders = repository.selectProjectionOrder();
        System.out.println(orders);
    }
}