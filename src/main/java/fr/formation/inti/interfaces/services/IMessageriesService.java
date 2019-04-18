package fr.formation.inti.interfaces.services;

import java.util.List;

import fr.formation.inti.entities.Messageries;

public interface IMessageriesService {

	Messageries findByIdMessageries(int Id);

	void createMessageries(Messageries messageries);

	void deleteMessageries(Messageries messageries);

	List<Messageries> getAllMessageries();

	void updateMessageries(Messageries messageries);

}
