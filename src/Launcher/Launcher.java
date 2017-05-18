package Launcher;

import fr.ibformation.TPJEE.dao.ContactDaoInDatabase;
import fr.ibformation.TPJEE.dao.daoGenerique;
import fr.ibformation.TPJEE.models.Contact;

public class Launcher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		daoGenerique<Contact> dao = new ContactDaoInDatabase();
		Contact contact = new Contact("a", "aa", "aaa");
		dao.create(contact);
		System.out.println(dao.getAll());
		dao.delete(contact.getNumero());
		System.out.println(dao.getAll());
		
	}

}
