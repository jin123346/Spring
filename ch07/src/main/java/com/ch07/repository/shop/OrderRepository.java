package com.ch07.repository.shop;

import com.ch07.entity.shop.Order;
import com.ch07.entity.shop.Product;
import com.ch07.repository.shop.custom.OrderRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> , OrderRepositoryCustom {
}
