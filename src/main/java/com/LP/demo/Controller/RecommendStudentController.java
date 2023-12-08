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

import com.LP.demo.Entity.RecommendStudent;
import com.LP.demo.Services.RecommendStudentService;

@RestController
@RequestMapping("/recommendations")
public class RecommendStudentController {

    @Autowired
    private RecommendStudentService recommendStudentService;

    @PostMapping("/recommend")
    public ResponseEntity<RecommendStudent> recommendStudent(@RequestBody RecommendStudent recommendStudent) {
        RecommendStudent savedRecommendation = recommendStudentService.saveRecommendation(recommendStudent);
        return ResponseEntity.ok(savedRecommendation);
    }

    @GetMapping("/{recommendationId}")
    public ResponseEntity<RecommendStudent> getRecommendation(@PathVariable Long recommendationId) {
        RecommendStudent recommendation = recommendStudentService.getRecommendationById(recommendationId);
        return ResponseEntity.ok(recommendation);
    }

    @PutMapping("/update/{recommendationId}")
    public ResponseEntity<RecommendStudent> updateRecommendation(
            @PathVariable Long recommendationId, @RequestBody RecommendStudent updatedRecommendation) {
        RecommendStudent recommendation = recommendStudentService.updateRecommendation(recommendationId, updatedRecommendation);
        return ResponseEntity.ok(recommendation);
    }

    @DeleteMapping("/delete/{recommendationId}")
    public ResponseEntity<String> deleteRecommendation(@PathVariable Long recommendationId) {
        recommendStudentService.deleteRecommendation(recommendationId);
        return ResponseEntity.ok("Recommendation deleted successfully");
    }
}

