package fr.formation.inti.interfaces.dao;

import java.util.List;

import fr.formation.inti.entities.Alertes;

public interface IAlertesDao{

	Alertes findById(int Id);

	void create(Alertes alrt);
	
	void delete(Alertes alrt);
	
	List<Alertes> getAll();
	
	void update(Alertes alrt);
	
	
	
}
