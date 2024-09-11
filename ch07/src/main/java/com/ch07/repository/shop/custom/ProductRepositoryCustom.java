package com.ch07.repository.shop.custom;

import com.ch07.entity.shop.Product;

import java.util.List;

public interface ProductRepositoryCustom {
    public List<Product> selectProduct();
    public List<Product> selectProductcompnay(String company);

    public Product searchProduct(int prodNo);
}
