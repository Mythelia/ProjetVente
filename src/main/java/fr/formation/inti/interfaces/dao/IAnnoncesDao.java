package fr.formation.inti.interfaces.dao;

import java.util.List;

import fr.formation.inti.entities.Annonces;

public interface IAnnoncesDao {

	Annonces findById(int Id);

	void create(Annonces annonces);

	void delete(Annonces annonces);

	List<Annonces> getAll();

	void update(Annonces annonces);


}
