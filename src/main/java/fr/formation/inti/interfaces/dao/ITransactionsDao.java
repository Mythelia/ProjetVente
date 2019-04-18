package fr.formation.inti.interfaces.dao;

import java.util.List;

import fr.formation.inti.entities.Transactions;

public interface ITransactionsDao {
	
	Transactions findById(int Id);
	
	void create(Transactions transactions);
	
	void delete(Transactions transactions);
	
	void update(Transactions transactions);
	
	List<Transactions> getAll();
	
	
	
}
