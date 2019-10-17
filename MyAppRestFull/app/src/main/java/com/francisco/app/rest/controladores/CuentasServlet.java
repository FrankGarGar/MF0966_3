package com.francisco.app.rest.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.francisco.app.rest.Entidades.Cuenta;
import com.francisco.app.rest.Entidades.Propietario;
import com.francisco.app.rest.servicios.BancoServiciosImpl;

@WebServlet("/autenticado/mis-cuentas")
public class CuentasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		BancoServiciosImpl servicioBanco = (BancoServiciosImpl) getServletContext().getAttribute("ServiciosBanco");
		Propietario propses = (Propietario) request.getSession().getAttribute("propietariolog");
		Iterable<Cuenta> cts = servicioBanco.getCuentasPropietario(propses.getId());
		System.out.println(cts);
		request.getSession().setAttribute("cts", cts);
		
		request.getRequestDispatcher("/WEB-INF/vistas/cuentas.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
