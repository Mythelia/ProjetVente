package fr.formation.inti.Dao;
// Generated 10 avr. 2019 10:55:56 by Hibernate Tools 5.1.10.Final

import java.util.List;

import javax.ejb.Stateless;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.formation.inti.entities.Annonces;
import fr.formation.inti.interfaces.dao.IAnnoncesDao;

/**
 * Home object for domain model class Annonces.
 * 
 * @see fr.formation.inti.Dao.Annonces
 * @author Hibernate Tools
 */
@Stateless
public class AnnoncesDao implements IAnnoncesDao {

	// @Autowired
	private SessionFactory sessionFactory;

	private static final Log log = LogFactory.getLog(AnnoncesDao.class);

	public Annonces findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Annonces instance;
		try {
			session.getTransaction().begin();
			instance = (Annonces) session.get(Annonces.class, id);
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

	public void create(Annonces annonces) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.getTransaction().begin();
			session.persist(annonces);
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

	public void update(Annonces annonces) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.getTransaction().begin();
			session.update(annonces);
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

	public void delete(Annonces annonces) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.getTransaction().begin();
			session.delete(annonces);
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

	public List<Annonces> getAll() {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.getTransaction().begin();
			List<Annonces> list = session.createQuery("from Annonces").list();
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
