package com.LP.demo.Services;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	import com.LP.demo.Entity.Mentor;
	import com.LP.demo.Exception.RecordNotFoundException;
import com.LP.demo.Repo.MentorRepository;

@Service
public class MentorService {

    @Autowired
    private MentorRepository mentorRepository;

    public Mentor getMentorById(Long mentorId) {
        return mentorRepository.findById(mentorId)
                .orElseThrow(() -> new RecordNotFoundException("Mentor not found with id: " + mentorId));
    }

    public Mentor createMentor(Mentor mentor) {
        // Add any validation or business logic before saving
        return mentorRepository.save(mentor);
    }

    public Mentor updateMentor(Long mentorId, Mentor updatedMentor) {
        Mentor existingMentor = getMentorById(mentorId);
        existingMentor.setName(updatedMentor.getName());
        // Add any other fields you want to update

        return mentorRepository.save(existingMentor);
    }

    public void deleteMentor(Long mentorId) {
        Mentor existingMentor = getMentorById(mentorId);
        mentorRepository.delete(existingMentor);
    }
}
