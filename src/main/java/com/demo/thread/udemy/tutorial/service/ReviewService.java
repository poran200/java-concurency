package com.demo.thread.udemy.tutorial.service;

import com.demo.thread.udemy.tutorial.model.Review;

import static com.demo.thread.udemy.tutorial.util.CommonUtil.delay;

/**
 *
 */
public class ReviewService {
    /**
     * @param productId for based on product
     * @return review of a product
     */
    public Review retrieveReview(String productId) {
        delay(1000);
        return new Review(200, 4.5);
    }
}
