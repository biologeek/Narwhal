package fr.biologeek.narwhal.presentation.jsf.beans;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.biologeek.narwhal.business.entities.Category;
import fr.biologeek.narwhal.business.entities.Compte;
import fr.biologeek.narwhal.business.entities.FinancialOperation;
import fr.biologeek.narwhal.business.entities.Operation;
import fr.biologeek.narwhal.business.entities.Utilisateur;
import fr.biologeek.narwhal.business.exceptions.ServiceException;
import fr.biologeek.narwhal.business.service.CoreGenericCRUD;
import fr.biologeek.narwhal.business.service.ISpecificCategoryService;
import fr.biologeek.narwhal.business.service.ISpecificCompteService;
import fr.biologeek.narwhal.business.service.ISpecificOperationService;
import fr.biologeek.narwhal.business.service.OperationService;

@Controller
@ManagedBean(name="operationBean")
public class OperationBean implements Serializable {

	/**
	 * OperationBean manages operations-related actions :
	 * - Inserting a new operation
	 * - listing all operations
	 * - updating an operation
	 * 
	 * **************************************************************************************
	 * 		Version		|		Author		|			Comment								*
	 * -------------------------------------------------------------------------------------*
	 * 		1.0			|		Biologeek	| Init : Bean handles operation					*
	 * 					|					| listing, creation, modification and deleting	*
	 * -------------------------------------------------------------------------------------*
	 * **************************************************************************************
	 * 
	 */
	private static final long serialVersionUID = -7796172485569803366L;
	
	private FinancialOperation operation = new FinancialOperation();
	private Operation operationToAdd = new FinancialOperation();

	private List<FinancialOperation> operations = new ArrayList<FinancialOperation>();
	
	@Autowired
	private ISpecificCompteService cptService;
	
	@Autowired
	private Utilisateur utilisateur;
	@Autowired
	private ISpecificCategoryService catService;
	@Autowired
	private ISpecificCategoryService subCategories;
	
	@Autowired
	private List<Category> categories;
	
	
	@Autowired
	private CoreGenericCRUD<FinancialOperation> opService;
	@Autowired
	private ISpecificOperationService specOpService;
	@Autowired
	private CoreGenericCRUD<Utilisateur> utService;
	
	private Date today = Calendar.getInstance().getTime();
	
	Calendar cal = Calendar.getInstance();
	Calendar cal2 = Calendar.getInstance();
	private Date begin;

	private Date end;

	private Category parent;

	
	

	public OperationBean() {
		
		/*
		 * Initializes OperationBean by setting default Calendar beginning at 1st day of month
		 * and end at 30th day
		 */
		super();
		cal.set(Calendar.DAY_OF_MONTH, 1);
		begin = cal.getTime();
		cal2.set(Calendar.DAY_OF_MONTH, 30);
		end = cal2.getTime();
		
	}
	
	
	public List<FinancialOperation> getOperationsFromDateToDate (){
		
		/*
		 * Returns operations from beginning to end.
		 * By default, beginning  = 1st
		 * end = 30th
		 */
		try {
			
			// Default user ID set to 1.
			// TO BE CHANGED WHEN HTTP SESSION will be implemented
			utilisateur = utService.read(SessionUtils.defaultUserId);

			operations = specOpService.readDateToDate(begin, end);
			
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return operations;
	}
	
	
	public String addOrUpdateOperation (){
		
		/*
		 * addOrUpdateOperation adds or updates an operation (related to operation.xhtml)
		 * 
		 */
		
		System.out.println("addOrUpdateOperation");
		if (operationToAdd.getOperation_id() != 0) {
			try {
				
				opService.update((FinancialOperation) operationToAdd);
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		}
		else {
			try {
				opService.add((FinancialOperation) operationToAdd);
			}
			catch (ServiceException e){
				e.printStackTrace();
			}
		}
		return "operations_list";
	}
	
	public List<Compte> getAccoutsFromDB() {
		return cptService.getComptesByUtilisateur(utilisateur);
		
	}
		
	public List<Category> getCategoriesFromDB() {
		System.out.println("getCategoriesFromDB");
		return categories = catService.getCategories();
	}
	
	public List<Category> getSubCategoriesFromDB() {
		
		return catService.getSubCategories(parent);
	}
	
	public void setOperationToAdd(Operation operationToAdd) {
		this.operationToAdd = operationToAdd;
	}
	
	public ISpecificCompteService getCptService() {
		return cptService;
	}


	public void setCptService(ISpecificCompteService cptService) {
		this.cptService = cptService;
	}


	public ISpecificCategoryService getCatService() {
		return catService;
	}


	public void setCatService(ISpecificCategoryService catService) {
		this.catService = catService;
	}


	public ISpecificCategoryService getSubCategories() {
		return subCategories;
	}


	public void setSubCategories(ISpecificCategoryService subCategories) {
		this.subCategories = subCategories;
	}


	public List<Category> getCategories() {
		return categories;
	}


	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}


	public Date getToday() {
		return today;
	}


	public void setToday(Date today) {
		this.today = today;
	}


	public FinancialOperation getOperationToAdd() {
		return (FinancialOperation) operationToAdd;
	}


	public void setOperationToAdd(FinancialOperation operationToAdd) {
		this.operationToAdd = operationToAdd;
	}
	
	public Operation getOperation() {
		return operation;
	}

	public void setOperation(FinancialOperation operation) {
		this.operation = operation;
	}

	public CoreGenericCRUD<FinancialOperation> getOpService() {
		return opService;
	}

	public void setOpService(CoreGenericCRUD<FinancialOperation> opService) {
		this.opService = opService;
	}

	public List<FinancialOperation> getOperations() {
		return operations;
	}
	public void setOperations(List<FinancialOperation> operations) {
		this.operations = operations;
	}

	public void setOpService(OperationService opService) {
		this.opService = opService;
	}
	
	
	
	
	public ISpecificOperationService getSpecOpService() {
		return specOpService;
	}

	public Calendar getCal() {
		return cal;
	}

	public void setCal(Calendar cal) {
		this.cal = cal;
	}

	public Calendar getCal2() {
		return cal2;
	}

	public void setCal2(Calendar cal2) {
		this.cal2 = cal2;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setSpecOpService(ISpecificOperationService specOpService) {
		this.specOpService = specOpService;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public CoreGenericCRUD<Utilisateur> getUtService() {
		return utService;
	}

	public void setUtService(CoreGenericCRUD<Utilisateur> utService) {
		this.utService = utService;
	}

	@Override
	public String toString() {
		return "OperationBean [operation=" + operation + ", operations="
				+ operations + ", utilisateur=" + utilisateur + ", opService="
				+ opService + ", specOpService=" + specOpService
				+ ", utService=" + utService + ", cal=" + cal + ", cal2="
				+ cal2 + ", begin=" + begin + ", end=" + end + "]";
	}

	public Date getBegin() {
		return begin;
	}
	public void setBegin(Date begin) {
		this.begin = begin;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	
	
	
	
}
