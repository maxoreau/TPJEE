package fr.ibformation.TPJavaEE.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.ibformation.TPJavaEE.dao.ContactDaoInDatabase;
import fr.ibformation.TPJavaEE.dao.daoGenerique;
import fr.ibformation.TPJavaEE.models.Contact;

/**
 * Servlet implementation class SaisirContact
 */
@WebServlet("/secured/saisircontact")
public class SaisirContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static final String vue = "/secured/saisiecontact";
    
    private daoGenerique<Contact> dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaisirContact() {
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
		request.getSession().getServletContext().getRequestDispatcher(vue).forward(request, response);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nom;
		String prenom;
		String numero;
		
		if (request.getParameter("nom") == null) {
			nom = "";
		} else {
			nom = (String) request.getParameter("nom");
		}
		if (request.getParameter("prenom") == null) {
			prenom = "";
		} else {
			prenom = (String) request.getParameter("prenom");
		}
		if (request.getParameter("numero") == null) {
			numero = "";
		} else {
			numero = (String) request.getParameter("numero");
		}
		
		dao.create(new Contact(prenom, nom, numero));
			
		request.getSession().getServletContext().getRequestDispatcher(vue).forward(request, response);
		return;
		
	}

}
