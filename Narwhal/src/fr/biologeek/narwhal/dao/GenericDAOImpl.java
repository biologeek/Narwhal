package fr.biologeek.narwhal.dao;


import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.biologeek.narwhal.business.entities.Operation;
import fr.biologeek.narwhal.business.service.GenericDAO;
import fr.biologeek.narwhal.exceptions.DAOCreateException;
import fr.biologeek.narwhal.exceptions.DAODeleteException;
import fr.biologeek.narwhal.exceptions.DAOReadException;
import fr.biologeek.narwhal.exceptions.DAOUpdateException;

@Repository(value="genericDAOImpl")
@Transactional
public class GenericDAOImpl<T> implements GenericDAO<T>{
	
	private Class<T> clazz;
	@Autowired
	protected SessionFactory sessionFactory;

	public GenericDAOImpl(Class<T> clazz) {
		super();
		this.clazz = clazz;
	}

	public GenericDAOImpl() {
		super();
	}

	@Override 
	public void create(T arg0) throws DAOCreateException {
		Session s = sessionFactory.getCurrentSession();
		
		s.save(arg0);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public T read(int id) throws DAOReadException {
		
		T obj;
		Session s = sessionFactory.getCurrentSession();
		
		obj = (T) s.get(clazz, id);
		
		return obj;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> readAll() throws DAOReadException  {
		
		Session s = sessionFactory.getCurrentSession();
		
		
		return (List<T>) s.createQuery("from "+this.getClazz().getName()).list();
	}
	@Override
	public void update(T arg0) {
		
		Session s = sessionFactory.getCurrentSession();
		
		s.update(arg0);
			
	}
	@Override
	public void delete(T arg0) throws DAODeleteException  {
		
		Session s = sessionFactory.getCurrentSession();
		s.delete(arg0);
		
	}

	public Class<T> getClazz() {
		return clazz;
	}

	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> readDateToDate(Date begin, Date end)
			throws DAOReadException {
		
		List<T> obj;
		Session s = sessionFactory.getCurrentSession();
		
		obj =  (List<T>) s.createQuery("from "+this.getClazz().getName()+" "
				+ "where date <= "+end+" and date >= "+begin).list();
		
		return obj;
	}
}
