package fr.biologeek.narwhal.business.entities;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

@Entity
@Component
@ManagedBean
@Named
public class Utilisateur implements Serializable {

	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int utilisateur_id;
	private String utilisateur_login;
	private String utilisateur_password;
	
	@OneToMany(mappedBy="compte_utilisateur", fetch=FetchType.LAZY)
	private List<Compte> utilisateur_comptes;
	
	
	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getUtilisateur_id() {
		return utilisateur_id;
	}


	public void setUtilisateur_id(int utilisateur_id) {
		this.utilisateur_id = utilisateur_id;
	}


	public String getUtilisateur_login() {
		return utilisateur_login;
	}


	public void setUtilisateur_login(String utilisateur_login) {
		this.utilisateur_login = utilisateur_login;
	}


	public String getUtilisateur_password() {
		return utilisateur_password;
	}


	public void setUtilisateur_password(String utilisateur_password) {
		this.utilisateur_password = utilisateur_password;
	}


	public List<Compte> getUtilisateur_comptes() {
		return utilisateur_comptes;
	}


	public void setUtilisateur_comptes(List<Compte> utilisateur_comptes) {
		this.utilisateur_comptes = utilisateur_comptes;
	}	
}
