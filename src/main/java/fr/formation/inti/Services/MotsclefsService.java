package fr.formation.inti.Services;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.inti.entities.MotsClefs;
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

	public void updateMotsclefs(MotsClefs Motsclefs) {
		dao.update(Motsclefs);
	}

	public void deleteMotsclefs(MotsClefs Motsclefs) {
		dao.delete(Motsclefs);

	}

	public List<MotsClefs> getAllMotsclefs() {
		return dao.getAll();
	}

	public void createMotsclefs(MotsClefs Motsclefs) {
		dao.create(Motsclefs);

	}

	public MotsClefs findByIdMotsClefs(int Id) {
		return dao.findById(Id);
	}

	public MotsClefs findByMotclef(String motClef) {
		return dao.findByMotClef(motClef);
	}
	public Integer countMotClefOccurences(MotsClefs motClef) {
		return dao.countMotClefOccurences(motClef);
	}

}
