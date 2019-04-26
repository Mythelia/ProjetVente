package fr.formation.inti.Dao;
// Generated 10 avr. 2019 10:55:56 by Hibernate Tools 5.1.10.Final

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.formation.inti.entities.AnnoncesHasMotsclefs;
import fr.formation.inti.entities.MotsClefs;
import fr.formation.inti.interfaces.dao.IMotsClefsDao;

/**
 * Home object for domain model class Motsclefs.
 * 
 * @see fr.formation.inti.Dao.MotsClefs
 * @author Hibernate Tools
 */
@Repository("MotClefDao")
public class MotsclefsDao implements IMotsClefsDao {

	@Autowired
	private SessionFactory sessionFactory;

	private static final Log log = LogFactory.getLog(MotsclefsDao.class);

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

	public void create(MotsClefs Motsclefs) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.persist(Motsclefs);
		} catch (HibernateException e) {
			log.error(e.getLocalizedMessage());

		}
	}

	public void update(MotsClefs Motsclefs) {

		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(Motsclefs);

		} catch (HibernateException e) {
			log.error(e.getLocalizedMessage());

		}
	}

	public void delete(MotsClefs Motsclefs) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.delete(Motsclefs);

		} catch (HibernateException e) {
			log.error(e.getLocalizedMessage());

		}
	}

	public List<MotsClefs> getAll() {
		Session session = sessionFactory.getCurrentSession();
		try {
			List<MotsClefs> list = session.createQuery("from MotsClefs").list(); // ça n'a pas de sens
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
	
	public Integer countMotClefOccurences(MotsClefs motClef) {

		Session session = sessionFactory.getCurrentSession();
		Integer result = 0;
		
		try {
			Criteria crit = session.createCriteria(AnnoncesHasMotsclefs.class).add(Restrictions.like("idMotClef", motClef.getIdMotClef()));
			result = ((Number)crit.setProjection(Projections.rowCount()).uniqueResult()).intValue();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			return null;

		}
		
	}

}