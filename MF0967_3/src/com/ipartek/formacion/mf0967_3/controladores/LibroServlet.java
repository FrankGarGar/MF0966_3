package com.ipartek.formacion.mf0967_3.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.mf0967_3.modelo.Libro;
import com.ipartek.formacion.mf0967_3.servicios.LibrosServicioImpl;

@WebServlet("/admin/libro")
public class LibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		Libro libro = null;

		if (id != null) {

			long l = Long.parseLong(id);
			
			libro = LibrosServicioImpl.getInstance().getLibro(l);
		}
		
		request.setAttribute("libro", libro);
		request.setAttribute("op", id == null ? "alta" : "modificar");
		
		request.getRequestDispatcher("/WEB-INF/vistas/libro.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
