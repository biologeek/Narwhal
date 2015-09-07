package fr.biologeek.narwhal.business.entities;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.springframework.stereotype.Component;

@Entity
@DiscriminatorValue(value="financialoperation")
@ManagedBean
@Component
public class FinancialOperation extends Operation implements Serializable{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 7968945605084018869L;
	private boolean operation_imposable;
	
	
	public FinancialOperation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public boolean isOperation_imposable() {
		return operation_imposable;
	}
	public void setOperation_imposable(boolean operation_imposable) {
		this.operation_imposable = operation_imposable;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
