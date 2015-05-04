package fr.biologeek.narwhal.business.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;
import org.springframework.stereotype.Component;


@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="discriminator", discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue(value="operation")
@Component
public abstract class Operation implements Serializable{

	//Every operation is referenced by a unique id
	@Id@GeneratedValue
	protected int operationId;
	//Either a buying (true) or a selling (false)
	private boolean isABuying;
	//Date of the operation
	private Date date;
	//Label of operation
	private String label;
	// The parent account of the operation 
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="compteId")
	private Compte compte;
	//Main category
	private Category category;
	// Sub category
	private SubCategory subCategory;
	
	
	public Operation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getOperationId() {
		return operationId;
	}

	public void setOperationId(int operationId) {
		this.operationId = operationId;
	}

	public boolean getIsABuying() {
		return isABuying;
	}


	public void setABuying(boolean isABuying) {
		this.isABuying = isABuying;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}

	public Compte getCompte() {
		return compte;
	}


	public void setCompte(Compte compte) {
		this.compte = compte;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public SubCategory getSubCategory() {
		return subCategory;
	}


	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}
}
