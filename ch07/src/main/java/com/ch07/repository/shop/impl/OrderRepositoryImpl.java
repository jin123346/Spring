package com.ch07.repository.shop.impl;

import com.ch07.entity.shop.Order;
import com.ch07.entity.shop.QOrder;
import com.ch07.repository.shop.custom.OrderRepositoryCustom;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
@RequiredArgsConstructor
@Repository
public class OrderRepositoryImpl implements OrderRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    private final QOrder order=QOrder.order;


    @Override
    public List<Order> selectOrder() {
        return queryFactory
                .select(order).from(order).fetch();
    }

    @Override
    public Order selectOrder(int orderId) {
        return queryFactory
                .selectFrom(order)
                .where(order.orderId.eq(orderId)).fetchOne();
    }

    @Override
    public List<Order> selectProjectionOrder() {
        return queryFactory
                .select(
                        Projections.fields(
                                Order.class,
                                order.orderId,
                                order.orderPrice,
                                order.orderStatus)
                )
                .from(order)
                .fetch();
    }
}
