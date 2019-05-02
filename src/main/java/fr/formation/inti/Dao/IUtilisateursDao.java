package fr.formation.inti.Dao;

import java.util.List;

import fr.formation.inti.entities.Utilisateurs;

public interface IUtilisateursDao {
	
	Utilisateurs findById(Integer Id);
	
	void create(Utilisateurs utilisateurs);
	
	void delete(Utilisateurs utilisateurs);
	
	void update(Utilisateurs utilisateurs);
	
	List<Utilisateurs> getAll();
	
	
	
	
	

}
