package com.LP.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LP.demo.Entity.RecommendStudent;

public interface RecommendStudentRepository extends JpaRepository<RecommendStudent, Long> {
    // You can add custom queries or methods if needed
}