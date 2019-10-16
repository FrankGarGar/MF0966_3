package com.francisco.app.rest.servicios;

public class ServiciosException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ServiciosException() {
		
	}

	public ServiciosException(String arg0) {
		super(arg0);
		
	}

	public ServiciosException(Throwable arg0) {
		super(arg0);
		
	}

	public ServiciosException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		
	}

	public ServiciosException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		
	}

}
