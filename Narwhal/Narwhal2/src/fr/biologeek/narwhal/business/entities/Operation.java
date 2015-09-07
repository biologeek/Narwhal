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
	protected int operation_id;
	//Either a buying (true) or a selling (false)
	protected boolean operation_isABuying;
	//Date of the operation
	protected Date operation_date;
	//Label of operation
	protected String operation_label;
	
	protected double operation_amount;
	
	// The parent account of the operation 
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="compte_id")
	protected Compte operation_compte;

	@ManyToOne (fetch=FetchType.LAZY)
	
	protected Category operation_category;
	
	// Sub category
	@ManyToOne (fetch=FetchType.LAZY)
	@JoinColumn(name="category_id")
	protected Category operation_subCategory;
	
	
	public Operation() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Operation [operation_id=" + operation_id
				+ ", operation_isABuying=" + operation_isABuying
				+ ", operation_date=" + operation_date + ", operation_label="
				+ operation_label + ", operation_amount=" + operation_amount
				+ ", operation_compte=" + operation_compte
				+ ", operation_category=" + operation_category
				+ ", operation_subCategory=" + operation_subCategory + "]";
	}


	public int getOperation_id() {
		return operation_id;
	}


	public void setOperation_id(int operation_id) {
		this.operation_id = operation_id;
	}


	public boolean isOperation_isABuying() {
		return operation_isABuying;
	}


	public void setOperation_isABuying(boolean operation_isABuying) {
		this.operation_isABuying = operation_isABuying;
	}


	public Date getOperation_date() {
		return operation_date;
	}


	public void setOperation_date(Date operation_date) {
		this.operation_date = operation_date;
	}


	public String getOperation_label() {
		return operation_label;
	}


	public void setOperation_label(String operation_label) {
		this.operation_label = operation_label;
	}


	public double getOperation_amount() {
		return operation_amount;
	}


	public void setOperation_amount(double operation_amount) {
		this.operation_amount = operation_amount;
	}


	public Compte getOperation_compte() {
		return operation_compte;
	}


	public void setOperation_compte(Compte operation_compte) {
		this.operation_compte = operation_compte;
	}


	public Category getOperation_category() {
		return operation_category;
	}


	public void setOperation_category(Category operation_category) {
		this.operation_category = operation_category;
	}


	public Category getOperation_subCategory() {
		return operation_subCategory;
	}


	public void setOperation_subCategory(Category operation_subCategory) {
		this.operation_subCategory = operation_subCategory;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
