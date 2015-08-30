package fr.biologeek.narwhal.presentation.jsf.beans;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import fr.biologeek.narwhal.business.entities.FinancialOperation;
import fr.biologeek.narwhal.business.entities.Operation;
import fr.biologeek.narwhal.business.entities.Utilisateur;
import fr.biologeek.narwhal.business.exceptions.ServiceException;
import fr.biologeek.narwhal.business.service.CoreGenericCRUD;
import fr.biologeek.narwhal.business.service.ISpecificOperationService;
import fr.biologeek.narwhal.business.service.OperationService;

@Controller
@ManagedBean(name="operationBean")
@SessionScoped
@Scope(value="session")
@Named()
public class OperationBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7796172485569803366L;
	
	private FinancialOperation operation = new FinancialOperation();
	private List<FinancialOperation> operations = new ArrayList<FinancialOperation>();
	
	
	
	private Utilisateur utilisateur;
	
	@Autowired
	private CoreGenericCRUD<FinancialOperation> opService;
	@Autowired
	private ISpecificOperationService specOpService;
	@Autowired
	private CoreGenericCRUD<Utilisateur> utService;
	
	
	Calendar cal = Calendar.getInstance();
	Calendar cal2 = Calendar.getInstance();
	private Date begin;
	private Date end;
	
	public OperationBean() {
		super();
		cal.set(Calendar.DAY_OF_MONTH, 1);
		begin = cal.getTime();
		cal2.set(Calendar.DAY_OF_MONTH, 30);
		end = cal2.getTime();
		
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
	
	public List<FinancialOperation> getOperationsFromDateToDate (){
		try {
			utilisateur = utService.read(1);
			System.out.println(begin+" BBBBBBBBBBBBBB ");
			System.out.println(end+" BBBBBBBBBBBBBB ");
			System.out.println(utilisateur+" CCCCCCCCCCCCCC ");

			operations = specOpService.readDateToDate(begin, end);
			System.out.println(begin+" BBBBBBBBBBBBBB "+operations);
			
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return operations;
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
