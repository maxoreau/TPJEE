package fr.ibformation.TPJEE.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.ibformation.TPJEE.dao.ContactDaoInDatabase;
import fr.ibformation.TPJEE.dao.daoGenerique;
import fr.ibformation.TPJEE.models.Contact;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/secured/recuperationcontacts")
public class RecuperationContacts extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static final String vue = "/secured/affichage";
       
    private daoGenerique<Contact> dao;
    private List<Contact> contacts;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecuperationContacts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		dao = new ContactDaoInDatabase();
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    contacts = dao.getAll();
		request.getSession().setAttribute("contacts", contacts);
		request.getServletContext().getRequestDispatcher(vue).forward(request, response);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
