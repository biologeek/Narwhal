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
	private int utilisateurId;
	private String login;
	private String password;
	@OneToMany(mappedBy="utilisateur", fetch=FetchType.LAZY)
	private List<Compte> comptes;
	
	
	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
	public int getId() {
		return utilisateurId;
	}
	public void setId(int id) {
		this.utilisateurId = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Compte> getComptes() {
		return comptes;
	}
	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}
	@Override
	public String toString() {
		return "Utilisateur [utilisateurId=" + utilisateurId + ", login="
				+ login + ", password=" + password + ", comptes=" + comptes
				+ "]";
	}
}
