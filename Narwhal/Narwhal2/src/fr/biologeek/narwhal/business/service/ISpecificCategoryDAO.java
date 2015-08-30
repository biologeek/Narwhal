package fr.biologeek.narwhal.business.service;

import java.util.List;

import fr.biologeek.narwhal.business.entities.Category;

public interface ISpecificCategoryDAO {
	
	
	public List<Category> getCategories ();
	public List<Category> getSubCategories ();
}
