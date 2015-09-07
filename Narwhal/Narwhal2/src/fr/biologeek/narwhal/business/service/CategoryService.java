package fr.biologeek.narwhal.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import fr.biologeek.narwhal.business.entities.Category;
import fr.biologeek.narwhal.business.exceptions.ServiceException;
import fr.biologeek.narwhal.exceptions.DAOCreateException;
import fr.biologeek.narwhal.exceptions.DAODeleteException;
import fr.biologeek.narwhal.exceptions.DAOReadException;

@Service(value="categoryService")
public class CategoryService  implements CoreGenericCRUD<Category>, ISpecificCategoryService {

	@Autowired
	@Qualifier(value="categoryDAOImpl")
	private GenericDAO<Category> dao;
	@Autowired
	private ISpecificCategoryDAO specDAO;
	
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

	@Override
	public List<Category> getCategories() {
		// TODO Auto-generated method stub
		return specDAO.getCategories();
	}

	@Override
	public List<Category> getSubCategories(Category parent) {
		// TODO Auto-generated method stub
		return specDAO.getSubCategories(parent);
	}

	@Override
	public List<Category> getSubCategories(Integer parent) {
		// TODO Auto-generated method stub
		return specDAO.getSubCategories(parent);
	}
}