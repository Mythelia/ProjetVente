package fr.formation.inti.Services;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.formation.inti.Dao.MessagesDao;
import fr.formation.inti.entities.Messages;
import fr.formation.inti.interfaces.dao.IMessagesDao;
import fr.formation.inti.interfaces.services.IMessagesService;

//@Service("service")
public class MessagesService implements IMessagesService {

	private static final Log log = LogFactory.getLog(MessagesService.class);

	public MessagesService() {
	}

	
	private IMessagesDao dao;

	public void setDao(IMessagesDao dao) {
		this.dao = dao;
	}

	public void updateMessages(Messages messages) {
		dao.update(messages);

	}

	public void deleteMessages(Messages messages) {
		dao.delete(messages);
	}

	public List<Messages> getAllMessages() {
		return dao.getAll();
	}

	public void createMessages(Messages messages) {
		dao.create(messages);
}

public Messages findByIdMessages(int Id) {
	return dao.findById(Id);
}

}