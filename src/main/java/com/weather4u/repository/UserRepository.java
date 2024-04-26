package com.weather4u.repository;

import java.util.List;

import com.weather4u.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
	List<User> findAll();
	User findByEmail(String email);
}