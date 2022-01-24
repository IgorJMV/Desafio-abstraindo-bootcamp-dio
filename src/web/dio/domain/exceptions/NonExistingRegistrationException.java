package web.dio.domain.exceptions;

public class NonExistingRegistrationException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public NonExistingRegistrationException(String msg) {
		super(msg);
	}
}
