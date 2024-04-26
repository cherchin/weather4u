package com.weather4u.repository;

import java.util.List;

import com.weather4u.model.WeatherData;
import com.weather4u.model.Location;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;

public interface WeatherDataRepository extends MongoRepository<WeatherData, String> {
    List<WeatherData> findAll();
	WeatherData findByLocationAndDate(Location location, LocalDate date);
}