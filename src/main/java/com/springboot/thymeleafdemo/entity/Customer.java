package com. springboot.thymeleafdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//import com.sun.istack.NotNull;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
///	@NotBlank(massage = "Name is mandatory")
	
//	@NotNull
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name ="last_name")
	private String lastName;
	
	@Column(name = "phone_Number")
	private long phoneNumber;
	
	@Column(name ="email")
	private String email;
	
//	@Column(name="enabled")
//	private boolean enabled;
	
//	@Column(name ="password")
//	private String password;
	
	public Customer() {}

	public Customer(String firstName, String lastName, long phoneNumber, String email) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
//		this.password = password;
	}

//	public Customer(boolean enabled) {
//		super();
////		this.enabled= false;
//	}

	public long getId() {

		return id;
	}

	public void setId(long id) {

		this.id = id;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName()
	{
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

	public  String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

//	public boolean isEnabled() {
//		return enabled;
//	}
//
//	public void setEnabled(boolean enabled) {
//		this.enabled = enabled;
//	}

//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}

	@Override
	public String toString() {
		return "Customer{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", phoneNumber=" + phoneNumber +
				", email='" + email + '\'' +
				'}';
	}


}
