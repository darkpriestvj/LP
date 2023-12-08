package com.LP.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LP.demo.Entity.Review;
import com.LP.demo.Services.ReviewService;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/rate")
    public ResponseEntity<Review> rateMentor(@RequestBody Review review) {
        Review savedReview = reviewService.saveReview(review);
        return ResponseEntity.ok(savedReview);
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long reviewId) {
        Review review = reviewService.getReviewById(reviewId);
        return ResponseEntity.ok(review);
    }

    @PutMapping("/update/{reviewId}")
    public ResponseEntity<Review> updateReview(@PathVariable Long reviewId, @RequestBody Review updatedReview) {
        Review review = reviewService.updateReview(reviewId, updatedReview);
        return ResponseEntity.ok(review);
    }

    @DeleteMapping("/delete/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long reviewId) {
        reviewService.deleteReview(reviewId);
        return ResponseEntity.ok("Review deleted successfully");
    }
}


