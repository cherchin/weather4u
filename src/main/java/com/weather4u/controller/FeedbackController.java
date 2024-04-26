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

import com.weather4u.model.Feedback;
// import com.weather4u.model.User;
import com.weather4u.repository.FeedbackRepository;
// import com.weather4u.repository.UserRepository;
import com.weather4u.service.FeedbackService;
import java.time.LocalDate;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;
    @Autowired
    private FeedbackRepository feedbackRepository;
    
	private static final Logger logger = 
			LoggerFactory.getLogger(FeedbackController.class);
	
	@PostConstruct
	public void init() {
		if(feedbackRepository.count()==0) {
			logger.info("feedback database is empty, initializing..");
	        Feedback feedback1 = new Feedback("user1", LocalDate.now(), "This is the first feedback.");
	        Feedback feedback2 = new Feedback("user2", LocalDate.now(), "This is the second feedback.");
	        Feedback feedback3 = new Feedback("user3", LocalDate.now(), "This is the third feedback.");
			
			feedbackRepository.save(feedback1);
			feedbackRepository.save(feedback2);
			feedbackRepository.save(feedback3);
			
			logger.info("feedback sample data saved!");		
		}
	}
	
	@GetMapping
	public ResponseEntity<List<Feedback>> allFeedback() {
		return ResponseEntity.ok(feedbackRepository.findAll());
	}
	
    @GetMapping("/{userId}")
    public ResponseEntity<List<Feedback>> retrieveFeedbackByUser(@PathVariable String userId) {
        return ResponseEntity.ok(feedbackService.retrieveFeedbackByUser(userId));
    }

    @PostMapping("/submit")
    public ResponseEntity<Feedback> submitFeedback(@RequestBody Feedback feedback) {
        return ResponseEntity.ok(feedbackService.submitFeedback(feedback));
    }
} */