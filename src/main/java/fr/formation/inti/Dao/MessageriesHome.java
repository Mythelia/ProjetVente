package fr.formation.inti.Dao;
// Generated 10 avr. 2019 10:55:56 by Hibernate Tools 5.1.10.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.formation.inti.entities.Messageries;

/**
 * Home object for domain model class Messageries.
 * @see fr.formation.inti.Dao.Messageries
 * @author Hibernate Tools
 */
@Stateless
public class MessageriesHome {

	private static final Log log = LogFactory.getLog(MessageriesHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Messageries transientInstance) {
		log.debug("persisting Messageries instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Messageries persistentInstance) {
		log.debug("removing Messageries instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Messageries merge(Messageries detachedInstance) {
		log.debug("merging Messageries instance");
		try {
			Messageries result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Messageries findById(int id) {
		log.debug("getting Messageries instance with id: " + id);
		try {
			Messageries instance = entityManager.find(Messageries.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
