package org.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.entidades.Persona;
import org.servicio.PersonaServicioImpl;

@WebServlet("/editar")
public class EditarPersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		if(request.getParameter("id")!=null && !request.getParameter("id").equals("")) {
			request.setAttribute("persona", PersonaServicioImpl.getInstancia().getOne(request.getParameter("id")));
			request.getRequestDispatcher("WEB-INF/vistas/addpersona.jsp").forward(request, response);
			return;
		}
		response.sendRedirect(getServletContext().getContextPath() + "/home");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		if(request.getParameter("id")!=null && !request.getParameter("id").equals("") &&
				request.getParameter("nombre")!=null && !request.getParameter("nombre").equals("") &&
				request.getParameter("apellido")!=null && !request.getParameter("apellido").equals("") &&
				request.getParameter("email")!=null && !request.getParameter("email").equals("") &&
				request.getParameter("dni")!=null && !request.getParameter("dni").equals("")) {
			Persona persona = new Persona(Long.parseLong(request.getParameter("id")),request.getParameter("nombre"),request.getParameter("apellido"),request.getParameter("email"),request.getParameter("dni"));
			Persona p = PersonaServicioImpl.getInstancia().update(persona);

			request.setAttribute("persona",p);
			if(p!=null) {
				request.setAttribute("respuestab", "Registro actualizado exitosamente");
				request.getRequestDispatcher("WEB-INF/vistas/addpersona.jsp").forward(request, response);
			}else {
				request.setAttribute("respuestae", "Error al actualizar el registro vuelve a intentarlo");
				request.getRequestDispatcher("WEB-INF/vistas/addpersona.jsp").forward(request, response);
			
			}
		}
	}

}
