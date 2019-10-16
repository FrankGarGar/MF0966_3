package com.francisco.app.rest.servicios;

import java.math.BigDecimal;
import java.util.TreeMap;

import com.francisco.app.rest.Entidades.Cuenta;
import com.francisco.app.rest.Entidades.Movimiento;
import com.francisco.app.rest.Entidades.Propietario;

public interface BancoServicios {
	public Propietario getPropietarioById(Long id);
	public Propietario getPropietarioByName(String nombre);
	public Propietario getPropietarioByCuenta(String iban);
	public Cuenta getCuentaByIban(String iban);
	public TreeMap<Long, Cuenta> getCuentasPropietario(String idpropietario);
	public Iterable<Movimiento> getMovimientos(Long id);
	public boolean transferencia(Long idCuentaOrigen,Long idCuentaDestino,String concepto, BigDecimal cantidad,String divisa);
	public Propietario Login(String username,String password);
}
