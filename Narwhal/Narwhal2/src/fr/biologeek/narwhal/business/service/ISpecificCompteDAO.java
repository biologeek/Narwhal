package fr.biologeek.narwhal.business.service;

import java.util.List;

import fr.biologeek.narwhal.business.entities.Compte;
import fr.biologeek.narwhal.business.entities.Utilisateur;

public interface ISpecificCompteDAO {
	
	public List<Compte> getComptesByUtilisateur (Utilisateur user);

}
