package fr.ibformation.TPJEE.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Identification
 */
@WebServlet("/identification")
public class Identification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Identification() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String login = (String) request.getParameter("login");
		String pass = (String) request.getParameter("motdepasse");
		
		if ((login.compareTo("Max") == 0) && (pass.compareTo("toto") == 0)) {
			request.getSession().setAttribute("isConnected", true);
			request.getSession().setAttribute("login", login);
			request.getSession().getServletContext().getRequestDispatcher("/menu").forward(request, response);
			return;
		} else {
			request.getSession().getServletContext().getRequestDispatcher("/login").forward(request, response);
			return;
		}
		
	}

}
