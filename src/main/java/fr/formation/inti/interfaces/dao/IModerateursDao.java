package fr.formation.inti.interfaces.dao;

import java.util.List;

import fr.formation.inti.entities.Moderateurs;

public interface IModerateursDao {

	Moderateurs findById(int Id);
	
	void create(Moderateurs moderateurs);
	
	void update(Moderateurs moderateurs);
	
	void delete(Moderateurs moderateurs);
	
	List<Moderateurs> getAll();
	
	
	
}
