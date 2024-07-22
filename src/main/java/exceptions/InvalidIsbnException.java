package exceptions;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import utils.ResponseMessage;

public class InvalidIsbnException extends WebApplicationException {

	private static final long serialVersionUID = 1L;

	public InvalidIsbnException() {
		super("Invalid isbn",Response.status(Status.NOT_FOUND).entity(new ResponseMessage("Book not found (invalid isbn)", false)).build());	
	}
}
