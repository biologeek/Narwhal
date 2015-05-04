package fr.biologeek.narwhal.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import fr.biologeek.narwhal.business.entities.Utilisateur;
import fr.biologeek.narwhal.business.service.ISpecificUtilisateur;

@Repository(value="utilisateurDAOImpl")
@Transactional
public class UtilisateurDAOImpl extends GenericDAOImpl<Utilisateur> implements  ISpecificUtilisateur{

	@Override
	public Utilisateur checkConnection(Utilisateur utilisateur) {
		String query = "from Utilisateur where login='"+utilisateur.getLogin()+"' and password='"+utilisateur.getPassword()+"'";
		return (Utilisateur) sessionFactory.getCurrentSession().createQuery(query).uniqueResult();
	}

}
