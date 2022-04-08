package com.demo.thread.udemy.tutorial.service;

import com.demo.thread.udemy.tutorial.model.ProductInfo;
import com.demo.thread.udemy.tutorial.model.ProductOption;

import java.util.List;

import static com.demo.thread.udemy.tutorial.util.CommonUtil.delay;


public class ProductInfoService {
    public ProductInfo retrieveProductInfo(String productId) {
        delay(1000);
        List<ProductOption> productOptions = List.of(new ProductOption(1, "64GB", "Black", 699.1),
                new ProductOption(2, "128GB", "White", 899.50));
        return ProductInfo.builder()
                .productId(productId)
                .productOptions(productOptions)
                .build();
    }
}
