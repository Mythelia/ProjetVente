package fr.formation.inti.interfaces.dao;

import java.util.List;

import fr.formation.inti.entities.Alerte;
import fr.formation.inti.entities.Utilisateurs;

public interface IAlerteDao {

	Alerte findById(int Id);

	void create(Alerte alrt);

	void delete(Alerte alrt);

	List<Alerte> getAll();

	void update(Alerte alrt);

	List<Alerte> getAlerteByUtilisateur(Utilisateurs utlisateur);

}
