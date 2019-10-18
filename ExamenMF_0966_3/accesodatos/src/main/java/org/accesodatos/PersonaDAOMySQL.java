package org.accesodatos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.entidades.Persona;

public class PersonaDAOMySQL {
	private final static String URL = "jdbc:mysql://localhost:3307/franciscogarcia?serverTimezone=UTC";
	private String user = "root";
	private String pass = "admin";
	private String driver = "com.mysql.cj.jdbc.Driver";
	private final static String INSERT_PERSONA = "{ call insert_Persona(?,?,?,?) }";
	private final static String UPDATE_PERSONA = "{ call update_Persona(?,?,?,?,?) }";
	private final static String GETBYDNI = "{ call getByDNI(?) }";
	private final static String GETBYEMAIL = "{ call getByEmail(?) }";
	private final static String GETBYNAMEAPELLIDO = "{ call getByNameApellido(?) }";
	private final static String GETONE = "{ call getOne(?) }";

	private final static String GETLASTS = "{ call getlasts() }";
	public PersonaDAOMySQL() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			throw new AccesoDatosException("No se ha encontrado el driver de MySQL", e);
		}
	}
	public Iterable<Persona> getLasts(){
		try (Connection con = DriverManager.getConnection(URL,user,pass)) {
			try (CallableStatement cs = con.prepareCall(GETLASTS)) {

				try (ResultSet rs = cs.executeQuery()) {
					ArrayList<Persona> personas = new ArrayList<Persona>();
					while(rs.next()) {
						personas.add(new Persona(rs.getLong("id"),rs.getString("nombre"),rs.getString("apellido"),rs.getString("email"),rs.getString("dni")));
					}
					if(personas.size()>0) {
						return personas;
					}else {
						return null;
					}

				} catch (SQLException e) {
					throw new AccesoDatosException("Error en el ResultSet", e);
				}
			} catch (SQLException e) {
				throw new AccesoDatosException("No se ha podido hacer la inserción", e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido conectar a la base de datos", e);
		}
	}
	public Persona getByDNI(String dni){
		try (Connection con = DriverManager.getConnection(URL,user,pass)) {
			try (CallableStatement cs = con.prepareCall(GETBYDNI)) {
				cs.setString(1, dni);
				try (ResultSet rs = cs.executeQuery()) {
					if(rs.next()) {
						Persona persona = new Persona(rs.getLong("id"),rs.getString("nombre"),rs.getString("apellido"),rs.getString("email"),rs.getString("dni"));
						return persona;
					}
					return null;

				} catch (SQLException e) {
					throw new AccesoDatosException("Error en el ResultSet", e);
				}
			} catch (SQLException e) {
				throw new AccesoDatosException("No se ha podido hacer la inserción", e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido conectar a la base de datos", e);
		}
	}
	public Iterable<Persona> getByNameApellido(String str){
		try (Connection con = DriverManager.getConnection(URL,user,pass)) {
			try (CallableStatement cs = con.prepareCall(GETBYNAMEAPELLIDO)) {
				cs.setString(1, str);
				try (ResultSet rs = cs.executeQuery()) {
					ArrayList<Persona> personas = new ArrayList<Persona>();
					while(rs.next()) {
						personas.add(new Persona(rs.getLong("id"),rs.getString("nombre"),rs.getString("apellido"),rs.getString("email"),rs.getString("dni")));
					}
					if(personas.size()>0) {
						return personas;
					}else {
						return null;
					}

				} catch (SQLException e) {
					throw new AccesoDatosException("Error en el ResultSet", e);
				}
			} catch (SQLException e) {
				throw new AccesoDatosException("No se ha podido hacer la inserción", e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido conectar a la base de datos", e);
		}
	}
	public Persona getByEmail(String email){
		try (Connection con = DriverManager.getConnection(URL,user,pass)) {
			try (CallableStatement cs = con.prepareCall(GETBYEMAIL)) {
				cs.setString(1, email);
				try (ResultSet rs = cs.executeQuery()) {
					if(rs.next()) {
						Persona persona = new Persona(rs.getLong("id"),rs.getString("nombre"),rs.getString("apellido"),rs.getString("email"),rs.getString("dni"));
						return persona;
					}
					return null;

				} catch (SQLException e) {
					throw new AccesoDatosException("Error en el ResultSet", e);
				}
			} catch (SQLException e) {
				throw new AccesoDatosException("No se ha podido hacer la inserción", e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido conectar a la base de datos", e);
		}
	}
	public Persona update(Persona persona){
		try (Connection con = DriverManager.getConnection(URL,user,pass)) {
			try (CallableStatement cs = con.prepareCall(UPDATE_PERSONA)) {
				cs.setString(1, persona.getNombre());
				cs.setString(2, persona.getApellido());
				cs.setString(3, persona.getEmail());
				cs.setString(4, persona.getDni());
				cs.setLong(5, persona.getId());
				int n = cs.executeUpdate();
				if(n>0) {
					return persona;
				}else {
					return null;
				}
			} catch (SQLException e) {
				throw new AccesoDatosException("No se ha podido hacer la inserción", e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido conectar a la base de datos", e);
		}
	}
	public void insertar(Persona p) {
		try (Connection con = DriverManager.getConnection(URL,user,pass)) {
			try (CallableStatement cs = con.prepareCall(INSERT_PERSONA)) {

				cs.setString(1,p.getNombre() );
				cs.setString(2, p.getApellido());
				cs.setString(3, p.getDni());
				cs.setString(4,p.getEmail());

				int numeroRegistrosModificados = cs.executeUpdate();

				if (numeroRegistrosModificados != 1) {
					throw new AccesoDatosException("No se ha insertado ningún registro o se ha insertado más de uno");
				}
			} catch (SQLException e) {
				throw new AccesoDatosException("No se ha podido hacer la inserción", e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido conectar a la base de datos", e);
		}
	}
	public Persona getOne(String id) {
		try (Connection con = DriverManager.getConnection(URL,user,pass)) {
			try (CallableStatement cs = con.prepareCall(GETONE)) {
				cs.setLong(1, Long.parseLong(id));
				try (ResultSet rs = cs.executeQuery()) {
					if(rs.next()) {
						Persona persona = new Persona(rs.getLong("id"),rs.getString("nombre"),rs.getString("apellido"),rs.getString("email"),rs.getString("dni"));
						return persona;
					}
					return null;

				} catch (SQLException e) {
					throw new AccesoDatosException("Error en el ResultSet", e);
				}
			} catch (SQLException e) {
				throw new AccesoDatosException("No se ha podido hacer la inserción", e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido conectar a la base de datos", e);
		}
	}
}
