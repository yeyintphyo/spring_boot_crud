package com.example.employee.dto;

import java.io.Serializable;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class UserDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
    @NotEmpty
    @Size(min=5, max=30)	
	private String username;
    @NotEmpty
    @Size(min=7, max=30)    
	private String password;
    @NotEmpty
    @Size(min=7, max=30)    
	private String passwordCheck;
    
	private String role;
	
	public UserDto() {
	}
	
	public UserDto(String username, String password, String role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getPasswordCheck() {
		return passwordCheck;
	}
	public void setPasswordCheck(String passwordCheck) {
		this.passwordCheck = passwordCheck;
	}
}
