package chatprivado.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chatprivado.models.Usuario;
import chatprivado.servicios.LoginServicioImp;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println(request.getSession().getAttribute("userlog"));
		request.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		request.removeAttribute("errorlog");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Usuario userlog = new Usuario(username, password);
		
		if(LoginServicioImp.getInstancia().autenticar(userlog)) {
			request.getSession().setAttribute("userlog", userlog);
			response.sendRedirect("autenticado/chat");
			//request.getRequestDispatcher("/login").forward(request, response);
			
		}else {
			request.setAttribute("errorlog", "Datos incorrectos. Por favor intentalos de nuevo.");
			request.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(request, response);
		}
		
	}

}
