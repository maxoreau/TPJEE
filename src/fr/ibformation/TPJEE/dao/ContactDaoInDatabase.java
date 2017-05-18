package fr.ibformation.TPJEE.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.ibformation.TPJEE.models.Contact;

public class ContactDaoInDatabase implements daoGenerique<Contact> {

	@Override
	public void create(Contact contact) {
		int contactId = -1;
		contactId = getId(contact);
		if (contactId != -1) {
			// le contact existe déjà donc on ne fait rien
			System.out.println("le contact ");
			System.out.println(contact.toString());
			System.out.println("existe déjà");
		} else { // le contact n'existe pas donc on peut le créer
			Connection connection = ConnectionDatabase.getConnectionDatabase().getConnection();
			PreparedStatement pstmt = null;
			try {
				pstmt = connection.prepareStatement("INSERT INTO contacts (prenom, nom, numero) VALUES (?, ?, ?);");
				pstmt.setString(1, contact.getPrenom());
				pstmt.setString(2, contact.getNom());
				pstmt.setString(3, contact.getNumero());
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
						System.out.println("Statement close problem");
					}
				}
			}

		}
	}

	@Override
	public List<Contact> readByName(String name) {
		Connection connection = ConnectionDatabase.getConnectionDatabase().getConnection();
		PreparedStatement pstmt = null;
		List<Contact> contacts = new ArrayList<>();
		try {
			pstmt = connection.prepareStatement("SELECT * FROM contacts WHERE nom = ?;");
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				contacts.add(new Contact(rs.getString("prenom"), rs.getString("nom"), rs.getString("numero")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return contacts;
	}

	@Override
	public void update(Contact contact) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String numero) {
	
			Connection connection = ConnectionDatabase.getConnectionDatabase().getConnection();
			PreparedStatement pstmt = null;
			try {
				pstmt = connection.prepareStatement("DELETE FROM contacts WHERE numero = ?;");
				pstmt.setString(1, numero);
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}

	}

	@Override
	public List<Contact> getAll() {
		List<Contact> contacts = new ArrayList<>();
		String requete = "SELECT * FROM carnetscontacts.contacts";
		Connection connection = ConnectionDatabase.getConnectionDatabase().getConnection();
		Statement stmt = null;
		try {
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(requete);
			while (rs.next()) {
				contacts.add(new Contact(rs.getString("prenom"), rs.getString("nom"), rs.getString("numero")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return contacts;
	}

	@Override
	public int getId(Contact contact) {
		// Initialisation de l'Id à -1 :
		int contactId = -1;
		Connection connection = ConnectionDatabase.getConnectionDatabase().getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = connection.prepareStatement("SELECT contact_id FROM contacts WHERE (nom = ? AND prenom = ? AND numero = ?);");
			pstmt.setString(1, contact.getNom());
			pstmt.setString(2, contact.getPrenom());
			pstmt.setString(3, contact.getNumero());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				contactId = rs.getInt("contact_id");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return contactId;
	}

}
