package com.francisco.app.rest.accesodatos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.francisco.app.rest.Entidades.Movimiento;

public class MovimientosDAOMySQL implements DAO<Long, Movimiento>{
	private static final String GETALL_MOVIMIENTOS = "{ call getAllMovimientos() }";
	private String url,driver,user,pass;
	private static MovimientosDAOMySQL instancia = null;
	
	public static MovimientosDAOMySQL getInstancia(String driver,String url,String user,String pass) {
		if(instancia==null) {
			return instancia = new MovimientosDAOMySQL(driver,url,user,pass);
		}else {
			return instancia;
		}
		
	}
	public MovimientosDAOMySQL(String driver,String url,String user,String pass) {
		this.driver=driver;
		this.url=url;
		this.user=user;
		this.pass=pass;
		
	}
	private Connection getConnection() {
		try {
			Class.forName(driver);
			return DriverManager.getConnection(url, user, pass);
		}catch (SQLException e) {
			throw new AccesoDatosException("Ha habido un error al conectar a la base de datos", e);
		} catch (ClassNotFoundException e) {
			throw new AccesoDatosException("No se ha encontrado el driver de JDBC de MySQL", e);
		}
	}
	@Override
	public Iterable<Movimiento> getAll() {

		throw new UnsupportedOperationException("Operacion sin implementar");
	}
	@Override
	public Movimiento getOne(Long id) {

		throw new UnsupportedOperationException("Operacion sin implementar");
	}
	@Override
	public Movimiento insert(Movimiento objeto) {

		throw new UnsupportedOperationException("Operacion sin implementar");
	}
	@Override
	public Movimiento getByUsername(String username, String password) {
		return null;
	}
}
