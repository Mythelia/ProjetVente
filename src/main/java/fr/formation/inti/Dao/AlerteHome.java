package fr.formation.inti.Dao;
// Generated 10 avr. 2019 10:55:56 by Hibernate Tools 5.1.10.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.formation.inti.entities.Alerte;

/**
 * Home object for domain model class Alerte.
 * @see fr.formation.inti.Dao.Alerte
 * @author Hibernate Tools
 */
@Stateless
public class AlerteHome {

	private static final Log log = LogFactory.getLog(AlerteHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Alerte transientInstance) {
		log.debug("persisting Alerte instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Alerte persistentInstance) {
		log.debug("removing Alerte instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Alerte merge(Alerte detachedInstance) {
		log.debug("merging Alerte instance");
		try {
			Alerte result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Alerte findById(int id) {
		log.debug("getting Alerte instance with id: " + id);
		try {
			Alerte instance = entityManager.find(Alerte.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
