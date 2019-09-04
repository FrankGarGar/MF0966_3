package com.ipartek.formacion.mf0967_3.servicios;

import java.math.BigDecimal;
import java.util.TreeMap;

import com.ipartek.formacion.mf0967_3.modelo.Libro;

public class LibrosServicioImpl implements LibrosServicio {

	private static LibrosServicioImpl librosServicioImpl;
	
	public static LibrosServicio getInstance() {
		if (librosServicioImpl == null) {
			librosServicioImpl = new LibrosServicioImpl();
		}
		
		return librosServicioImpl;
	}
	
	private TreeMap<Long, Libro> libros;
	
	private LibrosServicioImpl() {
		libros = new TreeMap<>();

		for (long i = 1; i <= 8; i++) {
			libros.put(i * 10, new Libro(
					i * 10,
					"libro" + ((i - 1) % 3 + 1) + ".png",
					"Los futbolísimos. El misterio del jugador número " + i + " (T...", 
					"Roberto Santiago",
					new BigDecimal("11." + i * 10), 
					new BigDecimal(i % 2 == 0 ? "0.05" : "0")));
		}
	}
	
	@Override
	public Iterable<Libro> getLibros() {
		return libros.values();
	}

	@Override
	public Libro getLibro(Long id) {
		return libros.get(id);
	}

	@Override
	public void insertLibro(Libro libro) {
		Long id = libros.lastKey() + 1;
		libro.setId(id);
		libros.put(id, libro);
	}

	@Override
	public void updateLibro(Libro libro) {
		libros.put(libro.getId(), libro);
	}

	@Override
	public void deleteLibro(Long id) {
		libros.remove(id);
	}
	
}
