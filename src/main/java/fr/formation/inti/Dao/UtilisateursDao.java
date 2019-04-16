package fr.formation.inti.Dao;
// Generated 10 avr. 2019 10:55:56 by Hibernate Tools 5.1.10.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transaction;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import fr.formation.inti.entities.Annonces;
import fr.formation.inti.entities.Utilisateurs;

/**
 * Home object for domain model class Utilisateurs.
 * 
 * @see fr.formation.inti.Dao.Utilisateurs
 * @author Hibernate Tools
 */
@Stateless
public class UtilisateursDao {

	private static final Log log = LogFactory.getLog(UtilisateursDao.class);

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

	public void create (Utilisateurs utilisateurs) {
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			session.create(utilisateurs);
			tx.commit();
			} catch (HibernateException e) {
				log.error(e.getLocalizedMessage());
				if(tx !=null)
					try {
						tx.rollback();
					} catch (Exception e1) {
						log.error("Rollback :" + e.getLocalizedMessage());
					}
			}
		e.printStackTrace();
	}finally

	{
		if (session != null) {
			session.close();
		}

	public void update(Utilisateurs utilisateurs) {
			
			Session session = HibernateUtils.getSessionFactory().getCurrentSession();
			Transaction tx = session.getTransaction();
			try {
				tx.begin();
				session.update(utilisateurs);
				tx.commit();
			} catch (HibernateException e) {
				log.error(e.getLocalizedMessage());
				if (tx != null) {
					try {
						tx.rollback();
					} catch (Exception e1) {
						log.error("RollBack :" + e.getLocalizedMessage());
					}
				}
				e.printStackTrace();
			} finally {
				if (session != null) {
					session.close();
	}

	public void delete(Utilisateurs utilisateurs) {
			Session session = HibernateUtils.getSessionFactory().getCurrentSession();
			Transaction tx = session.getTransaction();
			try {
				tx.begin();
				session.delete(utilisateurs);
				tx.commit();
			} catch (HibernateException e) {
				log.error(e.getLocalizedMessage());
				if(tx != null) {
					try {
						tx.rollback();
					}catch (Exception e1) {
						log.error("Rollback :"+ e.getLocalizedMessage());
					}
					e.printStackTrace();
					}finally {
						if(session != null) {
							session.close();
						}
					}

	public List<Utilisateurs> getAll() {
			Session session = HibernateUtils.getSessionFactory().getCurrentSession();
			Transaction tx = session.getTransaction();
			List<Utilisateurs> annonces = null;
			
			try {
				tx.begin();
				utilisateurs = session.createQuery("from Utilisateurs).list()"
				tx.commit();
				
			}catch(HibernateException e) {
				log.error(e.getLocalizedMessage());
				if(tx != null) {
					try {
						tx.rollback();
					}catch(Exception e1) {
						log.error("Rollback:"+e.getLocalizedMessage());
					}
					}
				e.printStackTrace();
			}finally {
				if(session != null) {
					session.close();
				}
			}
			return utilisateurs;
			
		
}
}
