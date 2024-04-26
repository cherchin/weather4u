package com.weather4u.model;

import lombok.Data;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Location {
    @Id
    private String id;
    private String city;
    private String country;
    private Double latitude;
    private Double longitude;
    
    public Location() {
        // Default constructor
    }
    
    public Location(String country, String city) {
    	super();
    	this.country = country;
    	this.city = city;
    }
    
	public Location(Double latitude, Double longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Location(String city, String country, Double latitude, Double longitude) {
		super();
		this.city = city;
		this.country = country;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	@Override
	public int hashCode() {
		return Objects.hash(city, country, id, latitude, longitude);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		return Objects.equals(city, other.city) && Objects.equals(country, other.country)
				&& Objects.equals(id, other.id) && Objects.equals(latitude, other.latitude)
				&& Objects.equals(longitude, other.longitude);
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", city=" + city + ", country=" + country + ", latitude=" + latitude
				+ ", longitude=" + longitude + "]";
	}  
	
	
}