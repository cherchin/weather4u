/* package com.weather4u.service;

import com.weather4u.model.User;
import com.weather4u.model.Location;
import com.weather4u.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
    	// Check if user with the provided email already exists
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new RuntimeException("User with this email already exists");
        }

        // Save the user
        return userRepository.save(user);
    }


    public User loginUser(String email, String password) {
    	
    	// Find user by email
        User user = userRepository.findByEmail(email);
        
        // Check if user exists
        if (user == null) {
            throw new RuntimeException("User does not exist");
        }

        // Check if password matches
        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Incorrect password");
        }

        // If user exists and password matches, return user
        return user;
    }
    
    public User updateUserLocation(String userId, Location newLocation) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            user.setLocation(newLocation);
            userRepository.save(user);
        }
        return user;
    }
} */