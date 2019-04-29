package fr.formation.inti.interfaces.dao;

import java.util.List;
import java.util.Set;

import fr.formation.inti.entities.Annonces;
import fr.formation.inti.entities.Utilisateurs;

public interface IAnnoncesDao {

	Annonces findById(int Id);

	void create(Annonces annonces);

	void delete(Annonces annonces);

	List<Annonces> getAll();

	void update(Annonces annonces);

	public Set<Annonces> getAnnoncesByMotClef(String motClef);

	public List<Annonces> getAnnoncesByUtilisateur(Utilisateurs utlisateur);
}
