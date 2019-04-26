package fr.formation.inti.Dao;

import java.util.List;

import fr.formation.inti.Entities.Messages;



public interface IMessagesDao {

	Messages findById(int Id);
	
	void create(Messages messages);
	
	void delete(Messages messages);
	
	List<Messages> getAll();
	
	void update(Messages messages);
	
	
	
	
	
	
	
}
