package fr.formation.inti.interfaces.services;

import java.util.List;

import fr.formation.inti.Entities.Messages;



public interface IMessagesService {
	
	Messages findByIdMessages(int Id);
	
	void createMessages(Messages messages);
	
	void deleteMessages(Messages messages);
	
	List<Messages> getAllMessages();
	
	void updateMessages(Messages messages);
	
	
	
}


