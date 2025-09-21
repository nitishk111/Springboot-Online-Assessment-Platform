package com.nitish.users.dto;

/**
 * 
 * DTO class of Login It keeps details of all user login
 *
 */

public class Login {

//	variables
	private String username;
	private String password;
	private String role;
	private boolean active;

	// Default constructor
	public Login() {
		super();
	}

	// Field constructor
	public Login(String username, String password, String role, boolean active) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
		this.active = active;
	}

	// getters & setters
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	// Overriding toString method
	@Override
	public String toString() {
		return "Users [username=" + username + ", password=" + password + ", role=" + role + ", active=" + active + "]";
	}

}
