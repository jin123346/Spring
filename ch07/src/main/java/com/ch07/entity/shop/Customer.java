package com.ch07.entity.shop;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name="shop_Customer")
public class Customer {

    @Id
    private int custId;
    private int age;
    private String name;
    private String hp;
    private String addr;

    @CreationTimestamp
    private LocalDateTime redate;

}
