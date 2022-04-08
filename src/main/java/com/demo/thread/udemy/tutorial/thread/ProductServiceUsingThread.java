package com.demo.thread.udemy.tutorial.thread;

import com.demo.thread.udemy.tutorial.model.Product;
import com.demo.thread.udemy.tutorial.model.ProductInfo;
import com.demo.thread.udemy.tutorial.model.Review;
import com.demo.thread.udemy.tutorial.service.ProductInfoService;
import com.demo.thread.udemy.tutorial.service.ReviewService;
import lombok.AllArgsConstructor;

import static com.demo.thread.udemy.tutorial.util.CommonUtil.stopWatch;
import static com.demo.thread.udemy.tutorial.util.LoggerUtil.log;

@AllArgsConstructor
public class ProductServiceUsingThread {
    private final ProductInfoService productInfoService;
    private final ReviewService reviewService;

    public Product retrieveProductDetails(String productId) throws InterruptedException {
        stopWatch.start();
        ProductInfoRunnable productInfoRunnable = new ProductInfoRunnable(productId);
        ReviewRunable reviewRunnable = new ReviewRunable(productId);
        Thread productInfoThread = new Thread(productInfoRunnable);
        Thread reviewThread = new Thread(reviewRunnable);

        productInfoThread.start();
        reviewThread.start();

        productInfoThread.join();
        reviewThread.join();

        ProductInfo productInfo = productInfoRunnable.getProductInfo();
        Review review = reviewRunnable.getReview();

        stopWatch.stop();
        log("Total time taken : " + stopWatch.getTime());
        return new Product(productId, productInfo, review);
    }

    public static void main(String[] args) throws InterruptedException {
        ProductInfoService productInfoService = new ProductInfoService();
        ReviewService reviewService = new ReviewService();
        ProductServiceUsingThread productService = new ProductServiceUsingThread(productInfoService, reviewService);
        String productId = "ABCD1245";
        Product product = productService.retrieveProductDetails(productId);
        log("Product is : " + product);
    }

    private class ProductInfoRunnable implements Runnable {
        private final String productId;
        private ProductInfo productInfo;

        public ProductInfoRunnable(String productId) {
            this.productId = productId;
        }

        public ProductInfo getProductInfo() {
            return productInfo;
        }

        @Override
        public void run() {
            productInfo = productInfoService.retrieveProductInfo(productId);
        }
    }

    private class ReviewRunable implements Runnable {
        private final String productId;
        private Review review;

        public ReviewRunable(String productId) {
            this.productId = productId;
        }

        public Review getReview() {
            return review;
        }

        @Override
        public void run() {
            review = reviewService.retrieveReview(productId);
        }
    }
}
