package chatprivado.filters;

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


@WebFilter(dispatcherTypes = {
		DispatcherType.REQUEST, 
		DispatcherType.FORWARD
}
			, urlPatterns = { "/usuario/*" })
public class AllFilter implements Filter {

 
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// place your code here
				HttpServletRequest httpRequest = (HttpServletRequest)request;
				
				//Usuario usuario = (Usuario) httpRequest.getSession().getAttribute("usuario");
				
//				if(usuario == null) {
//					httpRequest.getRequestDispatcher("/login").forward(request, response);
//					return;
//				}
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
