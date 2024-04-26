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

import com.weather4u.model.WeatherData;
import com.weather4u.model.Feedback;
import com.weather4u.model.Location;
import com.weather4u.model.User;
import com.weather4u.repository.WeatherDataRepository;
import com.weather4u.service.WeatherService;
import java.time.LocalDate;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;
    @Autowired
    private WeatherDataRepository weatherDataRepository;
    
    private static final Logger logger = 
			LoggerFactory.getLogger(WeatherController.class);
	
	@PostConstruct
	public void init() {
		if(weatherDataRepository.count()==0) {
			logger.info("Weather database is empty, initializing..");
			LocalDate currentDate = LocalDate.now();
			Location location1 = new Location(1.00, 1.00);
			Location location2 = new Location(2.00, 2.00);
			Location location3 = new Location(3.00, 3.00);

	        WeatherData weatherData1 = new WeatherData(currentDate, location1, 25.5, 70.0, 12.3, "NE", "Sunny");
	        WeatherData weatherData2 = new WeatherData(currentDate, location2, 22.0, 65.5, 10.0, "W", "Cloudy");
	        WeatherData weatherData3 = new WeatherData(currentDate, location3, 28.0, 80.0, 15.5, "SE", "Partly cloudy");

			weatherDataRepository.save(weatherData1);
			weatherDataRepository.save(weatherData2);
			weatherDataRepository.save(weatherData3);
			
			logger.info("weather data sample data saved!");		
		}
	}
	
    
    @GetMapping
    public ResponseEntity<List<WeatherData>> allWeatherData() {
		return ResponseEntity.ok(weatherDataRepository.findAll());
	}

    @GetMapping("/{location}")
    public ResponseEntity<WeatherData> getWeather(@RequestParam Location location, @RequestParam LocalDate date) {
        // Location location = new Location();
        // location.setCity(city);
        // LocalDate parsedDate = LocalDate.parse(date);
        WeatherData weather = weatherService.getWeather(location, date);
        return ResponseEntity.ok(weather);
    }
    
    @PostMapping("/save")
    public ResponseEntity<?> saveWeatherData(@RequestBody WeatherData weatherData) {
        try {
            WeatherData savedWeatherData = weatherService.saveWeatherData(weatherData);
            return ResponseEntity.ok(savedWeatherData);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
} */