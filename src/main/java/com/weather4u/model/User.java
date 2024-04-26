package com.weather4u.model;

import lombok.Data;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Data
@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String email;
    private String password;
    
    @DBRef
    private Location location;
    
    public User() {
        // Default constructor
    }
    
	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	} 
    
	public User(String email, String password, Location location) {
		super();
		this.email = email;
		this.password = password;
		this.location = location;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, location, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(location, other.location) && Objects.equals(password, other.password);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", location=" + location + "]";
	}  
	
	
	
}