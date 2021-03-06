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

import fr.formation.inti.entities.MotsClefs;
import fr.formation.inti.interfaces.dao.IMotsClefsDao;


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
			session.saveOrUpdate(Motsclefs);
		} catch (HibernateException e) {
			log.error(e.getLocalizedMessage());

		}
	}

	public void update(MotsClefs Motsclefs) {

		Session session = sessionFactory.getCurrentSession();
		try {
			session.saveOrUpdate(Motsclefs);

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
			List<MotsClefs> list = session.createQuery("from MotsClefs").list(); // �a n'a pas de sens
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

		return motClef.getAnnonceses().size();
		
	}

}