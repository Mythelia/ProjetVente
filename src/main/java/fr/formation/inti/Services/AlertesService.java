package fr.formation.inti.Services;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import fr.formation.inti.Dao.AlertesDao;
import fr.formation.inti.entities.Alertes;
import fr.formation.inti.interfaces.dao.IAlertesDao;
import fr.formation.inti.interfaces.services.IAlertesService;

//@Service("service")

public class AlertesService implements IAlertesService {

	private static final Log log = LogFactory.getLog(AlertesService.class);

	public AlertesService() {
	}

	private IAlertesDao dao;

	public void setDao(IAlertesDao dao) {
		this.dao = dao;

	}

	public void updateAlertes(Alertes alrt) {
		dao.update(alrt);

	}

	public void deleteAlertes(Alertes alrt) {
		dao.delete(alrt);

	}

	public List<Alertes> getAllAlertes() {
		return dao.getAll();
	}

	public void createAlertes(Alertes alrt) {
		dao.create(alrt);
	}

	public Alertes findByIdAlertes(int Id) {
		return dao.findById(Id);
	}

}
