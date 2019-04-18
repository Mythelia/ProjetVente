package fr.formation.inti.interfaces.dao;

import java.util.List;

import fr.formation.inti.entities.Messageries;

public interface IMessageriesDao {

	Messageries findById(int Id);

	void create(Messageries messageries);

	void delete(Messageries messageries);

	List<Messageries> getAll();

	void update(Messageries messageries);

}
