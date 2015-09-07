package fr.biologeek.narwhal.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.biologeek.narwhal.business.entities.Compte;
import fr.biologeek.narwhal.business.entities.FinancialOperation;
import fr.biologeek.narwhal.business.entities.Operation;
import fr.biologeek.narwhal.business.service.GenericDAO;
import fr.biologeek.narwhal.business.service.ISpecificOperationDAO;
import fr.biologeek.narwhal.exceptions.DAOCreateException;
import fr.biologeek.narwhal.exceptions.DAODeleteException;
import fr.biologeek.narwhal.exceptions.DAOReadException;

@Repository
@Transactional
public class OperationDAOImpl implements GenericDAO<FinancialOperation>, ISpecificOperationDAO{

	public OperationDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void create(FinancialOperation arg0) throws DAOCreateException {
		sessionFactory.getCurrentSession().save(arg0);
		
	}

	@Override
	public FinancialOperation read(int id) throws DAOReadException {
		return (FinancialOperation) sessionFactory.getCurrentSession().get(Operation.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FinancialOperation> readAll() throws DAOReadException {
		// TODO Auto-generated method stub
		return (List<FinancialOperation>) sessionFactory.getCurrentSession().createQuery("from Operation");
	}

	@Override
	public void update(FinancialOperation arg0) {
		sessionFactory.getCurrentSession().update(arg0);
	}

	@Override
	public void delete(FinancialOperation arg0) throws DAODeleteException {
		sessionFactory.getCurrentSession().delete(arg0);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FinancialOperation> readDateToDate(Date begin, Date end)
			throws DAOReadException {
		
		List<FinancialOperation> obj = new ArrayList<FinancialOperation>();
		Session s = sessionFactory.getCurrentSession();
		
		obj =  (List<FinancialOperation>) s.createQuery("from Operation where operation_date <= '"+(new java.sql.Date(end.getTime()))+"' and operation_date >= '"+(new java.sql.Date(begin.getTime()))+"'").list();
		System.out.println("TTTTTTT : "+obj);

		return obj;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<FinancialOperation> readByCompte(Compte compte) throws DAOReadException {
		return (List<FinancialOperation>) sessionFactory.getCurrentSession().createQuery("from Operation where operation_compte = "+compte);

	}

}
