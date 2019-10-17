package com.francisco.app.rest.Entidades;

import java.util.TreeMap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public @Data @NoArgsConstructor @AllArgsConstructor class Cuenta {
	private Long id;
	private String iban;
	private TreeMap<Long, Propietario> propietarios = new TreeMap<Long, Propietario>();
	private TreeMap<Long, Movimiento> movimientos = new TreeMap<Long, Movimiento>();
	
	public String toString() {
		return String.format("%s", iban);
	}
	public Cuenta(Long id , String iban) {
		setId(id);
		setIban(iban);
		
	}
}
