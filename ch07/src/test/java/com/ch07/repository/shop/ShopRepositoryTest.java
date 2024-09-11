package com.ch07.repository.shop;


import com.ch07.entity.shop.Customer;
import com.ch07.entity.shop.Order;
import com.ch07.entity.shop.OrderItem;
import com.ch07.entity.shop.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ShopRepositoryTest {


    @Autowired private CustomerRepository customerRepository;
    @Autowired private ProductRepository productRepository;
    @Autowired private OrderRepository orderRepository;
    @Autowired private OrderItemRepository orderItemRepository;

    @Test
    void InsertCustomerTest(){
        Customer customer = Customer.builder()
                .custId(1)
                .name("홍길동")
                .addr("전라도")
                .hp("010-1111-1111")
                .build();

        customerRepository.save(customer);

    }

    //product insert
    @Test
    void insertProductTest(){
        Product product = Product.builder()
                .prodNo(3)
                .prodName("김치사발면")
                .price(1200)
                .stock(200)
                .company("농심")
                .build();
        productRepository.save(product);

    }

    //order
    @Test
    void insertOrderTest(){
        Customer customer = Customer.builder()
                .custId(1)
                .build();
        Order order = Order.builder()
                .orderId(1)
                .customer(customer)
                .orderStatus(1)
                .orderPrice(25000)
                .build();

        orderRepository.save(order);
    }

    @Test
    void insertOrderItemTest(){
        Order order = Order.builder()
                .orderId(1)
                .build();

        Product product = Product.builder()
                .prodNo(3)
                .build();

        OrderItem orderItem = OrderItem.builder()
                .order(order)
                .product(product)
                .count(2)
                .build();

        orderItemRepository.save(orderItem);
    }




}
