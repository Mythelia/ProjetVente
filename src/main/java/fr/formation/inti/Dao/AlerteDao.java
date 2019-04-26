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

import fr.formation.inti.entities.Alerte;
import fr.formation.inti.interfaces.dao.IAlerteDao;

/**
 * Home object for domain model class Alerte.
 * 
 * @see fr.formation.inti.Dao.Alerte
 * @author Hibernate Tools
 */
@Repository("AlerteDao")
public class AlerteDao implements IAlerteDao {

	@Autowired
	private SessionFactory sessionFactory;

	private static final Log log = LogFactory.getLog(AlerteDao.class);

	public Alerte findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Alerte instance;
		try {
			instance = (Alerte) session.get(Alerte.class, id);
			return instance;
		} catch (HibernateException e) {
			log.error(e.getLocalizedMessage());

			return null;

		}
	}

	public void create(Alerte Alerte) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.persist(Alerte);

		} catch (HibernateException e) {
			log.error(e.getLocalizedMessage());

		}
	}

	public void update(Alerte Alerte) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(Alerte);

		} catch (HibernateException e) {
			log.error(e.getLocalizedMessage());

		}
	}

	public void delete(Alerte Alerte) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.delete(Alerte);

		} catch (HibernateException e) {
			log.error(e.getLocalizedMessage());

		}
	}

	public List<Alerte> getAll() {
		Session session = sessionFactory.getCurrentSession();
		try {
			List<Alerte> list = session.createQuery("from Alerte").list();
			return list;
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());

			return null;
		}

	}

}
