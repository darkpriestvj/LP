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

import com.LP.demo.Entity.Mentor;
import com.LP.demo.Services.MentorService;

@RestController
@RequestMapping("/mentors")
public class MentorController {

    @Autowired
    private MentorService mentorService;

    @GetMapping("/{mentorId}")
    public ResponseEntity<Mentor> getMentor(@PathVariable Long mentorId) {
        Mentor mentor = mentorService.getMentorById(mentorId);
        return ResponseEntity.ok(mentor);
    }

    @PostMapping("/create")
    public ResponseEntity<Mentor> createMentor(@RequestBody Mentor mentor) {
        Mentor createdMentor = mentorService.createMentor(mentor);
        return ResponseEntity.ok(createdMentor);
    }

    @PutMapping("/update/{mentorId}")
    public ResponseEntity<Mentor> updateMentor(@PathVariable Long mentorId, @RequestBody Mentor updatedMentor) {
        Mentor mentor = mentorService.updateMentor(mentorId, updatedMentor);
        return ResponseEntity.ok(mentor);
    }

    @DeleteMapping("/delete/{mentorId}")
    public ResponseEntity<String> deleteMentor(@PathVariable Long mentorId) {
        mentorService.deleteMentor(mentorId);
        return ResponseEntity.ok("Mentor deleted successfully");
    }
}


