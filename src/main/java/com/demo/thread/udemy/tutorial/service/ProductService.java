package com.demo.thread.udemy.tutorial.service;

import com.demo.thread.udemy.tutorial.model.Product;
import com.demo.thread.udemy.tutorial.model.ProductInfo;
import com.demo.thread.udemy.tutorial.model.Review;
import lombok.AllArgsConstructor;

import static com.demo.thread.udemy.tutorial.util.CommonUtil.stopWatch;
import static com.demo.thread.udemy.tutorial.util.LoggerUtil.log;

@AllArgsConstructor
public class ProductService {
    private final ProductInfoService productInfoService;
    private final ReviewService reviewService;

    public Product retrieveProductDetails(String productId) {
        stopWatch.start();
        ProductInfo productInfo = productInfoService.retrieveProductInfo(productId);
        Review review = reviewService.retrieveReview(productId);
        stopWatch.stop();
        log("Total time taken : " + stopWatch.getTime());
        return new Product(productId, productInfo, review);
    }

    public static void main(String[] args) {
        ProductInfoService productInfoService = new ProductInfoService();
        ReviewService reviewService = new ReviewService();
        ProductService productService = new ProductService(productInfoService, reviewService);
        String productId = "ABCD1245";
        Product product = productService.retrieveProductDetails(productId);
        log("Product is : " + product);

    }
}
