package com.ipartek.formacion.mf0967_3.servicios;

import com.ipartek.formacion.mf0967_3.modelo.Libro;

public interface LibrosServicio {
	Iterable<Libro> getLibros();
	Libro getLibro(Long id);
	
	void insertLibro(Libro libro);
	void updateLibro(Libro libro);
	void deleteLibro(Long id);
}
