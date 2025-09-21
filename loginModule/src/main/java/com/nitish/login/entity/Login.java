package com.nitish.login.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="loginTable")
public class Login {
	@Id
	@NotEmpty
	@Size(min=2,message="Username should have atleast 2 characters")
	private String username;
	@NotEmpty
	@Size(min=8,message="Password should have atleast 8 characters")
	private String password;
	private String role="Role_User";
	private boolean active=false;
	public Login() {
		super();
	}
	public Login(@NotEmpty @Size (min=2,message="Username should have atleast 2 characters")String  username,@NotEmpty @Size(min=8,message="Password should have atleast 8 characters")String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public Login(@NotEmpty @Size(min = 2, message = "Username should have atleast 2 characters") String username,
			@NotEmpty @Size(min = 8, message = "Password should have atleast 8 characters") String password,
			String role, boolean active) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
		this.active = active;
	}
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
	@Override
	public String toString() {
		return "Users [username=" + username + ", password=" + password + ", role=" + role + ", active=" + active + "]";
	}
	
}
