package fr.formation.inti.Dao;
// Generated 10 avr. 2019 10:55:56 by Hibernate Tools 5.1.10.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.formation.inti.entities.Annonces;

/**
 * Home object for domain model class Annonces.
 * @see fr.formation.inti.Dao.Annonces
 * @author Hibernate Tools
 */
@Stateless
public class AnnoncesHome {

	private static final Log log = LogFactory.getLog(AnnoncesHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Annonces transientInstance) {
		log.debug("persisting Annonces instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Annonces persistentInstance) {
		log.debug("removing Annonces instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Annonces merge(Annonces detachedInstance) {
		log.debug("merging Annonces instance");
		try {
			Annonces result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Annonces findById(int id) {
		log.debug("getting Annonces instance with id: " + id);
		try {
			Annonces instance = entityManager.find(Annonces.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
