package com. springboot.thymeleafdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "first_name")
	private String firstName;
	
	@Column(name ="last_name")
	private String lastName;
	
	@Column(name = "phoneNumber")
	private long phoneNumber;
	
	@Column(name ="email")
	private String email;

	@Column(name ="user_name")
	private String user_name;

	@Column(name = "password")
	private String password;

	@Column (name ="salt")
	private String salt;

	public Customer(Integer id, String firstName, String lastName, Long phoneNumber, String email, String user_name, String password, String salt) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.user_name = user_name;
		this.password = password;
		this.salt = salt;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Override
	public String toString() {
		return "Customer{" +
				"id=" + getId() +
				", firstName='" + getFirstName() + '\'' +
				", lastName='" + getLastName() + '\'' +
				", phoneNumber=" + getPhoneNumber() +
				", email='" + getEmail() + '\'' +
				", user_name='" + getUser_name() + '\'' +
				", password='" + getPassword() + '\'' +
				", salt='" + getSalt() + '\'' +
				'}';
	}
}
