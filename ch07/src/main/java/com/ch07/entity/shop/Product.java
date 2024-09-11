package com.ch07.entity.shop;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Table(name="shop_product")
@Entity
public class Product {

    @Id
    private int prodNo;

    private String prodName;

    private int stock;

    private int price;

    private String company;

}
