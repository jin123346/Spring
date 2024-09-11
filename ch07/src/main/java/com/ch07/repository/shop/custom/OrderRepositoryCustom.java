package com.ch07.repository.shop.custom;

import com.ch07.entity.shop.Order;
import com.ch07.entity.shop.QOrder;

import java.util.List;

public interface OrderRepositoryCustom {


    public List<Order> selectOrder();
    public Order selectOrder(int orderId);

    public List<Order> selectProjectionOrder();


}
