package com.francisco.app.rest.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.francisco.app.rest.Entidades.Movimiento;
import com.francisco.app.rest.Entidades.Propietario;
import com.francisco.app.rest.servicios.BancoServiciosImpl;

@WebServlet("/autenticado/movimientos")
public class MovimientosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		BancoServiciosImpl servicioBanco = (BancoServiciosImpl) getServletContext().getAttribute("ServiciosBanco");
		String idcuenta = request.getParameter("id");
		Iterable<Movimiento> movs = servicioBanco.getMovimientos(Long.parseLong(idcuenta));
		request.getSession().setAttribute("movs", movs);
		request.getRequestDispatcher("/WEB-INF/vistas/movimientos.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
