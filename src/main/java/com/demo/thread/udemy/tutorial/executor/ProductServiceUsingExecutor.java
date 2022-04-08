package com.demo.thread.udemy.tutorial.executor;

import com.demo.thread.udemy.tutorial.model.Product;
import com.demo.thread.udemy.tutorial.model.ProductInfo;
import com.demo.thread.udemy.tutorial.model.Review;
import com.demo.thread.udemy.tutorial.service.ProductInfoService;
import com.demo.thread.udemy.tutorial.service.ReviewService;
import lombok.AllArgsConstructor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static com.demo.thread.udemy.tutorial.util.CommonUtil.noOfCore;
import static com.demo.thread.udemy.tutorial.util.CommonUtil.stopWatch;
import static com.demo.thread.udemy.tutorial.util.LoggerUtil.log;

@AllArgsConstructor
public class ProductServiceUsingExecutor {
    static ExecutorService executorService = Executors.newFixedThreadPool(noOfCore());
    private final ProductInfoService productInfoService;
    private final ReviewService reviewService;

    public Product retrieveProductDetails(String productId) throws InterruptedException, ExecutionException {
        stopWatch.start();
        Future<ProductInfo> productInfoFuture = executorService.submit(() -> productInfoService.retrieveProductInfo(productId));
        Future<Review> reviewFuture = executorService.submit(() -> reviewService.retrieveReview(productId));
        ProductInfo productInfo = productInfoFuture.get();
        Review review = reviewFuture.get();
        stopWatch.stop();
        log("Total time taken : " + stopWatch.getTime());
        return new Product(productId, productInfo, review);
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ProductInfoService productInfoService = new ProductInfoService();
        ReviewService reviewService = new ReviewService();
        ProductServiceUsingExecutor productService = new ProductServiceUsingExecutor(productInfoService, reviewService);
        String productId = "ABCD1245";
        Product product = productService.retrieveProductDetails(productId);
        log("Product is : " + product);
        executorService.shutdown();
    }

//    private class ProductInfoRunnable implements Runnable{
//        private final String productId;
//        private ProductInfo productInfo;
//        public ProductInfoRunnable(String productId) {
//            this.productId = productId;
//        }
//
//        public ProductInfo getProductInfo() {
//            return productInfo;
//        }
//
//        @Override
//        public void run() {
//        productInfo = productInfoService.retrieveProductInfo(prfoductId);
//        }
//    }
//
//    private class ReviewRunable implements Runnable{
//        private final String productId;
//        private Review review;
//
//        public ReviewRunable(String productId) {
//            this.productId = productId;
//        }
//
//        public Review getReview() {
//            return review;
//        }
//
//        @Override
//        public void run() {
//            review = reviewService.retrieveReview(productId);
//        }
//    }
}
