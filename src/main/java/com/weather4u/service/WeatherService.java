/* package com.weather4u.service;

import com.weather4u.model.Location;
import com.weather4u.model.WeatherData;
import com.weather4u.repository.WeatherDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Service
public class WeatherService {
    @Autowired
    private WeatherDataRepository weatherDataRepository;

    private final String OPENWEATHERMAP_API_KEY = "your_api_key";
    private final String OPENWEATHERMAP_API_URL = "http://api.openweathermap.org/data/2.5/weather";

    public WeatherData getWeather(Location location, LocalDate date) {
        WeatherData weatherData = weatherDataRepository.findByLocationAndDate(location, date);
        if (weatherData == null) {
            // Fetch data from OpenWeatherMap API
            RestTemplate restTemplate = new RestTemplate();
            String url = String.format("%s?q=%s&appid=%s", OPENWEATHERMAP_API_URL, location.getCity(), OPENWEATHERMAP_API_KEY);
            WeatherData apiWeatherData = restTemplate.getForObject(url, WeatherData.class);
            if (apiWeatherData != null) {
                // Save API data to database
                weatherDataRepository.save(apiWeatherData);
                return apiWeatherData;
            } else {
                return null;
            }
        }
        return weatherData;
    }
    
    public WeatherData saveWeatherData(WeatherData weatherData) {
    	
        // Check if weather data already exists in the database
        WeatherData existingWeatherData = weatherDataRepository.findByLocationAndDate(weatherData.getLocation(), weatherData.getDate());
        
        if (existingWeatherData != null) {
            // Weather data already exists, return error or handle appropriately
            throw new IllegalArgumentException("Weather data for the specified date and location already exists.");
        } else {
            // Weather data does not exist, save it to the database
            return weatherDataRepository.save(weatherData);
        }
    }
} */