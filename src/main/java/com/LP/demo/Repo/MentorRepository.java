package com.LP.demo.Repo;


	

	import org.springframework.data.jpa.repository.JpaRepository;
	import com.LP.demo.Entity.Mentor;

	public interface MentorRepository extends JpaRepository<Mentor, Long> {
	    // You can add custom queries or methods if needed
	}



