package com.francisco.app.rest.Entidades;

import java.util.TreeMap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public @Data @NoArgsConstructor @AllArgsConstructor class Propietario {
	private Long id;
	private String dni;
	private String nombre,apellidos,username,password;
	private TreeMap<Long, Cuenta> cuentas = new TreeMap<Long, Cuenta>();
	public Propietario(String username2, String password2) {
		setUsername(username2);
		setPassword(password2);
		
	}
	public Propietario(Long id, String username2, String password2) {
		setId(id);
		setUsername(username2);
		setPassword(password2);
		
	}
	public Propietario(Long id, String username,String password, String nombre, String apellidos) {
		setId(id);
		setPassword(password);
		setUsername(username);
		setNombre(nombre);
		setApellidos(apellidos);
	}
}
