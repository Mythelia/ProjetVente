package fr.formation.inti.Dao;

import java.util.List;

import fr.formation.inti.entities.Messages;
import fr.formation.inti.entities.Utilisateurs;

public interface IMessagesDao {

	Messages findById(int Id);

	void create(Messages messages);

	void delete(Messages messages);

	List<Messages> getAll();

	void update(Messages messages);

	List<Messages> getMessagesByUtilisateur(Utilisateurs utlisateur);

}
