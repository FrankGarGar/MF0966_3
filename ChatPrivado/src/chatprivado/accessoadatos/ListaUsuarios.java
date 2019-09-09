package chatprivado.accessoadatos;

import java.util.TreeMap;
import java.sql.*;
import chatprivado.models.Usuario;

public class ListaUsuarios extends Conexion implements Procesos<Usuario>,ListaUsuariosInterf<Usuario>{
	private static ListaUsuarios instancia;
	
	public static ListaUsuarios getInstancia() {
		return instancia = new ListaUsuarios();
	}
	private TreeMap<Long, Usuario> usuarios = new TreeMap<>();

	@Override
	public Iterable<Usuario> getAll() {
		
		return usuarios.values();
	}
	private ListaUsuarios() {
		ResultSet rs = SelectUsuarios();
		try {
			
			while (rs.next()) {
				usuarios.put(rs.getLong("id"),new Usuario(rs.getString("username"),rs.getString("password")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public Usuario getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void insert(Usuario o) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update(Usuario o) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Usuario getByUsername(String username) {
		for(Usuario usuario: getAll()) {
			if(username.equals(usuario.getUsername())) {
				return usuario;
			}
		}
		
		return null;
	}
	public ResultSet SelectUsuarios() {
		ResultSet rs = null;
		Statement s = null;
		String sql = "SELECT * FROM zxcv_usuarios";
		try {
			s = super.conexion.createStatement();
			try {
				rs = s.executeQuery(sql);
				return rs;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
