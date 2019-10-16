package com.francisco.app.rest.listenners;

import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.francisco.app.rest.servicios.BancoServiciosImpl;



@WebListener
public class InicioAppListenner implements ServletContextListener, ServletContextAttributeListener {
	public void contextInitialized(ServletContextEvent sce)  { 
    	String rutaWebApp = sce.getServletContext().getRealPath("/");
		String rutaConfiguracion = rutaWebApp + "WEB-INF\\configuracion.properties";
		sce.getServletContext().setAttribute("ServiciosBanco", BancoServiciosImpl.crearInstancia(rutaConfiguracion));
		
    }

    public void contextDestroyed(ServletContextEvent sce)  {
    	// NO sabemos si se va a ejecutar a ciencia cierta
    }
}