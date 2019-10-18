package org.controladores;

public class ControladorException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ControladorException() {
		
	}

	public ControladorException(String arg0) {
		super(arg0);
		
	}

	public ControladorException(Throwable arg0) {
		super(arg0);
		
	}

	public ControladorException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		
	}

	public ControladorException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		
	}

}
