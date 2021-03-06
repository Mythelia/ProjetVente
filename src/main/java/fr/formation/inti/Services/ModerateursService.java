package fr.formation.inti.Services;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.inti.entities.Moderateurs;
import fr.formation.inti.interfaces.dao.IModerateursDao;
import fr.formation.inti.interfaces.services.IModerateursService;

@Service
@Transactional
public class ModerateursService implements IModerateursService {

	private static final Log log = LogFactory.getLog(ModerateursService.class);

	public ModerateursService() {

	}

	@Autowired
	private IModerateursDao dao;

	public void setDao(IModerateursDao dao) {
		this.dao = dao;
	}

	public void updateModerateurs(Moderateurs moderateurs) {
		dao.update(moderateurs);
	}

	public void deleteModerateurs(Moderateurs moderateurs) {
		dao.delete(moderateurs);
	}

	public List<Moderateurs> getAllModerateurs() {
		return dao.getAll();

	}

	public void createModerateurs(Moderateurs moderateurs) {
		dao.create(moderateurs);
	}

	public Moderateurs findByIdModerateurs(int Id) {
		return dao.findById(Id);
	}
}
