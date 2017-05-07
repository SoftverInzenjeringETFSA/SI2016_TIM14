package common.exception;

public class EntityNotFoundException extends RuntimeException {
	// Default serial version UID - irrelevant in this context
	private static final long serialVersionUID = 1L;

	public EntityNotFoundException(String message) {
		super(message);
	}
}
