package com.ch07.repository.shop;


import com.ch07.dto.CustomerDTO;
import com.ch07.dto.ProductAggDTO;
import com.ch07.entity.shop.*;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class ShopQueryDslTest {
    /*
        QueryDSL 설정
        1)의존성 추가
          - build.gradle의존성 추가
            implementation 'com.querydsl:querydsl-jpa:5.1.0:jakarta'
            annotationProcessor "com.querydsl:querydsl-apt:5.1.0:jakarta"
            annotationProcessor "jakarta.annotation:jakarta.annotation-api"
            annotationProcessor "jakarta.persistence:jakarta.persistence-api"

          - build.gradle 파일 QueryDSL 경로 및 환경설정
          - Q도메인 클래스 생성확인(애플리케이션 실행 상태확인) => 의존성 추가후 application server 구동
            main - generated  - q도메인파일확인

         2) QueryDSL 구현
          - 개별 Repository 확장 custom 인터페이스 생성
          - Custom 인터페이스구현하는 Impl 클래스 생성
          - Impl 클래스에서 QueryDSL 쿼리메서드 정의
          - 개별 repository에 extends custom interface 상속 추가


     */

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    private final QCustomer qCustomer = QCustomer.customer;
     private QOrder qOrder = QOrder.order;
    private QProduct qProduct = QProduct.product;

    @Test
    void test01(){
        List<Product> products = jpaQueryFactory.select(qProduct).from(qCustomer).fetch();
        System.out.println(products);
    }

    @Test
    void test02(){
      List<Product> products=  jpaQueryFactory
              .select(
                Projections.fields(
                        Product.class,
                        qProduct.prodNo,
                        qProduct.prodName,
                        qProduct.price
                )
              ).from(qProduct)
              .fetch();

        System.out.println(products);
    }

    @Test
    void test03(){

        List<Customer> customers1 =  jpaQueryFactory
                .selectFrom(qCustomer)
                .where(qCustomer.name.eq("김길동"))
                .fetch();

        List<Customer> customers2 =  jpaQueryFactory
                .selectFrom(qCustomer)
                .where(qCustomer.name.ne("김길동"))
                .fetch();


        System.out.println(customers1);
        System.out.println(customers2);
    }

    @Test
    void test04(){

        List<Customer> customers1 = jpaQueryFactory.selectFrom(qCustomer).where(qCustomer.age.gt(30)).fetch();
        List<Customer> customers2 = jpaQueryFactory.selectFrom(qCustomer).where(qCustomer.age.goe(30)).fetch();
        List<Customer> customers3 = jpaQueryFactory.selectFrom(qCustomer).where(qCustomer.age.lt(30)).fetch();
        List<Customer> customers4 = jpaQueryFactory.selectFrom(qCustomer).where(qCustomer.age.loe(30)).fetch();

        System.out.println(customers1);
        System.out.println(customers2);
        System.out.println(customers3);
        System.out.println(customers4);
    }

    @Test
    void test05(){
       List<Customer> customers =  jpaQueryFactory.selectFrom(qCustomer).where(qCustomer.addr.in("서울","부산")).fetch();
       System.out.println(customers);

    }


    @Test
    void test06(){
        List<Customer> customers =  jpaQueryFactory.selectFrom(qCustomer)
                .where(qCustomer.name.like("%신"))
                .fetch();

        System.out.println(customers);
    }

    @Test
    void test07(){

        List<Product> products = jpaQueryFactory.select(qProduct).from(qCustomer)
                .where(qProduct.stock.gt(0))
                .orderBy(qProduct.price.desc())
                .fetch();
        System.out.println(products);
    }

    @Test
    void test08(){
        List<Product> products = jpaQueryFactory.select(qProduct).from(qProduct)
                .where(qProduct.stock.gt(0))
                .orderBy(qProduct.price.asc())
                .offset(0)
                .limit(2)
                .fetch();
        System.out.println(products);
    }

    @Test
    void test09(){
        ProductAggDTO productAggDTO=  jpaQueryFactory.select(
                Projections.fields(
                    ProductAggDTO.class,
                        qProduct.price.sum().as("priceSum"),
                        qProduct.price.avg().as("priceAvg"),
                        qProduct.price.max().as("priceMax"),
                        qProduct.price.min().as("priceMin")
                )
        ).from(qProduct)
                .fetchOne();

        System.out.println(productAggDTO);
    }

    @Test
    void test10(){
       List<CustomerDTO> customerDTOS = jpaQueryFactory.select(
                    Projections.fields(
                            CustomerDTO.class,
                            qOrder.customer.custId,
                            qOrder.customer.name,
                            qOrder.customer.custId.count().as("orderCount")
                    )
                ).from(qOrder).where(qOrder.orderStatus.eq(1))
                .groupBy(qOrder.customer.custId)
                .having(qOrder.customer.custId.count().goe(1))
                .fetch();

        System.out.println(customerDTOS);
    }

    @Transactional
    @Test
    void test11(){
        List<Tuple> result= jpaQueryFactory.select(qOrder,qCustomer)
                .from(qOrder)
                .join(qCustomer)
                .on(qOrder.customer.eq(qCustomer))
                .fetch();
        System.out.println(result);
    }

}
