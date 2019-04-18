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
import fr.formation.inti.entities.Utilisateurs;
import fr.formation.inti.interfaces.dao.IUtilisateursDao;

/**
 * Home object for domain model class Utilisateurs.
 * 
 * @see fr.formation.inti.Dao.Utilisateurs
 * @author Hibernate Tools
 */
@Stateless
public class UtilisateursDao implements IUtilisateursDao{

	//@Autowired
    private SessionFactory sessionFactory;
	
	private static final Log log = LogFactory.getLog(UtilisateursDao.class);

	
	public Utilisateurs findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Utilisateurs instance;
		try {
			session.getTransaction().begin();
			instance = (Utilisateurs) session.get(Utilisateurs.class, id);
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


	public void create(Utilisateurs utilisateurs) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.getTransaction().begin();
			session.persist(utilisateurs);
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

	public void update(Utilisateurs utilisateurs) {

		Session session = sessionFactory.getCurrentSession();
		try {
			session.getTransaction().begin();
			session.update(utilisateurs);
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

	public void delete(Utilisateurs utilisateurs) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.getTransaction().begin();
			session.delete(utilisateurs);
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

	public List<Utilisateurs> getAll() {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.getTransaction().begin();
			List<Utilisateurs> list = session.createQuery("from Utilisateurs").list();
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