package fr.biologeek.narwhal.business.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Compte {
	@Id@GeneratedValue
	private long compteId;
	private Date date;
	private String label;
	private String description;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="utilisateurId")
	private Utilisateur utilisateur;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="operationId")
	private List<Operation> operations;


	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public long getCompteId() {
		return compteId;
	}

	public void setCompteId(long id) {
		this.compteId = id;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
}
