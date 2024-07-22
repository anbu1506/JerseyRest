package exceptions;

public class DbConnectionException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public DbConnectionException(String msg) {
		super(msg);
	}
}
