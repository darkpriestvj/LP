package com.LP.demo.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LP.demo.Entity.User;

public interface StudentRepo extends JpaRepository<User, Long>{
	
	User findByEmail(String email);
	Optional<User> findById(Long userId);

}
