package fr.biologeek.narwhal.business.service;

import org.springframework.beans.factory.annotation.Autowired;

import fr.biologeek.narwhal.business.entities.Utilisateur;

public class UtilisateurService extends GenericServiceImpl<Utilisateur> implements ISpecificUtilisateur{
	@Autowired
	ISpecificUtilisateurDAO specDAO;
	
	public UtilisateurService() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Utilisateur checkConnection(Utilisateur utilisateur) {
		return specDAO.checkConnection(utilisateur);
	}


}
