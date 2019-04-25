package fr.formation.inti.Dao;
// Generated 10 avr. 2019 10:55:56 by Hibernate Tools 5.1.10.Final

import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.formation.inti.entities.Annonces;
import fr.formation.inti.entities.MotsClefs;
import fr.formation.inti.entities.Utilisateurs;
import fr.formation.inti.interfaces.dao.IMotsClefsDao;

/**
 * Home object for domain model class MotsClefs.
 * 
 * @see fr.formation.inti.Dao.MotsClefs
 * @author Hibernate Tools
 */
@Repository("MotClefDao")
public class MotsClefsDao implements IMotsClefsDao {

	@Autowired
	private SessionFactory sessionFactory;

	private static final Log log = LogFactory.getLog(MotsClefsDao.class);

	public MotsClefs findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		MotsClefs instance;
		try {
			instance = (MotsClefs) session.get(MotsClefs.class, id);
			return instance;
		} catch (HibernateException e) {
			log.error(e.getLocalizedMessage());

			return null;

		}

	}

	public void create(MotsClefs motsclefs) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.persist(motsclefs);
		} catch (HibernateException e) {
			log.error(e.getLocalizedMessage());

		}
	}

	public void update(MotsClefs motsclefs) {

		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(motsclefs);

		} catch (HibernateException e) {
			log.error(e.getLocalizedMessage());

		}
	}

	public void delete(MotsClefs motsclefs) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.delete(motsclefs);

		} catch (HibernateException e) {
			log.error(e.getLocalizedMessage());

		}
	}

	public List<MotsClefs> getAll() {
		Session session = sessionFactory.getCurrentSession();
		try {
			List<MotsClefs> list = session.createQuery("from MotsClefs").list();
			return list;
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());

			return null;
		}

	}

	public MotsClefs findByMotClef(String motClef) {
		Session session = sessionFactory.getCurrentSession();
		List<MotsClefs> results;
		try {
			results = session.createCriteria(MotsClefs.class).add(Restrictions.like("motClef", motClef)).list();

			for (MotsClefs result : results) {
				return result;
			}
		} catch (Exception e) {
			return null;

		}
		return null;
	}

}