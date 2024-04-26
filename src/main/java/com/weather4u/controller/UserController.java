/* package com.weather4u.controller;

import java.util.List;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weather4u.model.User;
import com.weather4u.repository.UserRepository;
import com.weather4u.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    
	private static final Logger logger = 
			LoggerFactory.getLogger(UserController.class);
	
	@PostConstruct
	public void init() {
		if(userRepository.count()==0) {
			logger.info("User database is empty, initializing..");
			User user1 = new User("1@gmail.com", "1pw");
			User user2 = new User("2@gmail.com", "2pw");
			User user3 = new User("3@gmail.com", "3pw");
			
			userRepository.save(user1);
			userRepository.save(user2);
			userRepository.save(user3);
			
			logger.info("user sample data saved!");		
		}
	}
	
	@GetMapping
	public ResponseEntity<List<User>> users() {
		return ResponseEntity.ok(userRepository.findAll());
	}
	
    @PostMapping("/register")    
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        try {
            User registeredUser = userService.registerUser(user);
            return ResponseEntity.ok(registeredUser);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestParam String email, @RequestParam String password) {
        try {
            User user = userService.loginUser(email, password);
            return ResponseEntity.ok(user);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
} */