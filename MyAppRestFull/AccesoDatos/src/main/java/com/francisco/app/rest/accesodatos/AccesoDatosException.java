package com.francisco.app.rest.accesodatos;

public class AccesoDatosException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AccesoDatosException() {
		
	}

	public AccesoDatosException(String arg0) {
		super(arg0);
		
	}

	public AccesoDatosException(Throwable arg0) {
		super(arg0);
		
	}

	public AccesoDatosException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		
	}

	public AccesoDatosException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		
	}

}
