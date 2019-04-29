package edu.zut.cs.software.star.admin.service.entity;

import java.util.Date;

public class User {
	
	Long Id;
	String name;
	String password;
	boolean gender;
	Date birthday;
	
	
	public Date getBirthday() {
		return birthday;
	}
	public Long getId() {
		return Id;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public boolean isGender() {
		return gender;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public void setId(Long id) {
		Id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
