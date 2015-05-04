package fr.biologeek.narwhal.presentation.jsf.beans;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import fr.biologeek.narwhal.business.entities.Utilisateur;
import fr.biologeek.narwhal.business.service.ISpecificUtilisateur;

@ManagedBean
@Scope
@Controller
public class Accueil {

	@Autowired
	private Utilisateur utilisateur;
	@Autowired
	private ISpecificUtilisateur specService;

	public Accueil() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	/**
	 * Checks user connection when visitor entered login and password
	 * @param utilisateur
	 * @return null if user doesn't exist in database, else returns the Utilisateur object 
	 */
	public String checkConnection() {
		System.out.println(utilisateur.getLogin());
		if (specService.checkConnection(utilisateur) != null) {
			return "operations_list";
		} else {
			
			FacesContext ctx = FacesContext.getCurrentInstance();
			
			ctx.addMessage("incorrect", new FacesMessage("Le login ou le mot de passe est incorrect !"));
			return "index";
		}
	}

	public ISpecificUtilisateur getSpecService() {
		return specService;
	}

	public void setSpecService(ISpecificUtilisateur specService) {
		this.specService = specService;
	}

}
