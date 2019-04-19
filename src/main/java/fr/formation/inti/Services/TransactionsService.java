package fr.formation.inti.Services;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.inti.Dao.TransactionsDao;
import fr.formation.inti.entities.Transactions;
import fr.formation.inti.interfaces.dao.ITransactionsDao;
import fr.formation.inti.interfaces.services.ITransactionsService;

@Service
@Transactional
public class TransactionsService implements ITransactionsService {

	private static final Log log = LogFactory.getLog(TransactionsService.class);

	public TransactionsService() {
	}

	@Autowired
	private ITransactionsDao dao;

	public void setDao(ITransactionsDao dao) {
		this.dao = dao;

	}

	public void updateTransactions(Transactions transactions) {
		dao.update(transactions);
	}

	public void deleteTransactions(Transactions transactions) {
		dao.delete(transactions);
	}

	public List<Transactions> getAllTransactions() {
		return dao.getAll();
	}

	public void createTransactions(Transactions transactions) {
		dao.create(transactions);
	}

	public Transactions findByIdTransactions(int Id) {
		return dao.findById(Id);

	}

}
