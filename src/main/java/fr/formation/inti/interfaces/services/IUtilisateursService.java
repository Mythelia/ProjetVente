package fr.formation.inti.interfaces.services;

import java.util.List;

import fr.formation.inti.entities.Utilisateurs;

public interface IUtilisateursService {
	
	Utilisateurs findByIdUtilisateurs(int Id);
	
	Utilisateurs findByLoginUtilisateurs(String login);
	
	Utilisateurs createUtilisateurs(Utilisateurs utilisateurs);
	
	void deleteUtilisateurs(Utilisateurs utilisateurs);
	
	void updateUtilisateurs(Utilisateurs utilisateurs);
	
	List<Utilisateurs> getAllUtilisateurs();
	
	
	
	
	

}
