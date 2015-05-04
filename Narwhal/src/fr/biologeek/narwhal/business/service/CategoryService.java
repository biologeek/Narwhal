package fr.biologeek.narwhal.business.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import fr.biologeek.narwhal.business.entities.Category;
import fr.biologeek.narwhal.business.entities.Category;
import fr.biologeek.narwhal.business.exceptions.ServiceException;
import fr.biologeek.narwhal.business.exceptions.OperationServiceException;
import fr.biologeek.narwhal.exceptions.DAOCreateException;
import fr.biologeek.narwhal.exceptions.DAODeleteException;
import fr.biologeek.narwhal.exceptions.DAOReadException;

@Service
public class CategoryService  implements CoreGenericCRUD<Category> {

	@Autowired
	@Qualifier("genericDAOImpl")
	private GenericDAO<Category> dao;
	
	public CategoryService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoryService(GenericDAO<Category> dao) {
		this.dao = dao;
	}
	public List<Category> readAll() throws ServiceException {
		try {
			return this.dao.readAll();
		} catch (DAOReadException e) {
			throw new ServiceException();
		}
	}

	@Override
	public void add(Category op) throws ServiceException {
		
		try {
			this.dao.create(op);
		} catch (DAOCreateException e) {
			e.printStackTrace();
			throw new ServiceException ();
		}
		
	}

	@Override
	public void update(Category op) {
		this.dao.update(op);
	}

	@Override
	public void delete(Category op) throws ServiceException {
		try {
			this.dao.delete(op);
		} catch (DAODeleteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServiceException ();
		}
	}

	@Override
	public Category read(int id) throws ServiceException {
		// TODO Auto-generated method stub
		try {
			return this.dao.read(id);
		} catch (DAOReadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServiceException ();
		}
	}
	public List<Category> readDateToDate(Date begin, Date end)
			throws ServiceException {
		try {
			return this.dao.readDateToDate(begin, end);
		} catch (DAOReadException e) {
			throw new ServiceException();
		}
	}
}