package fr.biologeek.narwhal.business.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import fr.biologeek.narwhal.business.entities.Operation;
import fr.biologeek.narwhal.business.exceptions.ServiceException;
import fr.biologeek.narwhal.exceptions.DAOCreateException;
import fr.biologeek.narwhal.exceptions.DAODeleteException;
import fr.biologeek.narwhal.exceptions.DAOReadException;

@Service
public class OperationService  implements CoreGenericCRUD<Operation> {

	@Autowired
	@Qualifier("genericDAOImpl")
	private GenericDAO<Operation> dao;

	public OperationService() {
		super();
	}
	public GenericDAO<Operation> getDao() {
		return dao;
	}
	public void setDao(GenericDAO<Operation> dao) {
		this.dao = dao;
	}
	@Override
	public List<Operation> readAll() throws ServiceException {
		try {
			return this.dao.readAll();
		} catch (DAOReadException e) {
			throw new ServiceException();
		}
	}

	@Override
	public void add(Operation op) throws ServiceException {
		
		try {
			this.dao.create(op);
		} catch (DAOCreateException e) {
			e.printStackTrace();
			throw new ServiceException ();
		}
		
	}

	@Override
	public void update(Operation op) {
		this.dao.update(op);
	}

	@Override
	public void delete(Operation op) throws ServiceException {
		try {
			this.dao.delete(op);
		} catch (DAODeleteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServiceException ();
		}
	}

	@Override
	public Operation read(int id) throws ServiceException {
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
	public List<Operation> readDateToDate(Date begin, Date end)
			throws ServiceException {
		try {
			return this.dao.readDateToDate(begin, end);
		} catch (DAOReadException e) {
			throw new ServiceException();
		}
	}

}
