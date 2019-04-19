package fr.formation.inti.Dao;
// Generated 10 avr. 2019 10:55:56 by Hibernate Tools 5.1.10.Final

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.formation.inti.entities.Transactions;
import fr.formation.inti.interfaces.dao.ITransactionsDao;

/**
 * Home object for domain model class Transactions.
 * 
 * @see fr.formation.inti.Dao.Transactions
 * @author Hibernate Tools
 */
@Repository("transactionDao")
public class TransactionsDao implements ITransactionsDao {

	 @Autowired
	private SessionFactory sessionFactory;

	private static final Log log = LogFactory.getLog(TransactionsDao.class);

	public Transactions findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Transactions instance;
		try {

			instance = (Transactions) session.get(Transactions.class, id);

			return instance;
		} catch (HibernateException e) {
			log.error(e.getLocalizedMessage());
			return null;

		}
	}

	public void create(Transactions transactions) {
		Session session = sessionFactory.getCurrentSession();
		try {

			session.persist(transactions);

		} catch (HibernateException e) {
			log.error(e.getLocalizedMessage());

		}
	}

	public void update(Transactions transactions) {

		Session session = sessionFactory.getCurrentSession();
		try {

			session.update(transactions);

		} catch (HibernateException e) {
			log.error(e.getLocalizedMessage());

		}
	}

	public void delete(Transactions transactions) {
		Session session = sessionFactory.getCurrentSession();
		try {

			session.delete(transactions);

		} catch (HibernateException e) {
			log.error(e.getLocalizedMessage());

		}
	}

	public List<Transactions> getAll() {
		Session session = sessionFactory.getCurrentSession();
		try {
			List<Transactions> list = session.createQuery("from Transactions").list();
			return list;
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());

			return null;

		}

	}

}