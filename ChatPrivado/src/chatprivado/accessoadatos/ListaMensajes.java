package chatprivado.accessoadatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.TreeMap;

import chatprivado.models.Mensaje;
import chatprivado.models.Usuario;

public class ListaMensajes extends Conexion implements Procesos<Mensaje>{
	private static ListaMensajes instancia;
	
	public static ListaMensajes getInstancia() {
		return instancia = new ListaMensajes();
	}
	private TreeMap<Long, Mensaje> mensajes = new TreeMap<>();

	@Override
	public Iterable<Mensaje> getAll() {
		return mensajes.values();
		
	}
	private ListaMensajes() {
		ResultSet rs = SelectMensajes();
		try {
			System.out.println();
			while (rs.next()) {
				Mensaje mensaje = new Mensaje(rs.getString("mensaje"),new Usuario(rs.getString("username")),rs.getTimestamp("fecha"));
				
				mensajes.put(rs.getLong("idm"),mensaje);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public Mensaje getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Mensaje msj) {
		String sql = "INSERT INTO zxcv_mensajespublicos (mensaje,id_usuario,fecha) values (?, ?, ?)";
		
		try {
			try (PreparedStatement ps = conexion.prepareStatement(sql)) {
				
				ps.setString(1,msj.getMensaje());
				ps.setLong(2, msj.getUsuario().getId());
				ps.setTimestamp(3,msj.getFecha2());
				int res =ps.executeUpdate();
				
				if(res==1) {
					return true;
				}
				
			}
		} catch (SQLException e) {
			return false;
		}
		return false;
		
	}

	@Override
	public void update(Mensaje o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}
	
	public ResultSet SelectMensajes() {
		ResultSet rs = null;
		Statement s = null;
		String sql = "SELECT us.id as idu,us.username,mp.id as idm,mp.mensaje,mp.fecha FROM zxcv_usuarios us INNER JOIN zxcv_mensajespublicos mp ON us.id=mp.id_usuario ORDER BY fecha ASC";
		try {
			s = conexion.createStatement();
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
