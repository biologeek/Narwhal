package fr.biologeek.narwhal.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.biologeek.narwhal.business.entities.Utilisateur;
import fr.biologeek.narwhal.business.service.GenericDAO;
import fr.biologeek.narwhal.business.service.ISpecificUtilisateurDAO;
import fr.biologeek.narwhal.exceptions.DAOCreateException;
import fr.biologeek.narwhal.exceptions.DAODeleteException;
import fr.biologeek.narwhal.exceptions.DAOReadException;

@Repository(value="utilisateurDAOImpl")
@Transactional
public class UtilisateurDAOImpl implements  ISpecificUtilisateurDAO, GenericDAO<Utilisateur>, Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -7318761560833892324L;
	@Autowired
	private SessionFactory sessionFactory;

	
	public UtilisateurDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public Utilisateur checkConnection(Utilisateur utilisateur) {
		String query = "from Utilisateur where utilisateur_login='"+utilisateur.getUtilisateur_login()+"' and utilisateur_password='"+utilisateur.getUtilisateur_password()+"'";
		return (Utilisateur) sessionFactory.getCurrentSession().createQuery(query).uniqueResult();
	}

	@Override
	public void create(Utilisateur arg0) throws DAOCreateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Utilisateur read(int id) throws DAOReadException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Utilisateur> readAll() throws DAOReadException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Utilisateur arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Utilisateur arg0) throws DAODeleteException {
		// TODO Auto-generated method stub
		
	}

}
