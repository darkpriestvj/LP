package com.LP.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LP.demo.Entity.User;
import com.LP.demo.Exception.RecordNotFoundException;
import com.LP.demo.Repo.StudentRepo;


@Service
public class UserService {

    @Autowired
    private StudentRepo sr;

    public User Add(User user) {
        User existingUser = sr.findByEmail(user.getEmail());
        if (existingUser != null) {
            throw new RecordNotFoundException("Email is already exists.");
        }
        return sr.save(user);
    }

    public User getUserById(Long userId) {
        Optional<User> user = sr.findById(userId);
        return user.orElseThrow(() -> new RecordNotFoundException("User not found with id: " + userId));
    }

    public List<User> getAllUsers() {
        return sr.findAll();
    }

    public User updateUser(Long userId, User updatedUser) {
        User existingUser = getUserById(userId);
        existingUser.setName(updatedUser.getName());
        existingUser.setEmail(updatedUser.getEmail());
        // Add any other fields you want to update

        return sr.save(existingUser);
    }

    public void deleteUser(Long userId) {
        User existingUser = getUserById(userId);
        sr.delete(existingUser);
    }
}

