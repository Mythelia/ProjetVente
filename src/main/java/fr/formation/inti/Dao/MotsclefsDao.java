package fr.formation.inti.Dao;
// Generated 10 avr. 2019 10:55:56 by Hibernate Tools 5.1.10.Final

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.formation.inti.Entities.Motsclefs;
import fr.formation.inti.interfaces.dao.IMotsClefsDao;

/**
 * Home object for domain model class Motsclefs.
 * 
 * @see fr.formation.inti.Dao.Motsclefs
 * @author Hibernate Tools
 */
@Repository("MotClefDao")
public class MotsclefsDao implements IMotsClefsDao {

	@Autowired
	private SessionFactory sessionFactory;

	private static final Log log = LogFactory.getLog(MotsclefsDao.class);

	public Motsclefs findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Motsclefs instance;
		try {
			instance = (Motsclefs) session.get(Motsclefs.class, id);
			return instance;
		} catch (HibernateException e) {
			log.error(e.getLocalizedMessage());

			return null;

		}

	}

	public void create(Motsclefs Motsclefs) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.persist(Motsclefs);
		} catch (HibernateException e) {
			log.error(e.getLocalizedMessage());

		}
	}

	public void update(Motsclefs Motsclefs) {

		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(Motsclefs);

		} catch (HibernateException e) {
			log.error(e.getLocalizedMessage());

		}
	}

	public void delete(Motsclefs Motsclefs) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.delete(Motsclefs);

		} catch (HibernateException e) {
			log.error(e.getLocalizedMessage());

		}
	}

	public List<Motsclefs> getAll() {
		Session session = sessionFactory.getCurrentSession();
		try {
			List<Motsclefs> list = session.createQuery("from Motsclefs").list();
			return list;
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());

			return null;
		}

	}

	public Motsclefs findByMotClef(String motClef) {
		Session session = sessionFactory.getCurrentSession();
		List<Motsclefs> results;
		try {
			results = session.createCriteria(Motsclefs.class).add(Restrictions.like("motClef", motClef)).list();

			for (Motsclefs result : results) {
				return result;
			}
		} catch (Exception e) {
			return null;

		}
		return null;
	}

}