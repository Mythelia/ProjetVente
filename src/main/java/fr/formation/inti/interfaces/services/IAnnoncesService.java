package fr.formation.inti.interfaces.services;

import java.util.List;
import java.util.Set;

import fr.formation.inti.entities.Annonces;

public interface IAnnoncesService {

	Annonces findByIdAnnonces(int Id);

	void createAnnonces(Annonces annonces);

	void deleteAnnonces(Annonces annonces);

	List<Annonces> getAllAnnonces();

	void updateAnnonces(Annonces annonces);

	public Set<Annonces> getAnnoncesByMotClef(String motClef);
	
}
