package fr.formation.inti.Dao;
// Generated 10 avr. 2019 10:55:56 by Hibernate Tools 5.1.10.Final

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transaction;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import fr.formation.inti.entities.Alerte;
import fr.formation.inti.entities.Alertes;

/**
 * Home object for domain model class Alerte.
 * @see fr.formation.inti.Dao.Alerte
 * @author Hibernate Tools
 */
@Stateless
public class AlertesDao {

	private static final Log log = LogFactory.getLog(AlertesDao.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Alertes transientInstance) {
		log.debug("persisting Alerte instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Alertes persistentInstance) {
		log.debug("removing Alerte instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Alertes merge(Alertes detachedInstance) {
		log.debug("merging Alerte instance");
		try {
			Alertes result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Alertes findById(int id) {
		log.debug("getting Alerte instance with id: " + id);
		try {
			Alertes instance = entityManager.find(Alerte.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public void create (Alertes alrt) {
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			session.persist(object);
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
	} finally {
		if (session != null) {
			session.close();
		}
	}


	public void update(Alertes alrt) {
		
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			session.update(alrt);
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
	public void delete(Alerte alrt) {
	Session session = HibernateUtils.getSessionFactory().getCurrentSession();
	Transaction tx = session.getTransaction();
	try {
		tx.begin();
		session.delete(alrt);
		tx.commit();
	} catch (HibernateException e) {
		log.error(e.getLocalizedMessage());
		if(tx != null) {
			try {
				tx.rollback();
			}catch (Exception e1) {
				log.error("RollBack :" + e.getLocalizedMessage());
			}
				e.printStackTrace();
				
			}finally {
				if(session != null) {
					session.close();
				}
			}
			
			public List<Alertes> getAll() {
				Session session = HibernateUtils.getSessionFactory().getCurrentSession();
				Transaction tx = session.getTransaction();
						List<Employee> employees = null;
				
				try {
					tx.begin();
					employees = session.createQuery("from Alertes).list()"
						tx.commit();
				}catch(HibernateException e) {
					log.error(e.getLocalizedMessage());
					if(tx != null) {
						try {
							tx.rollback();
						} catch(Exception e1) {
							log.error("Rollback :" + e.getLocalizedMessage());
									
						}
					}
					
				e.printStackTrace();
				}finally {
					if(session != null) {
						session.close();
					}
				}
					return alrt;	
				}
				
				
			}
