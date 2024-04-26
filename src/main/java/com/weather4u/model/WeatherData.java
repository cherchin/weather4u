package com.weather4u.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Objects;

@Data
@Document
public class WeatherData {
    // @Id
    // private String id;
    private LocalDate date;
    private Double temperature;
    private Double humidity;
    private Double windSpeed;
    private Double windDirection;
    private String description;
    
    @DBRef
    public Location location;
    
    private String city;
    private String country;
    private Double latitude;
    private Double longitude;
    
    
    public WeatherData() {
        // Default constructor
    }
    
	public WeatherData(LocalDate date, Double temperature, Double humidity, Double windSpeed, Double windDirection,
			String description) {
		super();
		this.date = date;
		this.temperature = temperature;
		this.humidity = humidity;
		this.windSpeed = windSpeed;
		this.windDirection = windDirection;
		this.description = description;
	}



	public WeatherData(LocalDate date, Location location) {
		super();
		this.date = date;
		this.location = location;
		this.city = location != null ? location.getCity() : ""; 
		this.country = location != null ? location.getCountry() : ""; 
		this.latitude = location != null ? location.getLatitude() : -1.00;
		this.longitude = location != null ? location.getLongitude() : -1.00;
	}

	public WeatherData(LocalDate date, Location location, Double temperature, Double humidity, Double windSpeed,
			Double windDirection, String description) {
		super();
		this.date = date;
		this.location = location;
		this.temperature = temperature;
		this.humidity = humidity;
		this.windSpeed = windSpeed;
		this.windDirection = windDirection;
		this.description = description;
	}

	/*
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	} */

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	public Double getHumidity() {
		return humidity;
	}

	public void setHumidity(Double humidity) {
		this.humidity = humidity;
	}

	public Double getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(Double windSpeed) {
		this.windSpeed = windSpeed;
	}

	public Double getWindDirection() {
		return windDirection;
	}

	public void setWindDirection(Double windDirection) {
		this.windDirection = windDirection;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, description, humidity, location, temperature, windDirection, windSpeed);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WeatherData other = (WeatherData) obj;
		return Objects.equals(date, other.date) && Objects.equals(description, other.description)
				&& Objects.equals(humidity, other.humidity) 
				&& Objects.equals(location, other.location) && Objects.equals(temperature, other.temperature)
				&& Objects.equals(windDirection, other.windDirection) && Objects.equals(windSpeed, other.windSpeed);
	}

	@Override
	public String toString() {
		return "WeatherData [date=" + date + ", location=" + location + "]";
	}
	
}