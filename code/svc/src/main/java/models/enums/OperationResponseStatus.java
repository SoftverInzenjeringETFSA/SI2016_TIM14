package models.enums;

public enum OperationResponseStatus {
	SUCCESS(0),
	FAILURE(1),
	UNAUTHORIZED(2),
	TOKEN_EXPIRED(3);
	
	private final int status;
	
	OperationResponseStatus(int statusInt) {
		this.status = statusInt;
	}
	
	public int status() { return this.status; }
}
