package com.nitish.users.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "users")
public class User {
	
//	variables
	@Id
	@GeneratedValue
	@NotNull(message = "User Id can not be Null")
	private int userid;
	@NotEmpty(message = "First Name can not be null")
	private String userFirstName;
	@NotEmpty(message = "Last Name can not be null")
	private String userLastName;
	@NotEmpty(message = "Email can not be null")
	private String userEmail;
	@Size(min = 1,max=7,message = "Password cannot be null")
	private String userPassword;
	@NotNull(message="Rating can not be null")
	private double userRating;

//	getters and setters
	public int getId() {
		return userid;
	}

	public void setId(int userid) {
		this.userid = userid;
	}

	public String getFirstName() {
		return userFirstName;
	}

	public void setFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getLastName() {
		return userLastName;
	}

	public void setLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getEmail() {
		return userEmail;
	}

	public void setEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getPassword() {
		return userPassword;
	}

	public void setPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public double getRating() {
		return userRating;
	}

	public void setRating(double userRating) {
		this.userRating = userRating;
	}

//	Field Constructor
	public User(@NotNull(message = "User Id can not be Null")int userid,
			@NotEmpty(message = "First Name can not be null") String userFirstName, 
			@NotEmpty(message = "Last Name can not be null")String userLastName,
			@NotEmpty(message = "Email can not be null")String userEmail, 
			@Size(min = 1,max=7,message = "Password cannot be null")String userPassword, 
			@NotNull(message="Rating can not be null") double userRating) {
		super();
		this.userid = userid;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userRating = userRating;
	}

//	Default Constructor
	public User() {
		super();
	}

	// Overriding toString method
	@Override
	public String toString() {
		return "User [userid=" + userid + ", userFirstName=" + userFirstName + ", userLastName=" + userLastName
				+ ", userEmail=" + userEmail + ", userPassword=" + userPassword + ", userRating=" + userRating + "]";
	}

	
}
