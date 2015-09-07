package fr.biologeek.narwhal.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.biologeek.narwhal.business.entities.Category;
import fr.biologeek.narwhal.business.service.GenericDAO;
import fr.biologeek.narwhal.business.service.ISpecificCategoryDAO;
import fr.biologeek.narwhal.exceptions.DAOCreateException;
import fr.biologeek.narwhal.exceptions.DAODeleteException;
import fr.biologeek.narwhal.exceptions.DAOReadException;

@Repository (value="categoryDAOImpl")
@Transactional
public class CategoryDAOImpl implements GenericDAO<Category>, ISpecificCategoryDAO {

	
	public CategoryDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public void create(Category arg0) throws DAOCreateException {
		sessionFactory.getCurrentSession().save(arg0);	
	}

	@Override
	public Category read(int id) throws DAOReadException {
		return (Category) sessionFactory.getCurrentSession().get(Category.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> readAll() throws DAOReadException {
		return (List<Category>) sessionFactory.getCurrentSession().createQuery("from Category").list();
	}

	@Override
	public void update(Category arg0) {
		sessionFactory.getCurrentSession().update(arg0);
	}

	@Override
	public void delete(Category arg0) throws DAODeleteException {
		sessionFactory.getCurrentSession().delete(arg0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getCategories() {
		
		return (List<Category>) sessionFactory.getCurrentSession().createQuery("from Category as c where c.category_parent=NULL").list();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getSubCategories(Category parent) {
		// TODO Auto-generated method stub
		return (List<Category>) sessionFactory.getCurrentSession().createQuery("from Category as c where c.category_parent ="+parent).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getSubCategories(Integer parent) {
		// TODO Auto-generated method stub
		return (List<Category>) sessionFactory.getCurrentSession().createSQLQuery("select * from Category as c where c.category_parent ="+parent).list();
	}

}
