package onlineUpoznavanje.dto;

import onlineUpoznavanje.models.User;

public class LoginDataResponse {
 
    private User korisnik;
	
	private String errorMessage;

	private String token;
	
	public LoginDataResponse() {
		
	}
	
	public LoginDataResponse(String errorMessage) {
		this.setErrorMessage(errorMessage);
	}
	
	public LoginDataResponse(User korisnik, String token) {
		this.setKorisnik(korisnik);
		this.setToken(token);
	}

	public User getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(User korisnik) {
		this.korisnik = korisnik;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
