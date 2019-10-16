package com.francisco.app.rest.modelos;

import lombok.Data;

public @Data class LoginForm {
	private String username;
	private String password;
	private boolean error;
	private String errorGeneral;
	
	public LoginForm(String username,String password) {
		if(username==null || password==null || username.trim().length()<5 || password.trim().length()<5 ) {
			setError(true);
			setErrorGeneral("Contraseña o usuario incorrectos o muy cortos");
		}
		setUsername(username);
		setPassword(password);
	}
}
