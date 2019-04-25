package fr.formation.inti.Services;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.inti.Dao.MotsClefsDao;
import fr.formation.inti.entities.MotsClefs;
import fr.formation.inti.interfaces.dao.IMotsClefsDao;
import fr.formation.inti.interfaces.services.IMotsClefsService;

@Service
@Transactional
public class MotsClefsService implements IMotsClefsService {

	private static final Log log = LogFactory.getLog(MotsClefsService.class);

	public MotsClefsService() {

	}

	@Autowired
	private IMotsClefsDao dao;

	public void setDao(IMotsClefsDao dao) {
		this.dao = dao;

	}

	public void updateMotsClefs(MotsClefs motsclefs) {
		dao.update(motsclefs);
	}

	public void deleteMotsClefs(MotsClefs motsclefs) {
		dao.delete(motsclefs);

	}

	public List<MotsClefs> getAllMotsClefs() {
		return dao.getAll();
	}

	public void createMotsClefs(MotsClefs motsclefs) {
		dao.create(motsclefs);

	}

	public MotsClefs findByIdMotsClefs(int Id) {
		return dao.findById(Id);
	}
	
	public MotsClefs findByMotClef(String motClef) {
		return dao.findByMotClef(motClef);
	}
}
