package fr.biologeek.narwhal.business.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import fr.biologeek.narwhal.business.entities.SubCategory;
import fr.biologeek.narwhal.business.exceptions.ServiceException;

@Service
public class SubCategoryService implements CoreGenericCRUD<SubCategory>{

	@Autowired
	@Qualifier("genericDAOImpl")
	private GenericDAO<SubCategory> dao;
	
	@Override
	public void add(SubCategory op) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(SubCategory op) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(SubCategory op) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SubCategory read(int id) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubCategory> readAll() throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubCategory> readDateToDate(Date begin, Date end)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
