package com.weather4u.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.LocalDate;
import java.util.Objects;

@Data
@Document
public class Feedback {
    @Id
    private String id;
    
    private String userId;
    private LocalDate date;
    private String content;
    
    public Feedback() {
        // Default constructor
    }
    
    public Feedback(String content) {
    	super();
    	this.content = content;
    }
    
	public Feedback(String userId, LocalDate date, String content) {
		super();
		this.userId = userId;
		this.date = date;
		this.content = content;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public int hashCode() {
		return Objects.hash(content, date, id, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Feedback other = (Feedback) obj;
		return Objects.equals(content, other.content) && Objects.equals(date, other.date)
				&& Objects.equals(id, other.id) && Objects.equals(userId, other.userId);
	}

	@Override
	public String toString() {
		return "Feedback [id=" + id + ", userId=" + userId + ", date=" + date + ", content=" + content + "]";
	}
	
	
}