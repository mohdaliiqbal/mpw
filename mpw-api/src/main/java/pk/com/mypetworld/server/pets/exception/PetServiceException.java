package pk.com.mypetworld.server.pets.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class PetServiceException extends WebApplicationException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PetServiceException() {
		super();
	}

	public PetServiceException(int status) {
		super(status);
	}

	public PetServiceException(Response response) {
		super(response);
	}

	public PetServiceException(Status status) {
		super(status);
	}

	public PetServiceException(String message, int status) {
		super(message, status);
	}

	public PetServiceException(String message, Response response) {
		super(message, response);
	}

	public PetServiceException(String message, Status status) {
		super(message, status);
	}

	public PetServiceException(String message, Throwable cause, int status) {
		super(message, cause, status);
	}

	public PetServiceException(String message, Throwable cause,
			Response response) {
		super(message, cause, response);
	}

	public PetServiceException(String message, Throwable cause, Status status)
			throws IllegalArgumentException {
		super(message, cause, status);
	}

	public PetServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public PetServiceException(String message) {
		super(message);
	}

	public PetServiceException(Throwable cause, int status) {
		super(cause, status);
	}

	public PetServiceException(Throwable cause, Response response) {
		super(cause, response);
	}

	public PetServiceException(Throwable cause, Status status)
			throws IllegalArgumentException {
		super(cause, status);
	}

	public PetServiceException(Throwable cause) {
		super(cause);
	}

	
}
