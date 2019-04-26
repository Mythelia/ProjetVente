package fr.formation.inti.interfaces.services;

import java.util.List;

import fr.formation.inti.entities.MotsClefs;

public interface IMotsClefsService {
	
	MotsClefs findByIdMotsClefs(int Id);
	
	void createMotsclefs(MotsClefs motsclefs);
	
	void deleteMotsclefs(MotsClefs motsclefs);
	
	void updateMotsclefs(MotsClefs motsclefs);
	
	List<MotsClefs> getAllMotsclefs();
	
	public MotsClefs findByMotclef(String motClef);
}
