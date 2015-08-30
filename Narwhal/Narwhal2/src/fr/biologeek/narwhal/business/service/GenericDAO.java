package fr.biologeek.narwhal.business.service;

import java.util.Date;
import java.util.List;

import fr.biologeek.narwhal.business.entities.Operation;
import fr.biologeek.narwhal.exceptions.DAOCreateException;
import fr.biologeek.narwhal.exceptions.DAODeleteException;
import fr.biologeek.narwhal.exceptions.DAOReadException;

public interface GenericDAO<T> {

	
	public void create (T arg0) throws DAOCreateException;
	public T read (int id) throws DAOReadException;
	public List<T> readAll () throws DAOReadException;
	public void update(T arg0);
	public void delete (T arg0) throws DAODeleteException;
	
}
