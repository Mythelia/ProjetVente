package fr.formation.inti.interfaces.dao;

import java.util.List;

import fr.formation.inti.entities.Utilisateurs;

public interface IUtilisateursDao {
	
	Utilisateurs findById(Integer Id);
	
	Utilisateurs findByLogin(String login);
	
	Utilisateurs create(Utilisateurs utilisateurs);
	
	void delete(Utilisateurs utilisateurs);
	
	void update(Utilisateurs utilisateurs);
	
	List<Utilisateurs> getAll();
	
	
	
	
	

}
