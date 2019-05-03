package fr.formation.inti.interfaces.services;

import java.util.List;

import fr.formation.inti.entities.Alerte;
import fr.formation.inti.entities.Utilisateurs;

public interface IAlertesService {

	Alerte findByIdAlerte(int Id);

	void createAlerte(Alerte alrt);

	void deleteAlerte(Alerte alrt);

	List<Alerte> getAllAlerte();

	void updateAlerte(Alerte alrt);

	List<Alerte> getAlerteByUtilisateur(Utilisateurs utlisateur);

}
