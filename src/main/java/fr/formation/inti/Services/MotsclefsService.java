package fr.formation.inti.Services;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.inti.Entities.Motsclefs;
import fr.formation.inti.interfaces.dao.IMotsClefsDao;
import fr.formation.inti.interfaces.services.IMotsClefsService;

@Service
@Transactional
public class MotsclefsService implements IMotsClefsService {

	private static final Log log = LogFactory.getLog(MotsclefsService.class);

	public MotsclefsService() {

	}

	@Autowired
	private IMotsClefsDao dao;

	public void setDao(IMotsClefsDao dao) {
		this.dao = dao;

	}

	public void updateMotsclefs(Motsclefs Motsclefs) {
		dao.update(Motsclefs);
	}

	public void deleteMotsclefs(Motsclefs Motsclefs) {
		dao.delete(Motsclefs);

	}

	public List<Motsclefs> getAllMotsclefs() {
		return dao.getAll();
	}

	public void createMotsclefs(Motsclefs Motsclefs) {
		dao.create(Motsclefs);

	}

	public Motsclefs findByIdMotsClefs(int Id) {
		return dao.findById(Id);
	}

	public Motsclefs findByMotclef(String motClef) {
		return dao.findByMotClef(motClef);
	}

}
