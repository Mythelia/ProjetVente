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

import fr.formation.inti.entities.Messages;

/**
 * Home object for domain model class Messages.
 * @see fr.formation.inti.Dao.Messages
 * @author Hibernate Tools
 */
@Stateless
public class MessagesDao {

	private static final Log log = LogFactory.getLog(MessagesDao.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Messages transientInstance) {
		log.debug("persisting Messages instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Messages persistentInstance) {
		log.debug("removing Messages instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Messages merge(Messages detachedInstance) {
		log.debug("merging Messages instance");
		try {
			Messages result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Messages findById(int id) {
		log.debug("getting Messages instance with id: " + id);
		try {
			Messages instance = entityManager.find(Messages.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	public void create (Messages messages) {
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			session.create(object);
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

	public void update(Messages messages) {
			
			Session session = HibernateUtils.getSessionFactory().getCurrentSession();
			Transaction tx = session.getTransaction();
			try {
				tx.begin();
				session.update(messages);
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

	public void delete(Messages messages) {
			Session session = HibernateUtils.getSessionFactory().getCurrentSession();
			Transaction tx = session.getTransaction();
			try {
				tx.begin();
				session.delete(messages);
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
		public List<Messages> getAll() {
			Session session = HibernateUtils.getSessionFactory().getCurrentSession();
			Transaction tx = session.getTransaction();
			List<Messages> messages = null;
			
			try {
				tx.begin();
				messages = session.createQuery("from Annonces).list()"
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
			return messages;
					
		}
			
		}

}
