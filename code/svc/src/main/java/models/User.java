package models;

public class User {
	// Private fields
	private Integer Id;
	
	private String FirstName;
	
	private String LastName;
	
	// Constructors
	public User() {
		
	}
	
	public User(Integer id, String firstName, String lastName) {
		Id = id;
		FirstName = firstName;
		LastName = lastName;
	}
	
	// Public getters and setters
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		this.Id = id;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}
	
	// Public helper members
	public String getFullName() {
		return String.join(" ", FirstName, LastName);
	}
}
