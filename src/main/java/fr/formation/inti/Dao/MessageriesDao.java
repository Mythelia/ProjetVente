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
import fr.formation.inti.entities.Messageries;

/**
 * Home object for domain model class Messageries.
 * @see fr.formation.inti.Dao.Messageries
 * @author Hibernate Tools
 */
@Stateless
public class MessageriesDao {

	private static final Log log = LogFactory.getLog(MessageriesDao.class);

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

	public void create (Messageries messageries) {
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
	}finally

	{
		if (session != null) {
			session.close();
		}

	public void update(Messageries messageries) {
			
			Session session = HibernateUtils.getSessionFactory().getCurrentSession();
			Transaction tx = session.getTransaction();
			try {
				tx.begin();
				session.update(messageries);
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

	public void delete(Messageries messageries) {
			Session session = HibernateUtils.getSessionFactory().getCurrentSession();
			Transaction tx = session.getTransaction();
			try {
				tx.begin();
				session.delete(messageries);
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
		public List<Annonces> getAll() {
			Session session = HibernateUtils.getSessionFactory().getCurrentSession();
			Transaction tx = session.getTransaction();
			List<Annonces> annonces = null;
			
			try {
				tx.begin();
				annonces = session.createQuery("from Annonces).list()"
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
			return annonces;
					
		}
			
}
