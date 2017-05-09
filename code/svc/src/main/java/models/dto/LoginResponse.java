package models.dto;

import models.User;

public class LoginResponse {
	private Integer id;
	
	private Boolean isAdmin;
	
	private String username;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String token;
	
	public LoginResponse() {
		
	}
	
	public LoginResponse(User user, String token) {
		this.id = user.getId();
		this.setIsAdmin(user.getIsAdmin());
		this.setUsername(user.getUsername());
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.email = user.getEmail();
		this.token = token;
	}
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
