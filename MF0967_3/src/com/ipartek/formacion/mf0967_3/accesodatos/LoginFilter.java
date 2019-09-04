package com.ipartek.formacion.mf0967_3.accesodatos;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.mf0967_3.modelo.Login;

@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.INCLUDE,
				DispatcherType.FORWARD
		}
					, urlPatterns = { "/admin/*" })
public class LoginFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		Login login = (Login)session.getAttribute("login");

		if(login == null) {
			request.getRequestDispatcher("/login").forward(request, response);
			return;
		}

		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
