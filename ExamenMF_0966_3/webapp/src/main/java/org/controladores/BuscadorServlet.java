package org.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.entidades.Persona;
import org.servicio.PersonaServicioImpl;

@WebServlet("/buscador")
public class BuscadorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String opcion = request.getParameter("opcion");
		Persona persona=null;
		if (opcion != null && !opcion.equals("")) {
			if (opcion.equals("dni")) {
				String dni = request.getParameter("dni");
				persona = PersonaServicioImpl.getInstancia().getByDni(dni);
				request.setAttribute("persona", persona);
				request.setAttribute("opcion", opcion);
			}
			if (opcion.equals("email")) {
				String email = request.getParameter("email");
				persona = PersonaServicioImpl.getInstancia().getByEmail(email);
				request.setAttribute("persona", persona);
				request.setAttribute("opcion", opcion);
			}
			if (opcion.equals("nombres")) {
				String nombres = request.getParameter("nombres");
				Iterable<Persona> personas = PersonaServicioImpl.getInstancia().getByNombreApellido(nombres);
				request.setAttribute("personas", personas);
				request.setAttribute("opcion", opcion);
				System.out.println(nombres);
			}
			request.getRequestDispatcher("WEB-INF/vistas/buscador.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
