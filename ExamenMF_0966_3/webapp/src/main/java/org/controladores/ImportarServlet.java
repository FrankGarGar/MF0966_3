package org.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.servicio.PersonaServicioImpl;
import org.servicio.ServicioException;

@WebServlet("/importar")
@MultipartConfig
public class ImportarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		request.getRequestDispatcher("/WEB-INF/vistas/importar.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		if(request.getParameter("file")!=null) {
			try {
				// String file = "C:\Users\curso\Desktop\personas.txt";
				PersonaServicioImpl.getInstancia().importar(request.getParameter("file"));
			} catch (ServicioException e) {
				throw new ControladorException("Error al importar");
			}
			request.setAttribute("resultado", "Importe realizado exitosamente");
			
		}
		request.getRequestDispatcher("/WEB-INF/vistas/importar.jsp").forward(request, response);
		
	}
	
}
