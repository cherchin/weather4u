/* package com.weather4u.service;

import com.weather4u.model.Feedback;
import com.weather4u.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {
    @Autowired
    private FeedbackRepository feedbackRepository;
    
    public List<Feedback> retrieveFeedbackByUser(String userId) {
        return feedbackRepository.findAllByUserId(userId);
    }

    public Feedback submitFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }
} */