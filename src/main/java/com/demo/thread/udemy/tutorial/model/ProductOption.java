package com.demo.thread.udemy.tutorial.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductOption {
    private int productOptionId;
    private String size;
    private String color;
    private double price;
}
