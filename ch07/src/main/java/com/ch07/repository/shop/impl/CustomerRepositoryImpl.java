package com.ch07.repository.shop.impl;

import com.ch07.entity.shop.Customer;
import com.ch07.entity.shop.QCustomer;
import com.ch07.repository.shop.custom.CustomerRepositoryCustom;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.chrono.JapaneseChronology;
import java.util.List;


//customerRepository 확장 인터페이스 정의
@RequiredArgsConstructor
@Repository
public class CustomerRepositoryImpl implements CustomerRepositoryCustom {


    private final JPAQueryFactory jpaQueryFactory;

    private final QCustomer qCustomer=QCustomer.customer;


    @Override
    public List<Customer> selectCustomer() {
        return jpaQueryFactory
                .select(qCustomer)
                .from(qCustomer)
                .fetch();

    }

    @Override
    public Customer selectCustomer(int custId) {
        return jpaQueryFactory.selectFrom(qCustomer)
                .where(qCustomer.custId.eq(custId))
                .fetchOne();
    }

    @Override
    public List<Customer> selectProjectionCustomer() {
        // 필요한 필드만 가져옴
        return jpaQueryFactory.select(
                Projections.fields(
                        Customer.class,
                        qCustomer.custId,
                        qCustomer.age))
                .from(qCustomer).fetch();
    }

    @Override
    public List<Customer> searchCustomer(String nameCondition, int ageCondition) {

        BooleanBuilder builder = new BooleanBuilder();

        if(nameCondition != null) {
            builder.and(qCustomer.name.eq(nameCondition));
        }
        if(ageCondition > 0) {
            builder.and(qCustomer.age.goe(ageCondition));
        }


        return jpaQueryFactory
                .selectFrom(qCustomer)
                .where(builder)
                .fetch();
    }

    @Override
    public List<Customer> searchKeyword(String keyword) {

        //대소문자 포함하지 않고 하기
        BooleanExpression express = qCustomer.name.containsIgnoreCase(keyword)
                .or(qCustomer.addr.containsIgnoreCase(keyword));

        return jpaQueryFactory
                .selectFrom(qCustomer)
                .where(express)
                .fetch();
    }

    //도메인 클래스 선언
/*
    private QCustomer qCustomer = QCustomer.customer;
*/


/*


    @Override
    public List<Customer> selectCustomer() {

        //select * from customer
        return jpaQueryFactory
                .select(qCustomer)
                .from(qCustomer)
                .fetch();
    }

    @Override
    public Customer selectCustomer(int custId) {
        return jpaQueryFactory.selectFrom(qCustomer)
                .where(qCustomer.custId.eq(custId));
    }

    @Override
    public List<Customer> searchCustomer(String nameCondition, int ageCondition) {
        return List.of();
    }

    @Override
    public List<Customer> searchKeyword(String keyword) {
        return List.of();
    }*/



  
}
