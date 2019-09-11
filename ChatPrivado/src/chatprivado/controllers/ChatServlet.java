package chatprivado.controllers;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import chatprivado.models.Mensaje;
import chatprivado.models.Usuario;
import chatprivado.servicios.ChatServicioImp;

/**
 * Servlet implementation class ChatServlet
 */
@WebServlet("/autenticado/chat")
public class ChatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		final RequestDispatcher requestDispatcherChatPublico    = request.getRequestDispatcher("/WEB-INF/vistas/chatPublico.jsp");
		Iterable<Usuario> usuarios = ChatServicioImp.getInstancia().DevolverConectados();
		Iterable<Mensaje> mensajes = ChatServicioImp.getInstancia().DevolverMensajesAll();
		request.setAttribute("mensajes", mensajes);
		request.setAttribute("usuarios", usuarios);
		requestDispatcherChatPublico.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("userlog")!=null) {
			Usuario userlog = (Usuario) request.getSession().getAttribute("userlog");
		
			if(request.getParameter("msj")!="" && request.getParameter("msj")!=null && request.getParameter("cant")!=null) {
				Date date= new Date();
				long time = date.getTime();
				Timestamp ts = new Timestamp(time);
				if(ChatServicioImp.getInstancia().EnviarMensaje(new Mensaje(request.getParameter("msj"),userlog,ts))) {
					
					Iterable<Mensaje> mensajes = ChatServicioImp.getInstancia().DevolverMensajesAllUsersNews(request.getParameter("cant"));
					Gson gson = new Gson();
					response.getWriter().append(gson.toJson(mensajes));
				}else {
					response.getWriter().append("2");
				}
			}
			if(request.getParameter("recarga") != null && request.getParameter("cant")!=null) {
				Iterable<Mensaje> mensajes = ChatServicioImp.getInstancia().DevolverMensajesAllUsersNews(request.getParameter("cant"));
				Gson gson = new Gson();
				response.getWriter().append(gson.toJson(mensajes));
			}
			if(request.getParameter("recarga") != null && request.getParameter("userchat")!=null) {
				int idrecibido = Integer.parseInt(request.getParameter("userchat"));
				int idcreado = userlog.getId().intValue();
				Iterable<Mensaje> mensajes = ChatServicioImp.getInstancia().DevolverMensajesPrivados(idcreado,idrecibido);
				Gson gson = new Gson();
				response.getWriter().append(gson.toJson(mensajes));
			}
		}
	}

}
