package fr.ibformation.TPJavaEE.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.ibformation.TPJavaEE.dao.ContactDaoInDatabase;
import fr.ibformation.TPJavaEE.dao.daoGenerique;
import fr.ibformation.TPJavaEE.models.Contact;

/**
 * Servlet implementation class DeleteContact
 */
@WebServlet("/secured/deletecontact")
public class DeleteContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private daoGenerique<Contact> dao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteContact() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	dao = new ContactDaoInDatabase();
    }
    
    @Override
    public void destroy() {
    	// TODO Auto-generated method stub
    	super.destroy();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Contact> contacts = dao.getAll();
		request.getSession().setAttribute("contacts", contacts);
		request.getSession().getServletContext().getRequestDispatcher("/secured/deleteform").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		dao.delete(request.getParameter("contact"));		
		doGet(request, response);
	}

}
