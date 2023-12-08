package com.LP.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.LP.demo.Entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    // You can add custom queries or methods if needed
}