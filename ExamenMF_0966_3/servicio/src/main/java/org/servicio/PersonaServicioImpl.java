package org.servicio;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import org.accesodatos.PersonaDAOMySQL;
import org.entidades.Persona;

public class PersonaServicioImpl implements PersonaServicio {
	private static PersonaServicioImpl instancia = null;
	private static PersonaDAOMySQL personaDAO = new PersonaDAOMySQL();
	private PersonaServicioImpl() {
	}

	public static PersonaServicioImpl getInstancia() {
		if(instancia==null) {
			return instancia=new PersonaServicioImpl();
		}else {

			return instancia;
		}
	}

	@Override
	public Iterable<Persona> getLasts() {
		return personaDAO.getLasts();
	}
	@Override
	public Persona getOne(String id) {
		return personaDAO.getOne(id);
	}

	@Override
	public Persona getByDni(String dni) {
		return personaDAO.getByDNI(dni);
	}

	@Override
	public Persona getByEmail(String email) {
		return personaDAO.getByEmail(email);
	}

	@Override
	public Iterable<Persona> getByNombreApellido(String str) {
		return personaDAO.getByNameApellido(str);
	}

	@Override
	public void insert(Persona persona) {
		personaDAO.insertar(persona);
	}

	@Override
	public Persona update(Persona persona) {
		return personaDAO.update(persona);
	}

	@Override
	public void importar(String rutaFichero) {
		try (FileInputStream fis = new FileInputStream(rutaFichero)) {
			try (BufferedReader br = new BufferedReader(new InputStreamReader(fis, StandardCharsets.UTF_8))) {

				String linea = null;

				Persona p = new Persona();
				while ((linea = br.readLine()) != null) {
					String[] datos = linea.split(",");
					p.setNombre(datos[0]);
					p.setApellido(datos[1]);
					p.setDni(datos[5]);
					p.setEmail(datos[4]);
					personaDAO.insertar(p);
				}
			}
		} catch (FileNotFoundException e) {
			throw new ServicioException("No se ha encontrado el fichero", e);
		} catch (IOException e) {
			throw new ServicioException("No se ha podido abrir el fichero", e);
		}

	}

}
