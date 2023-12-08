package com.LP.demo.Services;


import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	import com.LP.demo.Entity.Review;
	import com.LP.demo.Exception.RecordNotFoundException;
import com.LP.demo.Repo.ReviewRepository;


@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public Review saveReview(Review review) {
        // You can add additional logic/validation if needed before saving
        return reviewRepository.save(review);
    }

    public Review getReviewById(Long reviewId) {
        return reviewRepository.findById(reviewId)
                .orElseThrow(() -> new RecordNotFoundException("Review not found with id: " + reviewId));
    }

    public Review updateReview(Long reviewId, Review updatedReview) {
        Review existingReview = getReviewById(reviewId);
        existingReview.setComment(updatedReview.getComment());
        existingReview.setRating(updatedReview.getRating());
        // Add any other fields you want to update

        return reviewRepository.save(existingReview);
    }

    public void deleteReview(Long reviewId) {
        Review existingReview = getReviewById(reviewId);
        reviewRepository.delete(existingReview);
    }
}
