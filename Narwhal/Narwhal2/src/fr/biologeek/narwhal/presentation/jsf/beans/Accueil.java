package fr.biologeek.narwhal.presentation.jsf.beans;


import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import fr.biologeek.narwhal.business.entities.Utilisateur;
import fr.biologeek.narwhal.business.service.ISpecificUtilisateur;

@ManagedBean(name="accueil")
@Controller
@SessionScoped
@Scope(value="session")

public class Accueil implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8254720780388385076L;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
	
	@Autowired
	HttpSession session;

	@Autowired
	private ISpecificUtilisateur specService;

	private Utilisateur utilisateur = new Utilisateur();

	public Accueil() {
		super();
		
		if (session == null){
			this.session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		}
		
		System.out.println(this.session);
	}
	/**
	 * Checks user connection when visitor entered login and password
	 * @param utilisateur
	 * @return null if user doesn't exist in database, else returns the Utilisateur object 
	 */
	public String checkConnection() {
		System.out.println(utilisateur);
		System.out.println(specService);
		
		Utilisateur user = specService.checkConnection(utilisateur);
		
		if (user != null) {
			utilisateur = user;
			System.out.println(utilisateur);
		//session.setAttribute("utilisateur", utilisateur);
			return "operations_list";
		} else {
			
			FacesContext ctx = FacesContext.getCurrentInstance();
			
			ctx.addMessage("incorrect", new FacesMessage("Le login ou le mot de passe est incorrect !"));
			return "index2";
		}
	}
	
	// Current HTTP Session

	public HttpSession getSession() {
		return session;
	}

	public ISpecificUtilisateur getSpecService() {
		return specService;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setSession(HttpSession session) {
		this.session = session;
	}

	public void setSpecService(ISpecificUtilisateur specService) {
		this.specService = specService;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

}
