/* package com.weather4u.repository;

import java.util.List;

import com.weather4u.model.Location;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface LocationRepository extends MongoRepository<Location, String> {
	List<Location> findAll();
    Location findByCountryAndCity(String Country, String City);
    Location findByLatitudeAndLongitude(Double Lat, Double Lon);
}
*/