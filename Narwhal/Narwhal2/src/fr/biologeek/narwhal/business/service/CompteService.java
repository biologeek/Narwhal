package fr.biologeek.narwhal.business.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import fr.biologeek.narwhal.business.entities.Compte;
import fr.biologeek.narwhal.business.entities.Utilisateur;
import fr.biologeek.narwhal.business.exceptions.ServiceException;

@Component
public class CompteService implements CoreGenericCRUD<Compte>, ISpecificCompteService{

	
	@Autowired
	ISpecificCompteDAO specDAO;
	
	
	@Override
	public List<Compte> getComptesByUtilisateur(Utilisateur user) {
		
		return specDAO.getComptesByUtilisateur(user);
	}

	@Override
	public void add(Compte op) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Compte op) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Compte op) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Compte read(int id) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Compte> readAll() throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}
