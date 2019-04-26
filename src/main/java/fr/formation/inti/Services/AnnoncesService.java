package fr.formation.inti.Services;

import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.inti.Entities.Annonces;
import fr.formation.inti.interfaces.dao.IAnnoncesDao;
import fr.formation.inti.interfaces.services.IAnnoncesService;

@Service
@Transactional
public class AnnoncesService implements IAnnoncesService {

	private static final Log log = LogFactory.getLog(AnnoncesService.class);

	public AnnoncesService() {
	}

	@Autowired
	private IAnnoncesDao dao;
	{

	}

	public void setDao(IAnnoncesDao dao) {
		this.dao = dao;
	}

	public void updateAnnonces(Annonces annonces) {
		dao.update(annonces);
	}

	public void deleteAnnonces(Annonces annonces) {
		dao.delete(annonces);
	}

	public List<Annonces> getAllAnnonces() {
		return dao.getAll();

	}

	public void createAnnonces(Annonces annonces) {
		dao.create(annonces);
	}

	public Annonces findByIdAnnonces(int Id) {
		return dao.findById(Id);
	}

	public Set<Annonces> getAnnoncesByMotClef(String motClef) {
		return dao.getAnnoncesByMotClef(motClef);
	}
}
