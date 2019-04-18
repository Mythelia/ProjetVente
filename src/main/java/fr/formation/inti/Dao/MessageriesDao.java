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
import fr.formation.inti.entities.Messageries;
import fr.formation.inti.interfaces.dao.IMessageriesDao;
import fr.formation.inti.interfaces.dao.IMessagesDao;

/**
 * Home object for domain model class Messageries.
 * 
 * @see fr.formation.inti.Dao.Messageries
 * @author Hibernate Tools
 */
@Stateless
public class MessageriesDao implements IMessageriesDao {

	// @Autowired
	private SessionFactory sessionFactory;

	private static final Log log = LogFactory.getLog(MessageriesDao.class);

	public Messageries findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Messageries instance;
		try {
			session.getTransaction().begin();
			instance = (Messageries) session.get(Messageries.class, id);
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

	public void update(Messageries messageries) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.getTransaction().begin();
session.update(messageries);			
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

	public void delete(Messageries messageries) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.getTransaction().begin();
session.delete(messageries);
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

	public void create(Messageries messageries) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.getTransaction().begin();
session.persist(messageries);
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

	public List<Messageries> getAll() {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.getTransaction().begin();
			List<Messageries> list = session.createQuery("from Messageries").list();
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
