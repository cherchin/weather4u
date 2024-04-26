/* package com.weather4u.controller;

import java.util.List;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weather4u.model.Location;
import com.weather4u.repository.LocationRepository;
// import com.weather4u.service.LocationService;


@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private LocationRepository locationRepository;
    
	private static final Logger logger = 
			LoggerFactory.getLogger(LocationController.class);
	
	@PostConstruct
	public void init() {
		if(locationRepository.count()==0) {
			logger.info("Location database is empty, initializing..");
			Location location1 = new Location(1.00, 1.00);
			Location location2 = new Location(2.00, 2.00);
			Location location3 = new Location(3.00, 3.00);
			
			locationRepository.save(location1);
			locationRepository.save(location2);
			locationRepository.save(location3);
			
			logger.info("location sample data saved!");		
		}
	}
	
	@GetMapping
	public ResponseEntity<List<Location>> locations() {
		return ResponseEntity.ok(locationRepository.findAll());
	}
} */