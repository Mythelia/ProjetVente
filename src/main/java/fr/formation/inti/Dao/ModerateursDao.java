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

import fr.formation.inti.entities.Moderateurs;
import fr.formation.inti.interfaces.dao.IModerateursDao;

/**
 * Home object for domain model class Moderateurs.
 * 
 * @see fr.formation.inti.Dao.Moderateurs
 * @author Hibernate Tools
 */
@Repository("ModoDao")
public class ModerateursDao implements IModerateursDao {

	 @Autowired
	private SessionFactory sessionFactory;

	private static final Log log = LogFactory.getLog(ModerateursDao.class);

	public Moderateurs findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Moderateurs instance;
		try {
			instance = (Moderateurs) session.get(Moderateurs.class, id);
			return instance;
		} catch (HibernateException e) {
			log.error(e.getLocalizedMessage());

			return null;
		}
	}

	public void create(Moderateurs moderateurs) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.persist(moderateurs);
		} catch (HibernateException e) {
			log.error(e.getLocalizedMessage());
			
		}
	}

	public void update(Moderateurs moderateurs) {

		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(moderateurs);

		} catch (HibernateException e) {
			log.error(e.getLocalizedMessage());
			
		}
	}

	public void delete(Moderateurs moderateurs) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.delete(moderateurs);

		} catch (HibernateException e) {
			log.error(e.getLocalizedMessage());
			
		}
	}

	public List<Moderateurs> getAll() {
		Session session = sessionFactory.getCurrentSession();
		try {
			List<Moderateurs> list = session.createQuery("from MotsClefs").list();
			return list;
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
			
			return null;
		
		}

	}

}