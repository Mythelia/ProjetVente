package fr.formation.inti.interfaces.dao;

import java.util.List;

import fr.formation.inti.Entities.Motsclefs;


public interface IMotsClefsDao {
	
	Motsclefs findById(int Id);
	
	void create(Motsclefs motsclefs);
	
	void delete(Motsclefs motsclefs);
	
	void update(Motsclefs motsclefs);
	
	List<Motsclefs> getAll();
	
	public Motsclefs findByMotClef(String motClef);
}
