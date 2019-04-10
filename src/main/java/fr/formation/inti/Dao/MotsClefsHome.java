package fr.formation.inti.Dao;
// Generated 10 avr. 2019 10:55:56 by Hibernate Tools 5.1.10.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.formation.inti.entities.MotsClefs;

/**
 * Home object for domain model class MotsClefs.
 * @see fr.formation.inti.Dao.MotsClefs
 * @author Hibernate Tools
 */
@Stateless
public class MotsClefsHome {

	private static final Log log = LogFactory.getLog(MotsClefsHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(MotsClefs transientInstance) {
		log.debug("persisting MotsClefs instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(MotsClefs persistentInstance) {
		log.debug("removing MotsClefs instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public MotsClefs merge(MotsClefs detachedInstance) {
		log.debug("merging MotsClefs instance");
		try {
			MotsClefs result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MotsClefs findById(int id) {
		log.debug("getting MotsClefs instance with id: " + id);
		try {
			MotsClefs instance = entityManager.find(MotsClefs.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
