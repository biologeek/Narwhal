package fr.biologeek.narwhal.business.service;

import java.util.Date;
import java.util.List;

import fr.biologeek.narwhal.business.exceptions.ServiceException;

public interface CoreGenericCRUD<T> {

	
	public void add (T op) throws ServiceException;
	public void update (T op) throws ServiceException;
	public void delete (T op) throws ServiceException;
	public T read(int id) throws ServiceException;
	public List<T> readAll () throws ServiceException;
	public List<T> readDateToDate (Date begin, Date end) throws ServiceException;
	
}
