package fr.formation.inti.interfaces.services;

import java.util.List;

import fr.formation.inti.entities.Transactions;

public interface ITransactionsService {
	
	Transactions findByIdTransactions(int Id);
	
	void createTransactions(Transactions transactions);
	
	void deleteTransactions(Transactions transactions);
	
	void updateTransactions(Transactions transactions);
	
	List<Transactions> getAllTransactions();
	
	
	
}
