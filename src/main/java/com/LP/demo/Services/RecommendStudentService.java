package com.LP.demo.Services;



	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	import com.LP.demo.Entity.RecommendStudent;
import com.LP.demo.Exception.RecordNotFoundException;
import com.LP.demo.Repo.RecommendStudentRepository;

	@Service
	public class RecommendStudentService {

	    @Autowired
	    private RecommendStudentRepository recommendStudentRepository;

	    public RecommendStudent saveRecommendation(RecommendStudent recommendStudent) {
	        // You can add additional logic/validation if needed before saving
	        return recommendStudentRepository.save(recommendStudent);
	    }

	    public RecommendStudent getRecommendationById(Long recommendationId) {
	        return recommendStudentRepository.findById(recommendationId)
	                .orElseThrow(() -> new RecordNotFoundException("Recommendation not found with id: " + recommendationId));
	    }

	    public RecommendStudent updateRecommendation(Long recommendationId, RecommendStudent updatedRecommendation) {
	        RecommendStudent existingRecommendation = getRecommendationById(recommendationId);
	        existingRecommendation.setStudentName(updatedRecommendation.getStudentName());
	        existingRecommendation.setRecommendation(updatedRecommendation.getRecommendation());
	        // Add any other fields you want to update

	        return recommendStudentRepository.save(existingRecommendation);
	    }

	    public void deleteRecommendation(Long recommendationId) {
	        RecommendStudent existingRecommendation = getRecommendationById(recommendationId);
	        recommendStudentRepository.delete(existingRecommendation);
	    }
	}
