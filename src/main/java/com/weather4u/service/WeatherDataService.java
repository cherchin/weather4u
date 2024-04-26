package com.weather4u.service;

import com.weather4u.controller.Weather4uController;
import com.weather4u.model.WeatherData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;

@Service
public class WeatherDataService {
	
	private static final Logger logger = LoggerFactory.getLogger(Weather4uController.class);

	// @Value("${openweathermap.apiKey}")
    private String apiKey="724d34e6b4a219810195947366971379";

    public WeatherData getWeatherByLatAndLonAndDate(Double latitude, Double longitude, LocalDate date) { //throws JsonMappingException, JsonProcessingException {
        String apiUrl = "https://api.openweathermap.org/data/2.5/weather?lat=" + latitude + "&lon=" + longitude 
        		+ "&appid=" + apiKey;
        
        RestTemplate restTemplate = new RestTemplate();
        String jsonResponse = restTemplate.getForObject(apiUrl, String.class);

        // OpenWeatherMapResponse response = restTemplate.getForObject(apiUrl, OpenWeatherMapResponse.class);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode responseNode = null;
		try {
			responseNode = objectMapper.readTree(jsonResponse);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        if (responseNode != null) {
            WeatherData weatherData = new WeatherData();
        	weatherData.setDate(date);
            weatherData.setTemperature(responseNode.get("main").get("temp").asDouble());
            weatherData.setHumidity(responseNode.get("main").get("humidity").asDouble());
            weatherData.setWindSpeed(responseNode.get("wind").get("speed").asDouble());
            weatherData.setWindDirection(responseNode.get("wind").get("deg").asDouble());
            weatherData.setDescription(responseNode.get("weather").get(0).get("description").asText());
            return weatherData;
        } else {
        	logger.error("Failed to retrieve weather data from the API for latitude: {} and longitude: {}", latitude, longitude);
            return null;
        }
    }
    
    public WeatherData getWeatherByCityAndCountry(@PathVariable String country, @PathVariable String city, @RequestParam LocalDate date) {
		
    	String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "," + country
        		+ "&appid=" + apiKey;
    	
    	// https://api.openweathermap.org/data/2.5/weather?q=taipei,%20taiwan&APPID=724d34e6b4a219810195947366971379
    	RestTemplate restTemplate = new RestTemplate();
    	String jsonResponse = restTemplate.getForObject(apiUrl, String.class);

	    // OpenWeatherMapResponse response = restTemplate.getForObject(apiUrl, OpenWeatherMapResponse.class);
	    ObjectMapper objectMapper = new ObjectMapper();
	    JsonNode responseNode = null;
		try {
			responseNode = objectMapper.readTree(jsonResponse);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	    if (responseNode != null) {
	        WeatherData weatherData = new WeatherData();
	    	weatherData.setDate(date);
	        weatherData.setTemperature(responseNode.get("main").get("temp").asDouble());
	        weatherData.setHumidity(responseNode.get("main").get("humidity").asDouble());
	        weatherData.setWindSpeed(responseNode.get("wind").get("speed").asDouble());
	        weatherData.setWindDirection(responseNode.get("wind").get("deg").asDouble());
	        weatherData.setDescription(responseNode.get("weather").get(0).get("description").asText());
	        return weatherData;
	    } else {
	    	logger.error("Failed to retrieve weather data from the API for country: {} and city: {}", country, city);
	        return null;
	    }
    }
    
    /* 
	public List<WeatherData> getForecastByCityAndCountry(@PathVariable String country, @PathVariable String city) {
			
	    String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "," + country
	        	+ "&appid=" + apiKey;
	} */
}
