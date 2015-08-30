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
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue(value="financialoperation")
@ManagedBean
@Component
public class FinancialOperation extends Operation implements Serializable{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 7968945605084018869L;
	private boolean imposable;


	public boolean isImposable() {
		return imposable;
	}


	public void setImposable(boolean imposable) {
		this.imposable = imposable;
	}


	public FinancialOperation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public String toString() {
		return "FinancialOperation [operationId=" + operationId + ", isABuying="
				+ isABuying + ", date=" + date + ", label=" + label
				+ ", compte=" + compte + "amount=" + amount + ", imposable="
				+ imposable + ", category="+category+", subcategory="+subCategory+"]";
	}

}
