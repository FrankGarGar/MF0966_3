package com.francisco.app.rest.controladores;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.francisco.app.rest.Entidades.Propietario;
import com.francisco.app.rest.modelos.LoginForm;
import com.francisco.app.rest.servicios.BancoServiciosImpl;
@WebServlet("/ingresa")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String LOGIN_JSP = "/WEB-INF/vistas/login.jsp";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher requestDispatcherLogin = request.getRequestDispatcher(LOGIN_JSP);
		requestDispatcherLogin.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher requestDispatcherLogin = request.getRequestDispatcher(LOGIN_JSP);
		BancoServiciosImpl servicioBanco = (BancoServiciosImpl) getServletContext().getAttribute("ServiciosBanco");

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		LoginForm loginForm = new LoginForm(username,password);
		if(!loginForm.isError()) {
			Propietario propietario= servicioBanco.autenticar(loginForm.getUsername(),loginForm.getPassword());
			if(propietario==null) {
				request.setAttribute("propietario", loginForm);
				requestDispatcherLogin.forward(request, response);
				return;
			}else {
				request.getSession().setAttribute("propietariolog", propietario);
				response.sendRedirect(request.getServletContext().getContextPath() + "/autenticado/home");
				return;
			}
		}
	}

}
