package fr.formation.inti.interfaces.services;

import java.util.List;

import fr.formation.inti.entities.Moderateurs;

public interface IModerateursService {

	Moderateurs findByIdModerateurs(int Id);
	
	void createModerateurs(Moderateurs moderateurs);
	
	void updateModerateurs(Moderateurs moderateurs);
	
	void deleteModerateurs(Moderateurs moderateurs);
	
	List<Moderateurs> getAllModerateurs();
	
	
	
}
