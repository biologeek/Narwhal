package fr.biologeek.narwhal.business.entities;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.springframework.stereotype.Component;


@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="discriminator", discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue(value="operation")
@Component
@ManagedBean
public class Operation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1806447681556092920L;
	//Every operation is referenced by a unique id
	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected int operationId;
	//Either a buying (true) or a selling (false)
	protected boolean isABuying;
	//Date of the operation
	protected Date date;
	//Label of operation
	protected String label;
	
	protected double amount;
	
	// The parent account of the operation 
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="compteId")
	protected Compte compte;

	@ManyToOne (fetch=FetchType.LAZY)
	@JoinColumn(name="categoryId")
	protected Category category;
	
	// Sub category
	@ManyToOne (fetch=FetchType.LAZY)
	@JoinColumn(name="subCategoryId")
	protected Category subCategory;
	
	
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
	
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
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


	public Category getSubCategory() {
		return subCategory;
	}


	public void setSubCategory(Category subCategory) {
		this.subCategory = subCategory;
	}

	@Override
	public String toString() {
		return "Operation [operationId=" + operationId + ", isABuying="
				+ isABuying + ", date=" + date + ", label=" + label
				+ ", compte=" + compte + ", category=" + category
				+ ", subCategory=" + subCategory + "]";
	}
}
