package fr.biologeek.narwhal.business.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import fr.biologeek.narwhal.business.entities.Utilisateur;
import fr.biologeek.narwhal.business.exceptions.ServiceException;
import fr.biologeek.narwhal.exceptions.DAOCreateException;
import fr.biologeek.narwhal.exceptions.DAODeleteException;
import fr.biologeek.narwhal.exceptions.DAOReadException;
@Service
public class UtilisateurService implements ISpecificUtilisateur,
		CoreGenericCRUD<Utilisateur>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8202410262083676948L;
	/**
	 * 
	 */
	@Autowired
	ISpecificUtilisateurDAO specDAO;
	@Autowired
	@Qualifier(value="utilisateurDAOImpl")
	GenericDAO<Utilisateur> dao;

	public UtilisateurService() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Utilisateur checkConnection(Utilisateur utilisateur) {
		return specDAO.checkConnection(utilisateur);
	}

	@Override
	public String toString() {
		return "UtilisateurService [specDAO=" + specDAO + "]";
	}

	@Override
	public void add(Utilisateur op) throws ServiceException {
		try {
			this.dao.create(op);
		} catch (DAOCreateException e) {
			// TODO Auto-generated catch block
			throw new ServiceException();
		}
	}

	@Override
	public void update(Utilisateur op) throws ServiceException {
		this.dao.update(op);
	}

	@Override
	public void delete(Utilisateur op) throws ServiceException {
		try {
			this.dao.delete(op);
			} catch (DAODeleteException e) {
			throw new ServiceException();
		}
	
	}

	@Override
	public Utilisateur read(int id) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Utilisateur> readAll() throws ServiceException {
		try {
			return this.dao.readAll();
		} catch (DAOReadException e) {
			throw new ServiceException();
		}
	}

	public ISpecificUtilisateurDAO getSpecDAO() {
		return specDAO;
	}

	public void setSpecDAO(ISpecificUtilisateurDAO specDAO) {
		this.specDAO = specDAO;
	}

	public GenericDAO<Utilisateur> getDao() {
		return dao;
	}

	public void setDao(GenericDAO<Utilisateur> dao) {
		this.dao = dao;
	}

}
