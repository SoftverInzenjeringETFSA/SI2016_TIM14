package models.dto;

public class LoginResponse {
	private Integer id;

	private Boolean isAdmin;
	
	private String token;
	
	public LoginResponse() {
		
	}
	
	public LoginResponse(Integer id, Boolean isAdmin, String token) {
		this.id = id;
		this.isAdmin = isAdmin;
		this.token = token;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
}
