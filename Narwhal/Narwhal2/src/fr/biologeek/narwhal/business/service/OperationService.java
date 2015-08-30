package fr.biologeek.narwhal.business.service;

import java.util.Date;
import java.util.List;

import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import fr.biologeek.narwhal.business.entities.Compte;
import fr.biologeek.narwhal.business.entities.FinancialOperation;
import fr.biologeek.narwhal.business.entities.Operation;
import fr.biologeek.narwhal.business.exceptions.ServiceException;
import fr.biologeek.narwhal.exceptions.DAOCreateException;
import fr.biologeek.narwhal.exceptions.DAODeleteException;
import fr.biologeek.narwhal.exceptions.DAOReadException;

@Service
@SessionScoped
public class OperationService  implements CoreGenericCRUD<FinancialOperation>, ISpecificOperationService{

	@Autowired
	@Qualifier(value="operationDAOImpl")
	private GenericDAO<FinancialOperation> dao;
	@Autowired
	private ISpecificOperationDAO opDAO;

	public OperationService() {
		super();
	}
	public GenericDAO<FinancialOperation> getDao() {
		return dao;
	}
	public void setDao(GenericDAO<FinancialOperation> dao) {
		this.dao = dao;
	}
	@Override
	public List<FinancialOperation> readAll() throws ServiceException {
		try {
			return this.dao.readAll();
		} catch (DAOReadException e) {
			throw new ServiceException();
		}
	}

	@Override
	public void add(FinancialOperation op) throws ServiceException {
		
		try {
			this.dao.create(op);
		} catch (DAOCreateException e) {
			e.printStackTrace();
			throw new ServiceException ();
		}
		
	}

	@Override
	public void update(FinancialOperation op) {
		this.dao.update(op);
	}

	@Override
	public void delete(FinancialOperation op) throws ServiceException {
		try {
			this.dao.delete(op);
		} catch (DAODeleteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServiceException ();
		}
	}

	@Override
	public FinancialOperation read(int id) throws ServiceException {
		// TODO Auto-generated method stub
		try {
			return this.dao.read(id);
		} catch (DAOReadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServiceException ();
		}
	}
	@Override
	public List<FinancialOperation> readDateToDate(Date begin, Date end)
			throws ServiceException {
		try {
			return this.opDAO.readDateToDate(begin, end);
		} catch (DAOReadException e) {
			throw new ServiceException();
		}
	}
	@Override
	public List<FinancialOperation> readByCompte(Compte compte)
			throws ServiceException {
		try {
			return this.opDAO.readByCompte(compte);
		} catch (DAOReadException e) {
			throw new ServiceException();
		}
	}
}
