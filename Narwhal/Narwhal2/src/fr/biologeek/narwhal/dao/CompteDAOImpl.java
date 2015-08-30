package fr.biologeek.narwhal.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.biologeek.narwhal.business.entities.Compte;
import fr.biologeek.narwhal.business.entities.Utilisateur;
import fr.biologeek.narwhal.business.service.ISpecificCompteDAO;

@Repository
public class CompteDAOImpl implements ISpecificCompteDAO {

	public CompteDAOImpl() {
		super();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Compte> getComptesByUtilisateur(Utilisateur user) {
		// TODO Auto-generated method stub 
		return (List<Compte>) sessionFactory.getCurrentSession().createQuery("from Compte c where c.utilisateurId = "+user.getId()+"").list();
	}

}
