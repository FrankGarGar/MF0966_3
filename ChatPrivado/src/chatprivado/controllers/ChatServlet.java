package chatprivado.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chatprivado.servicios.ChatServicioImp;

/**
 * Servlet implementation class ChatServlet
 */
@WebServlet("/autenticado/chat")
public class ChatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// TODO Auto-generated method stub
		final RequestDispatcher requestDispatcherChatPublico    = request.getRequestDispatcher("/WEB-INF/vistas/chatPublico.jsp");
		final RequestDispatcher requestDispatcherChatIndividual = request.getRequestDispatcher("/WEB-INF/vistas/chatIndividual.jsp");
		Iterable usuarios = ChatServicioImp.getInstancia().DevolverConectados();
		request.setAttribute("usuarios", usuarios);
		requestDispatcherChatPublico.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
