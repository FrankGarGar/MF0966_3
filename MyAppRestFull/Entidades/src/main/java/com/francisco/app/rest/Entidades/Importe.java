package com.francisco.app.rest.Entidades;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public @AllArgsConstructor @NoArgsConstructor @Data class Importe {
	private BigDecimal cantidad;
	private String divisa;
}
