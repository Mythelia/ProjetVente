package fr.formation.inti.interfaces.services;

import java.util.List;

import fr.formation.inti.entities.Alertes;

public interface IAlertesService {

	Alertes findByIdAlertes(int Id);
	
	void createAlertes(Alertes alrt);
	
	void deleteAlertes(Alertes alrt);
	
	List<Alertes> getAllAlertes();
	
	void updateAlertes(Alertes alrt);
	
	
	
}
