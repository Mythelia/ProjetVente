package fr.formation.inti.Services;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.formation.inti.Dao.UtilisateursDao;
import fr.formation.inti.entities.Utilisateurs;
import fr.formation.inti.interfaces.dao.IUtilisateursDao;
import fr.formation.inti.interfaces.services.IUtilisateursService;

//@Service("service")

public class UtilisateursService implements IUtilisateursService {

	private static final Log log = LogFactory.getLog(UtilisateursService.class);

	public UtilisateursService() {
	}

	private IUtilisateursDao dao;

	public void setDao(IUtilisateursDao dao) {
		this.dao = dao;

	}

	public void updateUtilisateurs(Utilisateurs utilisateurs) {
		dao.update(utilisateurs);

	}

	public void deleteUtilisateurs(Utilisateurs utilisateurs) {
		dao.delete(utilisateurs);

	}

	public List<Utilisateurs> getAllUtilisateurs() {
		return dao.getAll();
	}

	public Utilisateurs findByIdUtilisateurs(int Id) {
		return dao.findById(Id);
	}

	public void createUtilisateurs(Utilisateurs utilisateurs) {
		dao.create(utilisateurs);
		
	}
}
