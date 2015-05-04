package fr.biologeek.narwhal.presentation.jsf.beans;

import java.util.Date;
import java.util.List;

import javax.annotation.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;

import fr.biologeek.narwhal.business.entities.FinancialOperation;
import fr.biologeek.narwhal.business.entities.Operation;
import fr.biologeek.narwhal.business.exceptions.ServiceException;
import fr.biologeek.narwhal.business.service.CoreGenericCRUD;
import fr.biologeek.narwhal.business.service.OperationService;

@Controller
@ManagedBean(value="operationBean")
public class OperationBean {

	private Operation operation = new FinancialOperation();
	private List<Operation> operations;
	@Autowired
	private CoreGenericCRUD<Operation> opService;
	
	private Date begin;
	private Date end;
	
	public OperationBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	public CoreGenericCRUD<Operation> getOpService() {
		return opService;
	}

	public void setOpService(CoreGenericCRUD<Operation> opService) {
		this.opService = opService;
	}

	public List<Operation> getOperations() {
		return operations;
	}
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

	public void setOpService(OperationService opService) {
		this.opService = opService;
	}
	
	public void getOperationsFromDateToDate (){
		try {
			this.operations = this.opService.readDateToDate(begin, end);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
