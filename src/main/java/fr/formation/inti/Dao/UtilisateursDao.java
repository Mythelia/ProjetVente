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
import org.springframework.transaction.annotation.Transactional;

import fr.formation.inti.entities.Utilisateurs;

/**
 * Home object for domain model class Utilisateurs.
 * 
 * @see fr.formation.inti.Dao.Utilisateurs
 * @author Hibernate Tools
 */

@Repository("userDao")
public class UtilisateursDao implements IUtilisateursDao {

	@Autowired
	private SessionFactory sessionFactory;

	private static final Log log = LogFactory.getLog(UtilisateursDao.class);

	
	public Utilisateurs findById(Integer id) {
		Session session = sessionFactory.getCurrentSession();

		Utilisateurs instance;
		try {

			instance = (Utilisateurs) session.load(Utilisateurs.class, id);

			return instance;
		} catch (HibernateException e) {
			log.error(e.getLocalizedMessage());

			return null;
		}
	}

	public Utilisateurs create(Utilisateurs utilisateurs) {
		Session session = sessionFactory.getCurrentSession();
		try {

			session.saveOrUpdate(utilisateurs);

		} catch (HibernateException e) {
			log.error(e.getLocalizedMessage());

		}
		return utilisateurs;
	}

	public void update(Utilisateurs utilisateurs) {

		Session session = sessionFactory.getCurrentSession();
		try {

			session.update(utilisateurs);

		} catch (HibernateException e) {
			log.error(e.getLocalizedMessage());
		}
	}

	public void delete(Utilisateurs utilisateurs) {
		Session session = sessionFactory.getCurrentSession();
		try {

			session.delete(utilisateurs);

		} catch (HibernateException e) {
			log.error(e.getLocalizedMessage());
		}
	}

	public List<Utilisateurs> getAll() {
		Session session = sessionFactory.getCurrentSession();
		try {

			List<Utilisateurs> list = session.createQuery("from Utilisateurs").list();

			return list;
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
			return null;

		}

	}

	public Utilisateurs findByLogin(String login) {
		Session session = sessionFactory.getCurrentSession();
		List<Utilisateurs> results;
		try {
			results = session.createCriteria(Utilisateurs.class).add(Restrictions.like("login", login)).list();

			for (Utilisateurs result : results) {
				return result;
			}
		} catch (Exception e) {
			return null;

		}
		return null;
	}

}