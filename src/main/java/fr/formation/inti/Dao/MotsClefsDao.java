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
import fr.formation.inti.interfaces.dao.IMotsClefsDao;

/**
 * Home object for domain model class MotsClefs.
 * 
 * @see fr.formation.inti.Dao.MotsClefs
 * @author Hibernate Tools
 */
@Stateless
public class MotsClefsDao implements IMotsClefsDao {

	// @Autowired
	private SessionFactory sessionFactory;

	private static final Log log = LogFactory.getLog(MotsClefsDao.class);

	public MotsClefs findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		MotsClefs instance;
		try {
			session.getTransaction().begin();
			instance = (MotsClefs) session.get(MotsClefs.class, id);
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

	public void create(MotsClefs motsclefs) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.getTransaction().begin();
			session.persist(motsclefs);
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

	public void update(MotsClefs motsclefs) {

		Session session = sessionFactory.getCurrentSession();
		try {
			session.getTransaction().begin();
			session.update(motsclefs);
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

	public void delete(MotsClefs motsclefs) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.getTransaction().begin();
			session.delete(motsclefs);
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

	public List<MotsClefs> getAll() {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.getTransaction().begin();
			List<MotsClefs> list = session.createQuery("from MotsClefs").list();
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