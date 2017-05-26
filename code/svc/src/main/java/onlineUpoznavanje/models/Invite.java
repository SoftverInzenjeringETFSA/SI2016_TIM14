package onlineUpoznavanje.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Invite {
    
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idOfInvitee;
	
	private String usernameOfInvitee;
	
	private Integer idOfInviter;
	
	private String usernameOfInviter;
	
	public String getUsernameOfInviter() {
		return usernameOfInviter;
	}
	
	public String getUsernameOfInvitee() {
		return usernameOfInvitee;
	}
	//Geteri i seteri

	public Integer getIdOfInvitee() {
		return idOfInvitee;
	}
	
	public Integer getIdOfInviter() {
		return idOfInviter;
	}

	public void setIdOfInviter(Integer id) {
		this.idOfInviter = id;
	}
	
	public void setIdOfInvitee(Integer id) {
		this.idOfInvitee = id;
	}

	public void setUsernameOfInvitee(String username) {
		this.usernameOfInvitee = username;
	}
	
	public void setUsernameOfInviter(String username) {
		this.usernameOfInviter = username;
	}
	
	
}
