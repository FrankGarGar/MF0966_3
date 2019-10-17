package com.francisco.app.rest.Entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public @Data @NoArgsConstructor @AllArgsConstructor class Movimiento {
	private Long id;
	private String concepto;
	private Cuenta cuentaEnvio;
	private Cuenta cuentaRecibio;
	private Importe importe;
	public String toString() {
		return String.format("%s | %s | %s | %s", cuentaEnvio, cuentaRecibio, concepto, importe);
	}
	
}
