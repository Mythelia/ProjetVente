package fr.formation.inti.interfaces.services;

import java.util.List;

import fr.formation.inti.Entities.Alerte;

public interface IAlertesService {

	Alerte findByIdAlerte(int Id);
	
	void createAlerte(Alerte alrt);
	
	void deleteAlerte(Alerte alrt);
	
	List<Alerte> getAllAlerte();
	
	void updateAlerte(Alerte alrt);
	
	
	
}
