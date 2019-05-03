package fr.formation.inti.Services;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.inti.entities.Alerte;
import fr.formation.inti.entities.Utilisateurs;
import fr.formation.inti.interfaces.dao.IAlerteDao;
import fr.formation.inti.interfaces.services.IAlertesService;

@Service
@Transactional
public class AlertesService implements IAlertesService {

	private static final Log log = LogFactory.getLog(AlertesService.class);

	public AlertesService() {
	}

	@Autowired
	private IAlerteDao dao;

	public void setDao(IAlerteDao dao) {
		this.dao = dao;

	}

	public void updateAlerte(Alerte alrt) {
		dao.update(alrt);

	}

	public void deleteAlerte(Alerte alrt) {
		dao.delete(alrt);

	}

	public List<Alerte> getAllAlerte() {
		return dao.getAll();
	}

	public void createAlerte(Alerte alrt) {
		dao.create(alrt);
	}

	public Alerte findByIdAlerte(int Id) {
		return dao.findById(Id);
	}

	public List<Alerte> getAlerteByUtilisateur(Utilisateurs utlisateur) {
		return dao.getAlerteByUtilisateur(utlisateur);
	}

}
