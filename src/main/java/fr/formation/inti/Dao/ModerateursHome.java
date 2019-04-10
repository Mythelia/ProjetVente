package fr.formation.inti.Dao;
// Generated 10 avr. 2019 10:55:56 by Hibernate Tools 5.1.10.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.formation.inti.entities.Moderateurs;

/**
 * Home object for domain model class Moderateurs.
 * @see fr.formation.inti.Dao.Moderateurs
 * @author Hibernate Tools
 */
@Stateless
public class ModerateursHome {

	private static final Log log = LogFactory.getLog(ModerateursHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Moderateurs transientInstance) {
		log.debug("persisting Moderateurs instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Moderateurs persistentInstance) {
		log.debug("removing Moderateurs instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Moderateurs merge(Moderateurs detachedInstance) {
		log.debug("merging Moderateurs instance");
		try {
			Moderateurs result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Moderateurs findById(int id) {
		log.debug("getting Moderateurs instance with id: " + id);
		try {
			Moderateurs instance = entityManager.find(Moderateurs.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
