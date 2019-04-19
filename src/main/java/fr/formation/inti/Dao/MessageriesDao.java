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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.formation.inti.entities.Annonces;
import fr.formation.inti.entities.Messageries;
import fr.formation.inti.interfaces.dao.IMessageriesDao;

/**
 * Home object for domain model class Messageries.
 * 
 * @see fr.formation.inti.Dao.Messageries
 * @author Hibernate Tools
 */
@Repository("MessagerieDao")
public class MessageriesDao implements IMessageriesDao {

	@Autowired
	private SessionFactory sessionFactory;

	private static final Log log = LogFactory.getLog(MessageriesDao.class);

	public Messageries findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Messageries instance;
		try {
			instance = (Messageries) session.get(Messageries.class, id);
			return instance;
		} catch (HibernateException e) {
			log.error(e.getLocalizedMessage());

			return null;
		}

	}

	public void update(Messageries messageries) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(messageries);

		} catch (HibernateException e) {
			log.error(e.getLocalizedMessage());

		}
	}

	public void delete(Messageries messageries) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.delete(messageries);
		} catch (HibernateException e) {
			log.error(e.getLocalizedMessage());

		}
	}

	public void create(Messageries messageries) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.persist(messageries);
		} catch (HibernateException e) {
			log.error(e.getLocalizedMessage());

		}
	}

	public List<Messageries> getAll() {
		Session session = sessionFactory.getCurrentSession();
		try {
			List<Messageries> list = session.createQuery("from Messageries").list();
			return list;
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());

			return null;

		}

	}
}
