package fr.formation.inti.interfaces.dao;

import java.util.List;

import fr.formation.inti.entities.Messageries;
import fr.formation.inti.entities.Messages;
import fr.formation.inti.entities.Utilisateurs;

public interface IMessageriesDao {

	Messageries findById(int Id);

	void create(Messageries messageries);

	void delete(Messageries messageries);

	List<Messageries> getAll();

	void update(Messageries messageries);

	List<Messages> getMessagerieByUtiliId(int utiliId, Utilisateurs utilisateur);

}
