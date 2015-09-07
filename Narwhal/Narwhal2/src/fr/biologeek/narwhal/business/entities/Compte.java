package fr.biologeek.narwhal.business.entities;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

@Component
@Entity
@ManagedBean
public class Compte {
	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long compte_id;
	private Date compte_date;
	private String compte_label;
	private String compte_description;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="utilisateur_id")
	private Utilisateur compte_utilisateur;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="operation_id")
	private List<Operation> compte_operations;


	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}


	public long getCompte_id() {
		return compte_id;
	}


	public void setCompte_id(long compte_id) {
		this.compte_id = compte_id;
	}


	public Date getCompte_date() {
		return compte_date;
	}


	public void setCompte_date(Date compte_date) {
		this.compte_date = compte_date;
	}


	public String getCompte_label() {
		return compte_label;
	}


	public void setCompte_label(String compte_label) {
		this.compte_label = compte_label;
	}


	public String getCompte_description() {
		return compte_description;
	}


	public void setCompte_description(String compte_description) {
		this.compte_description = compte_description;
	}


	public Utilisateur getCompte_utilisateur() {
		return compte_utilisateur;
	}


	public void setCompte_utilisateur(Utilisateur compte_utilisateur) {
		this.compte_utilisateur = compte_utilisateur;
	}


	public List<Operation> getCompte_operations() {
		return compte_operations;
	}


	public void setCompte_operations(List<Operation> compte_operations) {
		this.compte_operations = compte_operations;
	}

}