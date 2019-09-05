package com.ipartek.formacion.mf0967_3.servicios;

import com.ipartek.formacion.mf0967_3.modelo.Libro;

public interface LibrosServicio {
	Iterable<Libro> getAll();
	Libro getOne(Long id);
	
	void insert(Libro libro);
	void update(Libro libro);
	void delete(Long id);
}
