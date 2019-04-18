package fr.formation.inti.Services;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import fr.formation.inti.entities.Annonces;
import fr.formation.inti.interfaces.dao.IAnnoncesDao;
import fr.formation.inti.interfaces.services.IAnnoncesService;

//@Service("service")

public class AnnoncesService implements IAnnoncesService {

	private static final Log log = LogFactory.getLog(AnnoncesService.class);
	
			public AnnoncesService() {
	}
	

	private IAnnoncesDao dao;{
	
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
	public List<Annonces> getAllAnnonces(){
		return dao.getAll();
		
	}
	public void createAnnonces(Annonces annonces) {
		dao.create(annonces);
	}
	public Annonces findByIdAnnonces(int Id) {
		return dao.findById(Id);
	}
	
	
}
