package onlineUpoznavanje.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SystemMessage {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String message;
	
	private String idOfInviter;
	
	private String idOfInvitee;
	
	private String usernameOfInviter;
	
	private String usernameOfInvitee;
	
	private String date;
	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getIdOfInviter() {
		return idOfInviter;
	}

	public void setIdOfInviter(String idOfInviter) {
		this.idOfInviter = idOfInviter;
	}

	public String getIdOfInvitee() {
		return idOfInvitee;
	}

	public void setIdOfInvitee(String idOfInvitee) {
		this.idOfInvitee = idOfInvitee;
	}

	public String  getUsernameOfInviter() {
		return usernameOfInviter;
	}

	public void setUsernameOfInviter(String usernameOfInviter) {
		this.usernameOfInviter = usernameOfInviter;
	}

	public String getUsernameOfInvitee() {
		return usernameOfInvitee;
	}

	public void setUsernameOfInvitee(String usernameOfInvitee) {
		this.usernameOfInvitee = usernameOfInvitee;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
	
	
}
