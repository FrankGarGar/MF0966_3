package com.ipartek.formacion.mf0967_3.servicios;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TreeMap;

import com.ipartek.formacion.mf0967_3.accesodatos.Conexion;
import com.ipartek.formacion.mf0967_3.modelo.Libro;

public class LibrosServicioImpl extends Conexion implements LibrosServicio {

	private static LibrosServicioImpl librosServicioImpl;

	public static LibrosServicio getInstance() {
		
		librosServicioImpl = new LibrosServicioImpl();


		return librosServicioImpl;
	}

	private TreeMap<Long, Libro> libros;

	@SuppressWarnings("null")
	public ResultSet SelectLibros() {
		ResultSet rs = null;
		Statement s = null;
		try {
			s = super.con.createStatement();
			String sql = "SELECT * FROM libros";

			try {
				rs = s.executeQuery(sql);
				return rs;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	private LibrosServicioImpl() {
		ResultSet ls = SelectLibros();
		libros = new TreeMap<>();
		try {
			while (ls.next()) {

				libros.put(ls.getLong("id"),
						new Libro(ls.getLong("id"), ls.getString("img"), ls.getString("titulo"), ls.getString("autor"),
								ls.getBigDecimal("precio"),
								ls.getBigDecimal("descuento")));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
//			try {
//				ls.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
	}

	@Override
	public Iterable<Libro> getAll() {
		return libros.values();
	}

	@Override
	public Libro getOne(Long id) {
		return libros.get(id);
	}

	@Override
	public void insert(Libro libro) {
		Long id = libros.lastKey() + 1;
		libro.setId(id);
		libros.put(id, libro);
		Statement s = null;
		try {
			s = super.con.createStatement();
			String sql = "INSERT INTO libros (titulo,autor,img,precio,descuento) VALUES ('" + libro.getDescripcion() + "' , '" + libro.getAutor() + "','" + libro.getImagen() + "'," + libro.getPrecio() + "," + libro.getDescuento() + ")";
			
			s.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		try {
			s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Libro libro) {
		libros.put(libro.getId(), libro);
		
		
			String sql = "UPDATE libros SET titulo=?,autor=?,img=?,precio=?,descuento=? WHERE id=?";
			
			try {
				try (PreparedStatement ps = con.prepareStatement(sql)) {
					
					ps.setString(1, libro.getDescripcion()); // Set Titulo
					ps.setString(2, libro.getAutor());// Set Autor
					ps.setString(3, libro.getImagen()); // Set Img
					ps.setBigDecimal(4, libro.getPrecio()); // Set Precio
					ps.setBigDecimal(5, libro.getDescuento()); // Set descuento
					ps.setLong(6, libro.getId()); // Where id = 
					
					ps.executeUpdate();
				}
			}catch(SQLException e){
			
			}
	}

	@Override
	public void delete(Long id) {
		libros.remove(id);
		
		String sql = "DELETE FROM libros WHERE id=?;";
		
		try {
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				
				ps.setLong(1, id); // Where id = 
				
				ps.executeUpdate();
				
			}
		}catch(SQLException e){
		
		}
	}

}
