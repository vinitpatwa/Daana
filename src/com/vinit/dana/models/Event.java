package com.vinit.dana.models;

import java.util.Date;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;



@Table(name = "Event")
public class Event extends Model {

	@Column(name = "Attendies")
	public String attendies;

	@Column(name = "Location")
	public String location;
		
	@Column(name = "time")
	public String time;

	@Column(name = "date")
	public Date date;

	@Column(name = "title")
	public String title;
	
	@Column(name = "imageurl")
	public String imageurl;
	
	
	@Column(name = "description")
	public String description;
	
	@Column(name = "user")
	public User user;

	public String getAttendies() {
		return attendies;
	}

	public void setAttendies(String attendies) {
		this.attendies = attendies;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImageurl() {
		return imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
		
}
