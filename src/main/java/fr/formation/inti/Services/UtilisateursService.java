package fr.formation.inti.Services;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.inti.Dao.IUtilisateursDao;
import fr.formation.inti.Entities.Utilisateurs;
import fr.formation.inti.interfaces.services.IUtilisateursService;

@Service("serviceUtil")
@Transactional
public class UtilisateursService implements IUtilisateursService {

	private static final Log log = LogFactory.getLog(UtilisateursService.class);

	public UtilisateursService() {
	}

	@Autowired
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
	
	public Utilisateurs findByLoginUtilisateurs(String login) {
		return dao.findByLogin(login);
	}
	@Transactional
	public Utilisateurs createUtilisateurs(Utilisateurs utilisateurs) {
		return dao.create(utilisateurs);

	}
}
