package com.weather4u.repository;

import java.util.List;

import com.weather4u.model.Feedback;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface FeedbackRepository extends MongoRepository<Feedback, String> {
	List<Feedback> findAll();
    List<Feedback> findByUserId(String userId);
    List<Feedback> findAllByUserId(String userId);
}