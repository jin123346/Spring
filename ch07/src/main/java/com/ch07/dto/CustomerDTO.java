package com.ch07.dto;


import lombok.Data;

@Data
public class CustomerDTO {

    private int custId;
    private int age;
    private String name;
    private String hp;
    private String addr;
    private String redate;

    private long orderCount;
}
