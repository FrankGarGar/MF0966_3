package com.francisco.app.rest.accesodatos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.francisco.app.rest.Entidades.Cuenta;
import com.francisco.app.rest.Entidades.Importe;
import com.francisco.app.rest.Entidades.Movimiento;
import com.francisco.app.rest.Entidades.Propietario;

public class MovimientosDAOMySQL implements DAO{
	private static final String GETALL_MOVIMIENTOS = "{ call getAllMovimientos() }";
	private static final String GETALLFORONE_MOVIMIENTOS = "{ call getAllForOneMovimientos(?) }";
	private static final String GET_CUENTASBYPROPIETARIO = "{ call getCuentasByPropietario(?) }";
	private static final String GET_CUENTABYID = "{ call getCuentaById(?) }";
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
	public Iterable<Movimiento> getAllForOne(Long id) {
		try(Connection con= getConnection()){
			try (CallableStatement cs = con.prepareCall(GETALLFORONE_MOVIMIENTOS)){
				cs.setInt(1, id.intValue());
				ResultSet rs = cs.executeQuery();
				ArrayList<Movimiento> movs = new ArrayList<Movimiento>();
				Cuenta cuentaE =null;
				Cuenta cuentaR =null;
				Importe importe=null;
				while(rs.next()) {
					cuentaE = new Cuenta(rs.getLong("id_cuentaenvio"),rs.getString("iban"));
					try (CallableStatement cs2 = con.prepareCall(GET_CUENTABYID)){
						cs2.setInt(1, rs.getInt("id_cuentarecibio"));
						ResultSet rs2 = cs2.executeQuery();
						if(rs2.next()) {
							cuentaR = new Cuenta(rs2.getLong("id"),rs2.getString("iban"));
						}
					}catch (SQLException e) {
						throw new AccesoDatosException("No se ha podido llamar al procedimiento " + GET_CUENTABYID,e);
					}
					importe = new Importe(rs.getBigDecimal("cantidad"),rs.getString("divisa"));
					movs.add(new Movimiento(rs.getLong("mid"),rs.getString("concepto"),cuentaE,cuentaR,importe));
				}
				if(movs.size()>0) {
					return movs;
				}
				return null;
			} catch (SQLException e) {
				throw new AccesoDatosException("No se ha podido llamar al procedimiento " + GETALLFORONE_MOVIMIENTOS,e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Ha habido un error al cerrar la conexión a la base de datos", e);
		}
	}
	@Override
	public Movimiento getByUsername(String username, String password) {
		return null;
	}
	@Override
	public Object getOne(Object id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object insert(Object objeto) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Iterable<Cuenta> getCuentas(Long idusuario) {
		try (Connection con = getConnection()) {
			try (CallableStatement cs = con.prepareCall(GET_CUENTASBYPROPIETARIO)) {
				cs.setInt(1, idusuario.intValue());
				ResultSet rs = cs.executeQuery();

				ArrayList<Cuenta> cts = new ArrayList<Cuenta>();
				while(rs.next()) {
					cts.add(new Cuenta(rs.getLong("id"),rs.getString("iban")));
				}
				if(cts.size()>0) {
					return cts;
				}
				
			} catch (SQLException e) {
				throw new AccesoDatosException("No se ha podido llamar al procedimiento " + GET_CUENTASBYPROPIETARIO,e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Ha habido un error al cerrar la conexión a la base de datos", e);
		}
		return null;
	}
	
}
