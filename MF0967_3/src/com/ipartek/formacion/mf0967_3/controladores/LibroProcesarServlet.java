package com.ipartek.formacion.mf0967_3.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.mf0967_3.modelo.Libro;
import com.ipartek.formacion.mf0967_3.servicios.LibrosServicio;
import com.ipartek.formacion.mf0967_3.servicios.LibrosServicioImpl;

@WebServlet("/admin/libroprocesar")
public class LibroProcesarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.request = request;
		this.response = response;
		
		request.setCharacterEncoding("utf8");
		
		String op = request.getParameter("op");
		
		if(op == null) {
			irAListado();
			return;
		}
		
		LibrosServicio librosServicio = LibrosServicioImpl.getInstance();
		
		String id;
		Libro libro;
		
		switch(op) {
		case "borrar":
			id = request.getParameter("id");
			librosServicio.deleteLibro(Long.parseLong(id));
			crearAlerta("Libro borrado correctamente", "success");
			break;
		case "modificar":
			libro = crearLibro();
			if(libro.isError()) {
				irAMostrarLibro(libro);
				return;
			}
			librosServicio.updateLibro(libro);
			crearAlerta("Libro modificado correctamente", "success");
			break;
		case "alta":
			libro = crearLibro();
			if(libro.isError()) {
				irAMostrarLibro(libro);
				return;
			}
			librosServicio.insertLibro(libro);
			crearAlerta("Libro añadido correctamente", "success");
			break;
		default:
			crearAlerta("Operación no reconocida", "danger");
			irAListado();
			return;
		}
		
		irAListado();
	}

	private void irAMostrarLibro(Libro libro)
			throws ServletException, IOException {
		request.setAttribute("libro", libro);
		request.setAttribute("op", libro.getId() == 0 ? "alta" : "modificar");
		crearAlerta("Error en los datos del libro", "danger");
		request.getRequestDispatcher("/WEB-INF/vistas/libro.jsp").forward(request, response);
	}

	private void irAListado() throws IOException {
		//request.getRequestDispatcher("/admin/listado").forward(request, response);
		response.sendRedirect(request.getContextPath() + "/admin/listado");
	}

	private void crearAlerta(String texto, String tipo) {
		request.getSession().setAttribute("mensaje", texto);
		request.getSession().setAttribute("tipomensaje", tipo);
	}

	private Libro crearLibro() throws ServletException, IOException {
		String id = request.getParameter("id");
		String imagen = request.getParameter("imagen");
		String descripcion = request.getParameter("descripcion");
		String autor = request.getParameter("autor");
		String precio = request.getParameter("precio");
		String descuento = request.getParameter("descuento");
		
		if(id == "") {
			id = "0";
		}
		
		Libro libro = new Libro(
				id,
				imagen,
				descripcion,
				autor,
				precio,
				descuento);
		
		return libro;
	}

}
