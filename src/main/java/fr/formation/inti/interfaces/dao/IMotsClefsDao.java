package fr.formation.inti.interfaces.dao;

import java.util.List;

import fr.formation.inti.entities.MotsClefs;


public interface IMotsClefsDao {
	
	MotsClefs findById(int Id);
	
	void create(MotsClefs motsclefs);
	
	void delete(MotsClefs motsclefs);
	
	void update(MotsClefs motsclefs);
	
	List<MotsClefs> getAll();
	
	public MotsClefs findByMotClef(String motClef);
}
