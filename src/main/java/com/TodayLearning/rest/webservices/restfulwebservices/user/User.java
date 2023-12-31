package com.TodayLearning.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class User 
{
       private int id;
       @Size(min=2,message = "Name should have atleast 2 characters")
       @JsonProperty("user_name")   // this is basically used to customize the rest api response we get in json format 
       private String name;
       
       @Past(message = "Birthdate should be in past")
       @JsonProperty("birth_date")
       private LocalDate birthDate;
       
	public User(int id, String name, LocalDate birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
       
       
       
}
