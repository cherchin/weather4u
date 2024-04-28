package com.weather4u.controller;

import java.time.LocalDate;
import java.util.List;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weather4u.model.User;
// import com.weather4u.model.Location;
import com.weather4u.model.WeatherData;
import com.weather4u.model.Feedback;

import com.weather4u.repository.UserRepository;
// import com.weather4u.repository.LocationRepository;
// import com.weather4u.repository.WeatherDataRepository;
import com.weather4u.repository.FeedbackRepository;

import com.weather4u.service.WeatherDataService;

@RestController
@RequestMapping("/weather4u")
public class Weather4uController {
	@Autowired private UserRepository userRepository;
	// @Autowired private LocationRepository locationRepository;
	// @Autowired private WeatherDataRepository weatherDataRepository;
	@Autowired private FeedbackRepository feedbackRepository;
	@Autowired private WeatherDataService weatherDataService;
	
	private static final Logger logger = LoggerFactory.getLogger(Weather4uController.class);
	
	@PostConstruct
	public void init() {
		
		if(userRepository.count()==0) {
			logger.info("User database is empty, initializing..");
			User user1 = new User("1@gmail.com", "1pw", 1.00, 1.00);
			User user2 = new User("2@gmail.com", "2pw", 2.00, 2.00);
			User user3 = new User("3@gmail.com", "3pw", 3.00, 3.00);
			
			userRepository.save(user1);
			userRepository.save(user2);
			userRepository.save(user3);
			
			logger.info("user sample data saved!");	
		// }
		
		// if(locationRepository.count()==0) {
		
			/* 
			logger.info("Location database is empty, initializing..");
			Location location1 = new Location("city1", "country1", 1.00, 1.00);
			Location location2 = new Location("city2", "country2", 2.00, 2.00);
			Location location3 = new Location("city3", "country3", 3.00, 3.00);
			
			locationRepository.save(location1);
			locationRepository.save(location2);
			locationRepository.save(location3);
			
			logger.info("location sample data saved!");	
			*/
		
		// if(weatherDataRepository.count()==0) {
		
			/* logger.info("Weather database is empty, initializing..");
			LocalDate currentDate = LocalDate.now();

	        WeatherData weatherData1 = new WeatherData(currentDate, 25.5, 70.0, 12.3, "NE", "Sunny");
	        WeatherData weatherData2 = new WeatherData(currentDate, 22.0, 65.5, 10.0, "NW", "Cloudy");
	        WeatherData weatherData3 = new WeatherData(currentDate, 28.0, 80.0, 15.5, "S", "Partly cloudy");
			*/
			
			// weatherDataRepository.save(weatherData1);
			// weatherDataRepository.save(weatherData2);
			// weatherDataRepository.save(weatherData3);
			
			logger.info("weather data sample data saved!");	
		// }
		
		if(feedbackRepository.count()==0) {

			logger.info("feedback database is empty, initializing..");
			LocalDate currentDate = LocalDate.now();
	        Feedback feedback1 = new Feedback(user1.getId(), currentDate, "This is the first feedback.");
	        Feedback feedback2 = new Feedback(user2.getId(), currentDate, "This is the second feedback.");
	        Feedback feedback3 = new Feedback(user3.getId(), currentDate, "This is the third feedback.");
	        Feedback feedback4 = new Feedback(user1.getId(), currentDate, "This is the fourth feedback.");
			
			feedbackRepository.save(feedback1);
			feedbackRepository.save(feedback2);
			feedbackRepository.save(feedback3);
			feedbackRepository.save(feedback4);
			
			logger.info("feedback sample data saved!");		
		}
		
			logger.info("all sample data saved!");
		}
	}
	
	@GetMapping("/user")
	public List<User> user(){
		
		return userRepository.findAll();
	
	}
	
	@PostMapping("/user/save")
	public User saveUser(@RequestBody User user) {
		
		User userSaved = userRepository.save(user);
		return userSaved;
	}
	
	@GetMapping("/feedback")
	public List<Feedback> feedback(){
		
		return feedbackRepository.findAll();
	
	}
	
	/* how to make this return List<Feedback> instead */
	
	@GetMapping("/feedback/{userId}")
	public List<Feedback> retrieveFeedbackByUser(@PathVariable String userId){
		
		return feedbackRepository.findByUserId(userId);
	
	}
	
	@PostMapping("/feedback/save")
	public Feedback submitFeedback(@RequestBody Feedback feedback) {
		
		Feedback feedbackSaved = feedbackRepository.save(feedback);
		return feedbackSaved;
	}
	
	/* 
	@GetMapping("/location")
	public List<Location> location(){
		
		return locationRepository.findAll();
	
	}
	
	@GetMapping("/weatherData")
	public List<WeatherData> weatherData(){
		
		return weatherDataRepository.findAll();
	
	}
	*/
	
	/* 
	@GetMapping("/weatherData/{Location}")
	// problem is location is not an attribute but a whole class
	public WeatherData getWeatherByCountryCity(@RequestParam Location location, @RequestParam LocalDate date){
		
		WeatherData weather = weatherDataRepository.findByLocationAndDate(location, date);
	    return weather;
	} */
	
	/*
	@GetMapping("/weatherData/country/{country}/city/{city}")
	public WeatherData getWeatherByCityAndCountry(@PathVariable String country, @PathVariable String city, @RequestParam LocalDate date) {
	    Location location = locationRepository.findByCountryAndCity(country, city);
	    if(location != null) {
	        WeatherData weather = weatherDataRepository.findByLocationAndDate(location, date);
	        return weather;
	    } else {
	        logger.info("Location is not valid");
	        return null;
	    }
	} */

	/* 
	@GetMapping("/weatherData/lat/{latitude}/lon/{longitude}")
	public WeatherData getWeatherByLatAndLon(@PathVariable Double latitude, @PathVariable Double longitude, @RequestParam LocalDate date) {
	    Location location = locationRepository.findByLatitudeAndLongitude(latitude, longitude);
	    if(location != null) {
	        WeatherData weather = weatherDataRepository.findByLocationAndDate(location, date);
	        return weather;
	    } else {
	        logger.info("Location is not valid");
	        return null;
	    }
	} */
	
	/* should edit this such that it is forecast instead */
	@GetMapping("/weatherData/country/{country}/city/{city}")
	public WeatherData getWeatherByCityAndCountry(@PathVariable String country, @PathVariable String city, @RequestParam LocalDate date) {
		return weatherDataService.getWeatherByCityAndCountry(country, city, date);
	}
	
	@GetMapping("/weatherData/lat/{latitude}/lon/{longitude}")
	public WeatherData getWeatherByLatAndLon(@PathVariable Double latitude, @PathVariable Double longitude, @RequestParam LocalDate date) {
	    return weatherDataService.getWeatherByLatAndLonAndDate(latitude, longitude, date);
	}
	
	/*
	@GetMapping("/weatherData/forecast/country/{country}/city/{city}")
	public List<WeatherData> getForecastByCityAndCountry(@PathVariable String country, @PathVariable String city) {
		return weatherDataService.getForecastByCityAndCountry(country, city);
	} */
	
	
	/*
	@GetMapping("/weatherData/LocationId")
	public WeatherData getWeatherByLatLon(@RequestParam Location location, @RequestParam LocalDate date){
		
		WeatherData weather = weatherDataRepository.findByLocationAndDate(location, date);
	    return weather;
	} */
	
	/*
	@GetMapping("/feedback/{userId}")
	public Feedback retrieveFeedbackByUser(@PathVariable String userId){
		
		return feedbackRepository.findByUserId(userId);
	
	} */
	
	/*
	@PostMapping("/weatherData/save")
	public WeatherData saveWeatherData(@RequestBody WeatherData weatherData) {
		
		WeatherData weatherDataSaved = weatherDataRepository.save(weatherData);
		return weatherDataSaved;
	} */
}
