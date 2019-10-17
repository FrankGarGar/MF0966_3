package com.francisco.app.rest.accesodatos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.francisco.app.rest.Entidades.Cuenta;
import com.francisco.app.rest.Entidades.Movimiento;
import com.francisco.app.rest.Entidades.Propietario;

public class PropietariosDAOMySQL implements DAO<Long, Propietario>{

	private static final String GETALL_MOVIMIENTOS = "{ call getAllPropietarios() }";
	private static final String GETBY_USERNAME = "{ call getPropietarioByUsername(?) }";
	private String url,driver,user,pass;
	private static PropietariosDAOMySQL instancia = null;
	
	public static PropietariosDAOMySQL getInstancia(String driver,String url,String user,String pass) {
		if(instancia==null) {
			return instancia = new PropietariosDAOMySQL(driver,url,user,pass);
		}else {
			return instancia;
		}
		
	}
	public PropietariosDAOMySQL(String driver,String url,String user,String pass) {
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
	public Iterable<Propietario> getAll() {

		throw new UnsupportedOperationException("Operacion sin implementar");
	}
	@Override
	public Propietario getOne(Long id) {

		throw new UnsupportedOperationException("Operacion sin implementar");
	}
	@Override
	public Propietario insert(Propietario objeto) {

		throw new UnsupportedOperationException("Operacion sin implementar");
	}
	@Override
	public Propietario getByUsername(String username, String password) {
		try (Connection con = getConnection()) {
			try (CallableStatement cs = con.prepareCall(GETBY_USERNAME)) {
				cs.setString(1, username);
				ResultSet rs = cs.executeQuery();

				if(rs.next()) {
					Propietario propietario= new Propietario(new Long(rs.getInt("id")),rs.getString("username"),rs.getString("password"),rs.getString("nombre"),rs.getString("apellidos"));
					
					if(propietario.getPassword().equals(password)) {
						
						return propietario;
					}else {
						return null;
					}
				}
				
			} catch (SQLException e) {
				throw new AccesoDatosException("No se ha podido llamar al procedimiento " + GETBY_USERNAME,e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Ha habido un error al cerrar la conexión a la base de datos", e);
		}
		return null;
	}
	@Override
	public Iterable<Movimiento> getAllForOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Iterable<Cuenta> getCuentas(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
