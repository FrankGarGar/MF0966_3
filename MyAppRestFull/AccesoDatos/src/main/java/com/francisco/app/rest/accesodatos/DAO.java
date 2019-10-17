package com.francisco.app.rest.accesodatos;

import com.francisco.app.rest.Entidades.Cuenta;
import com.francisco.app.rest.Entidades.Movimiento;

public interface DAO<PK,T> {
	public Iterable<T> getAll();
	public T getOne(PK id);
	public T insert(T objeto);
	public T getByUsername(String username,String password);
	public Iterable<Movimiento> getAllForOne(Long id);
	public Iterable<Cuenta> getCuentas(Long id);
}
