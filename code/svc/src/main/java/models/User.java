package models;

import java.sql.ResultSet;
import java.util.Date;

import models.enums.Gender;

public class User {
	// Private fields
	private String firstName;
	
	private Integer id;
	
	private String lastName;
	
	private String username;
	
	private String password;
	
	private String email;
	
	private Gender gender;
	
	private Date dateOfBirth;
	
	private String location;
	
	private String about;
	
	private Boolean isAdmin;
	
	// Constructors
	public User() {
		
	}
	
	public User(Integer id, String username, String password, String firstName, String lastName, String email,
			Gender gender, Date dateOfBirth, String location, String about, Boolean isAdmin) {
		this.id = id;
		this.setUsername(username);
		this.setPassword(password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.setEmail(email);
		this.setGender(gender);
		this.setDateOfBirth(dateOfBirth);
		this.setLocation(location);
		this.setAbout(about);
		this.setIsAdmin(isAdmin);
	}
	
	public User(ResultSet rs) {
		try {
			this.id = rs.getInt("Id");
			this.username = rs.getString("Username");
			this.firstName = rs.getString("FirstName");
			this.lastName = rs.getString("LastName");
			this.email = rs.getString("Email");
			this.gender = Gender.fromInt(rs.getInt("Gender"));
			this.dateOfBirth = rs.getDate("DateOfBirth");
			this.location = rs.getString("Location");
			this.about = rs.getString("About");
			this.isAdmin = rs.getInt("IsAdmin") == 1;	
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Public getters and setters
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	// Public helper members
	public String getFullName() {
		return String.join(" ", firstName, lastName);
	}
}
