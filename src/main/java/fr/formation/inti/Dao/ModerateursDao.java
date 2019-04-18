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
import fr.formation.inti.entities.Messages;
import fr.formation.inti.entities.Moderateurs;
import fr.formation.inti.interfaces.dao.IModerateursDao;

/**
 * Home object for domain model class Moderateurs.
 * 
 * @see fr.formation.inti.Dao.Moderateurs
 * @author Hibernate Tools
 */
@Stateless
public class ModerateursDao implements IModerateursDao {

	// @Autowired
	private SessionFactory sessionFactory;

	private static final Log log = LogFactory.getLog(ModerateursDao.class);

	public Moderateurs findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Moderateurs instance;
		try {
			session.getTransaction().begin();
			instance = (Moderateurs) session.get(Moderateurs.class, id);
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

	public void create(Moderateurs moderateurs) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.getTransaction().begin();
			session.persist(moderateurs);
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

	public void update(Moderateurs moderateurs) {

		Session session = sessionFactory.getCurrentSession();
		try {
			session.getTransaction().begin();
			session.update(moderateurs);
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

	public void delete(Moderateurs moderateurs) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.getTransaction().begin();
			session.delete(moderateurs);
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

	public List<Moderateurs> getAll() {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.getTransaction().begin();
			List<Moderateurs> list = session.createQuery("from MotsClefs").list();
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