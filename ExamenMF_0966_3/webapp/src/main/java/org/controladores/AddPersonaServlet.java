package org.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.entidades.Persona;
import org.servicio.PersonaServicioImpl;


@WebServlet("/agregar")
public class AddPersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		request.getRequestDispatcher("WEB-INF/vistas/addpersona.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		if(request.getParameter("nombre")!=null && !request.getParameter("nombre").equals("") &&
				request.getParameter("apellido")!=null && !request.getParameter("apellido").equals("") &&
				request.getParameter("email")!=null && !request.getParameter("email").equals("") &&
				request.getParameter("dni")!=null && !request.getParameter("dni").equals("")) {
			Persona persona = new Persona(request.getParameter("nombre"),request.getParameter("apellido"),request.getParameter("email"),request.getParameter("dni"));
			PersonaServicioImpl.getInstancia().insert(persona);
			response.sendRedirect(getServletContext().getContextPath() + "/home");
		}
	}

}
