package com.demo.thread.udemy.tutorial.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
    private String productId;
    private ProductInfo productInfo;
    private Review review;
}
