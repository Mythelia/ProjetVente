package fr.formation.inti.Dao;
// Generated 10 avr. 2019 10:55:56 by Hibernate Tools 5.1.10.Final

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transaction;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.formation.inti.entities.Annonces;
import fr.formation.inti.entities.Moderateurs;
import fr.formation.inti.entities.MotsClefs;
import fr.formation.inti.entities.Transactions;
import fr.formation.inti.interfaces.dao.ITransactionsDao;

/**
 * Home object for domain model class Transactions.
 * @see fr.formation.inti.Dao.Transactions
 * @author Hibernate Tools
 */
@Stateless
public class TransactionsDao implements ITransactionsDao{

	//@Autowired
    private SessionFactory sessionFactory;
	
	private static final Log log = LogFactory.getLog(TransactionsDao.class);
	
	public Transactions findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Transactions instance;
		try {
			session.getTransaction().begin();
			instance = (Transactions) session.get(Transactions.class, id);
			session.getTransaction().commit();
			return instance;
		} catch (HibernateException e) {
			log.error(e.getLocalizedMessage());
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
			return null;
		} finally {
			if (session.isConnected() != false) {
				session.close();
			}
		}
	}
	public void create(Transactions transactions) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.getTransaction().begin();
			session.persist(transactions);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error(e.getLocalizedMessage());
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
		} finally {
			if (session.isConnected() != false) {
				session.close();
			}
		}
	}
	public void update(Transactions transactions) {

		Session session = sessionFactory.getCurrentSession();
		try {
			session.getTransaction().begin();
			session.update(transactions);
			session.getTransaction().commit();

		} catch (HibernateException e) {
			log.error(e.getLocalizedMessage());
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
		} finally {
			if (session.isConnected() != false) {
				session.close();
			}
		}
	}

	public void delete(Transactions transactions) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.getTransaction().begin();
			session.delete(transactions);
			session.getTransaction().commit();

		} catch (HibernateException e) {
			log.error(e.getLocalizedMessage());
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
		} finally {
			if (session.isConnected() != false) {
				session.close();
			}
		}
	}

	public List<Transactions> getAll() {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.getTransaction().begin();
			List<Transactions> list = session.createQuery("from Transactions").list();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
			return null;
		} finally {
			if (session.isConnected() != false) {
				session.close();
			}
		}

	}

}