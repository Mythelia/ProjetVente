package fr.formation.inti.Services;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.inti.Dao.MessageriesDao;
import fr.formation.inti.entities.Messageries;
import fr.formation.inti.entities.Messages;
import fr.formation.inti.entities.Utilisateurs;
import fr.formation.inti.interfaces.dao.IMessageriesDao;
import fr.formation.inti.interfaces.services.IMessageriesService;

@Service
@Transactional
public class MessageriesService implements IMessageriesService {

	private static final Log log = LogFactory.getLog(MessageriesService.class);

	public MessageriesService() {
	}

	@Autowired
	private IMessageriesDao dao;

	public void setDao(IMessageriesDao dao) {
		this.dao = dao;
	}

	public void updateMessageries(Messageries messageries) {
		dao.update(messageries);
	}

	public void deleteMessageries(Messageries messageries) {
		dao.delete(messageries);
	}

	public List<Messageries> getAllMessageries() {
		return dao.getAll();
	}

	public void createMessageries(Messageries messageries) {
		dao.create(messageries);
	}

	public Messageries findByIdMessageries(int Id) {
		return dao.findById(Id);

	}

	public List<Messages> getMessagerieByUtilisateurId(int utiliId, Utilisateurs utilisateur) {
		return dao.getMessagerieByUtiliId(utiliId, utilisateur);

	}

}