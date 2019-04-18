package fr.formation.inti.Dao;
// Generated 10 avr. 2019 10:55:56 by Hibernate Tools 5.1.10.Final

import java.util.List;

import javax.ejb.Stateless;
import javax.transaction.Transaction;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.formation.inti.entities.Alertes;
import fr.formation.inti.interfaces.dao.IAlertesDao;

/**
 * Home object for domain model class Alerte.
 * 
 * @see fr.formation.inti.Dao.Alerte
 * @author Hibernate Tools
 */
@Stateless
public class AlertesDao implements IAlertesDao {

	// @Autowired
	private SessionFactory sessionFactory;

	private static final Log log = LogFactory.getLog(AlertesDao.class);

	public Alertes findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Alertes instance;
		try {
			session.getTransaction().begin();
			instance = (Alertes) session.get(Alertes.class, id);
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

	public void create(Alertes alertes) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.getTransaction().begin();
			session.persist(alertes);
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

	public void update(Alertes alertes) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.getTransaction().begin();
			session.update(alertes);
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

	public void delete(Alertes alertes) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.getTransaction().begin();
			session.delete(alertes);
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

	public List<Alertes> getAll() {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.getTransaction().begin();
			List<Alertes> list = session.createQuery("from Alertes").list();
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
