package com.ch07.repository.shop.impl;

import com.ch07.entity.shop.Product;
import com.ch07.repository.shop.ProductRepository;
import com.ch07.repository.shop.custom.ProductRepositoryCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepositoryCustom {


    @Override
    public List<Product> selectProduct() {
        return List.of();
    }

    @Override
    public List<Product> selectProductcompnay(String company) {
        return List.of();
    }

    @Override
    public Product searchProduct(int prodNo) {
        return null;
    }
}
