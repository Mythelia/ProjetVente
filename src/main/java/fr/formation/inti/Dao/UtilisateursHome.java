package fr.formation.inti.Dao;
// Generated 10 avr. 2019 10:55:56 by Hibernate Tools 5.1.10.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.formation.inti.entities.Utilisateurs;

/**
 * Home object for domain model class Utilisateurs.
 * @see fr.formation.inti.Dao.Utilisateurs
 * @author Hibernate Tools
 */
@Stateless
public class UtilisateursHome {

	private static final Log log = LogFactory.getLog(UtilisateursHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Utilisateurs transientInstance) {
		log.debug("persisting Utilisateurs instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Utilisateurs persistentInstance) {
		log.debug("removing Utilisateurs instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Utilisateurs merge(Utilisateurs detachedInstance) {
		log.debug("merging Utilisateurs instance");
		try {
			Utilisateurs result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Utilisateurs findById(Integer id) {
		log.debug("getting Utilisateurs instance with id: " + id);
		try {
			Utilisateurs instance = entityManager.find(Utilisateurs.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
