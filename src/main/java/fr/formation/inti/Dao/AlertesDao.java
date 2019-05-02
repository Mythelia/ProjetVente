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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.formation.inti.entities.Alertes;
import fr.formation.inti.interfaces.dao.IAlertesDao;

/**
 * Home object for domain model class Alerte.
 * 
 * @see fr.formation.inti.Dao.Alerte
 * @author Hibernate Tools
 */
@Repository("AlerteDao")
public class AlertesDao implements IAlertesDao {

	 @Autowired
	private SessionFactory sessionFactory;

	private static final Log log = LogFactory.getLog(AlertesDao.class);

	public Alertes findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Alertes instance;
		try {
			instance = (Alertes) session.get(Alertes.class, id);
			return instance;
		} catch (HibernateException e) {
			log.error(e.getLocalizedMessage());

			return null;

		}
	}

	public void create(Alertes alertes) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.persist(alertes);

		} catch (HibernateException e) {
			log.error(e.getLocalizedMessage());

		}
	}

	public void update(Alertes alertes) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(alertes);

		} catch (HibernateException e) {
			log.error(e.getLocalizedMessage());

		}
	}

	public void delete(Alertes alertes) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.delete(alertes);

		} catch (HibernateException e) {
			log.error(e.getLocalizedMessage());

		}
	}

	public List<Alertes> getAll() {
		Session session = sessionFactory.getCurrentSession();
		try {
			List<Alertes> list = session.createQuery("from Alertes").list();
			return list;
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());

			return null;
		}

	}

}
