package fr.ibformation.TPJEE.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class Secured
 */
@WebFilter("/secured/*")
public class Secured implements Filter {

    /**
     * Default constructor. 
     */
    public Secured() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		if ((req.getSession().getAttribute("isConnected") == null)) {
			req.getSession().setAttribute("isConnected", false);
		} 
		
		if ((boolean) req.getSession().getAttribute("isConnected")) {
			chain.doFilter(request, response);
			return;
		} else {
			req.getSession().getServletContext().getRequestDispatcher("/login").forward(request, response);
			return;			
		}
				
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
