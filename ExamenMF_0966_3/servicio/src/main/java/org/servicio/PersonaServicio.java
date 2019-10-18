package org.servicio;
import org.entidades.Persona;
public interface PersonaServicio {
	Iterable<Persona> getLasts();
	Persona getByDni(String dni);
	Persona getByEmail(String email);
	Iterable<Persona> getByNombreApellido(String str);
	void insert(Persona persona);
	Persona update(Persona persona);
	void importar(String rutaFichero);
	Persona getOne(String id);
}
