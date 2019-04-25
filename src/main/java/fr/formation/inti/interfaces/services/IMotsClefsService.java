package fr.formation.inti.interfaces.services;

import java.util.List;

import fr.formation.inti.entities.MotsClefs;

public interface IMotsClefsService {
	
	MotsClefs findByIdMotsClefs(int Id);
	
	void createMotsClefs(MotsClefs motsclefs);
	
	void deleteMotsClefs(MotsClefs motsclefs);
	
	void updateMotsClefs(MotsClefs motsclefs);
	
	List<MotsClefs> getAllMotsClefs();
	
	public MotsClefs findByMotClef(String motClef);
}
