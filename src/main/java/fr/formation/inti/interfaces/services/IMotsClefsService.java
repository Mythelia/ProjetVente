package fr.formation.inti.interfaces.services;

import java.util.List;

import fr.formation.inti.Entities.Motsclefs;

public interface IMotsClefsService {
	
	Motsclefs findByIdMotsClefs(int Id);
	
	void createMotsclefs(Motsclefs motsclefs);
	
	void deleteMotsclefs(Motsclefs motsclefs);
	
	void updateMotsclefs(Motsclefs motsclefs);
	
	List<Motsclefs> getAllMotsclefs();
	
	public Motsclefs findByMotclef(String motClef);
}
