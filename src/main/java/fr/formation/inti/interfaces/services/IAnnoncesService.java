package fr.formation.inti.interfaces.services;

import java.util.List;
import java.util.Set;

import fr.formation.inti.entities.Annonces;
import fr.formation.inti.entities.Utilisateurs;

public interface IAnnoncesService {

	Annonces findByIdAnnonces(int Id);

	void createAnnonces(Annonces annonces);

	void deleteAnnonces(Annonces annonces);

	List<Annonces> getAllAnnonces();

	void updateAnnonces(Annonces annonces);

	Set<Annonces> getAnnoncesByMotClef(String motClef);

	List<Annonces> getAnnoncesByUtilisateur(Utilisateurs utlisateur);
	
	List<Annonces> getLastAnnonces();

}
