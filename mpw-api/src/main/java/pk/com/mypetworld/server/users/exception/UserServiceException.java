package pk.com.mypetworld.server.users.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class UserServiceException extends WebApplicationException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserServiceException() {
		super();
	}

	public UserServiceException(int status) {
		super(status);
	}

	public UserServiceException(Response response) {
		super(response);
	}

	public UserServiceException(Status status) {
		super(status);
	}

	public UserServiceException(String message, int status) {
		super(message, status);
	}

	public UserServiceException(String message, Response response) {
		super(message, response);
	}

	public UserServiceException(String message, Status status) {
		super(message, status);
	}

	public UserServiceException(String message, Throwable cause, int status) {
		super(message, cause, status);
	}

	public UserServiceException(String message, Throwable cause,
			Response response) {
		super(message, cause, response);
	}

	public UserServiceException(String message, Throwable cause, Status status)
			throws IllegalArgumentException {
		super(message, cause, status);
	}

	public UserServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserServiceException(String message) {
		super(message);
	}

	public UserServiceException(Throwable cause, int status) {
		super(cause, status);
	}

	public UserServiceException(Throwable cause, Response response) {
		super(cause, response);
	}

	public UserServiceException(Throwable cause, Status status)
			throws IllegalArgumentException {
		super(cause, status);
	}

	public UserServiceException(Throwable cause) {
		super(cause);
	}

	
}
