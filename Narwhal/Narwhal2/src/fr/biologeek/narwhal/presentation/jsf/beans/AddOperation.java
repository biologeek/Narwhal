package fr.biologeek.narwhal.presentation.jsf.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import fr.biologeek.narwhal.business.entities.Category;
import fr.biologeek.narwhal.business.entities.Compte;
import fr.biologeek.narwhal.business.entities.FinancialOperation;
import fr.biologeek.narwhal.business.entities.Operation;
import fr.biologeek.narwhal.business.entities.Utilisateur;
import fr.biologeek.narwhal.business.service.CoreGenericCRUD;
import fr.biologeek.narwhal.business.service.ISpecificCategoryDAO;
import fr.biologeek.narwhal.business.service.ISpecificCategoryService;
import fr.biologeek.narwhal.business.service.ISpecificCompteDAO;

@ManagedBean(name="addOperation")
@Controller
@SessionScoped
public class AddOperation implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8408002112362464793L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	private FinancialOperation operation = new FinancialOperation();
	
	@Autowired
	private CoreGenericCRUD<FinancialOperation> opService;
	
	@Autowired
	private ISpecificCategoryService  catService;
	
	@Autowired
	private ISpecificCompteDAO cptService;

	@Autowired
	private Utilisateur user;
	private List<Compte> comptes;
	private List<Category> categories;
	
	
	private List<Category> subCategories;


	public AddOperation() {
		super();
	}
	public List<Compte> getAccoutsFromDB() {
		return cptService.getComptesByUtilisateur(user);
		
	}
	public List<Category> getCategories() {
		return categories;
	}
	public List<Category> getCategoriesFromDB() {
		
		System.out.println("AAAAAAAAAAAA"+catService.getCategories());
		return categories = catService.getCategories();
	}
	public ISpecificCategoryService getCatService() {
		return catService;
	}
	public List<Compte> getComptes() {
		return comptes;
	}

	
	public ISpecificCompteDAO getCptService() {
		return cptService;
	}
	public void setCptService(ISpecificCompteDAO cptService) {
		this.cptService = cptService;
	}
	public FinancialOperation getOperation() {
		return operation;
	}
	public CoreGenericCRUD<FinancialOperation> getOpService() {
		return opService;
	}
	
	public List<Category> getSubCategories() {
		return subCategories;
	}


	public List<Category> getSubCategoriesFromDB() {
		
		System.out.println("BBBBBBBBB"+catService.getSubCategories());
		return subCategories = catService.getSubCategories();
	}


	public Utilisateur getUser() {
		return user;
	}
	
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	public void setCatService(ISpecificCategoryService catService) {
		this.catService = catService;
	}
	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}


	public void setOperation(FinancialOperation operation) {
		this.operation = operation;
	}


	public void setOpService(CoreGenericCRUD<FinancialOperation> opService) {
		this.opService = opService;
	}


	public void setSubCategories(List<Category> subCategories) {
		this.subCategories = subCategories;
	}


	public void setUser(Utilisateur user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "AddOperation [operation=" + operation + ", opService="
				+ opService + ", comptes=" + comptes + ", categories="
				+ categories + ", subCategories=" + subCategories + "]";
	}
	
}
