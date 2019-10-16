package com.francisco.app.rest.accesodatos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.francisco.app.rest.Entidades.Movimiento;
import com.francisco.app.rest.Entidades.Propietario;

public class FabricaDAO {

	private String url,driver,user,pass,motor;
	
	private static FabricaDAO instancia = null;

	public static FabricaDAO getInstancia(String configuracion) {
		if (instancia == null) {
			return instancia = new FabricaDAO(configuracion);
		} else {
			return instancia;
		}
	}

	public FabricaDAO(String configuracion) {
		try (InputStream istream = new FileInputStream(configuracion)){
			Properties p = new Properties();
			p.load(istream);
			motor = p.getProperty("motor");
			url = p.getProperty("url");
			driver = p.getProperty("driver");
			user = p.getProperty("user");
			pass = p.getProperty("pass");
			
		} catch (FileNotFoundException e) {
			throw new AccesoDatosException("No se ha encontrado el fichero de configuración", e);
		} catch (IOException e) {
			throw new AccesoDatosException("No se ha podido leer el fichero de configuración", e);
		}
	}
	public DAO<Long,Movimiento> getDAOBancoOperaciones(){
		if (motor == null) {
			throw new AccesoDatosException("El motor es nulo");
		} else {

			switch (motor) {
			case "mysql":
				
				return MovimientosDAOMySQL.getInstancia(driver, url, user, pass);
				
			// case "oracle": return ProductosDaoOracle.crearInstancia(....);
			default:
				throw new AccesoDatosException("No dispongo del motor " + motor);
			}
		}
	}
	public DAO<Long,Propietario> getDAOPropietarioOperaciones(){
		if (motor == null) {
			throw new AccesoDatosException("El motor es nulo");
		} else {

			switch (motor) {
			case "mysql":
				
				return PropietariosDAOMySQL.getInstancia(driver, url, user, pass);
				
			// case "oracle": return ProductosDaoOracle.crearInstancia(....);
			default:
				throw new AccesoDatosException("No dispongo del motor " + motor);
			}
		}
	}

}
