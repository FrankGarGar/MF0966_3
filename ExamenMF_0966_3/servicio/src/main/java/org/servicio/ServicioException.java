package org.servicio;

public class ServicioException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ServicioException() {
		
	}

	public ServicioException(String message) {
		super(message);
		
	}

	public ServicioException(Throwable cause) {
		super(cause);
		
	}

	public ServicioException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public ServicioException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

}
