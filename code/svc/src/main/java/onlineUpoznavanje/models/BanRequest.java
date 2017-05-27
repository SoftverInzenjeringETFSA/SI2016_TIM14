package onlineUpoznavanje.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BanRequest {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String reason;
	
	private Integer requestedId;
	
	private Integer targetId;
	
	private Integer chatGroupId;
	
	private String sourceusername;
	
	private String targetusername;
	
	private String groupname;

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Integer getRequestedId() {
		return requestedId;
	}

	public void setRequestedId(Integer requestedId) {
		this.requestedId = requestedId;
	}

	public Integer getTargetId() {
		return targetId;
	}

	public void setTargetId(Integer targetId) {
		this.targetId = targetId;
	}

	public Integer getChatGroupId() {
		return chatGroupId;
	}

	public void setChatGroupId(Integer chatGroupId) {
		this.chatGroupId = chatGroupId;
	}

	public String getSourceusername() {
		return sourceusername;
	}

	public void setSourceusername(String sourceusername) {
		this.sourceusername = sourceusername;
	}

	public String getTargetusername() {
		return targetusername;
	}

	public void setTargetusername(String targetusername) {
		this.targetusername = targetusername;
	}

	
	
	
	
}
