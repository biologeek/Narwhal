package fr.biologeek.narwhal.business.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue(value="financialoperation")
public class FinancialOperation extends Operation implements Serializable{

	

	private double amount;
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
	
	
	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	

}
