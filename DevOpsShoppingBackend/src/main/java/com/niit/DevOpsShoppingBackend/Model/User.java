package com.niit.DevOpsShoppingBackend.Model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class User implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Id
	private String userId;
	private String name;
	private String email;
	private String password;
	private String phone;
	private String address;
	private String country;
	
//	public User(String name, String email, String password, String phone, String address, String country)
//	{
//		this.name=name;
//		this.email=email;
//		this.password=password;
//		this.phone=phone;
//		this.address=address;
//		this.country=country;
//		
//	}
	
	
	public User() 
	{
		this.userId="USER"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
}
