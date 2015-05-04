package fr.biologeek.narwhal.business.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import fr.biologeek.narwhal.business.exceptions.ServiceException;
import fr.biologeek.narwhal.exceptions.DAOCreateException;
import fr.biologeek.narwhal.exceptions.DAODeleteException;
import fr.biologeek.narwhal.exceptions.DAOReadException;

public class GenericServiceImpl<T> implements CoreGenericCRUD<T> {

	@Autowired
	@Qualifier("genericDAOImpl")
	protected GenericDAO<T> dao;
	
	
	@Override
	public void add(T op) throws ServiceException {
		try {
			dao.create(op);
		} catch (DAOCreateException e) {
			throw new ServiceException();
		}
		
	}

	@Override
	public void update(T op) throws ServiceException {
		dao.update(op);
	}

	@Override
	public void delete(T op) throws ServiceException {
		try {
			dao.delete(op);
		} catch (DAODeleteException e) {
			throw new ServiceException();
		}
	}

	@Override
	public T read(int id) throws ServiceException {
		try {
			return dao.read(id);
		} catch (DAOReadException e) {
			throw new ServiceException();
		}
	}

	@Override
	public List<T> readAll() throws ServiceException {
		try {
			return dao.readAll();
		} catch (DAOReadException e) {
			throw new ServiceException();
		}
	}

	@Override
	public List<T> readDateToDate(Date begin, Date end) throws ServiceException {
		try {
			return dao.readDateToDate(begin, end);
		} catch (DAOReadException e) {
			throw new ServiceException();
		}
	}

}
