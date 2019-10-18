package org.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public @Data @NoArgsConstructor @AllArgsConstructor class Persona {
	private Long id;
	private String nombre;
	private String apellido;
	private String email;
	private String dni;
	public Persona(String nombre,String apellido,String email,String dni) {
		setNombre(nombre);
		setApellido(apellido);
		setEmail(email);
		setDni(dni);
	}
}
