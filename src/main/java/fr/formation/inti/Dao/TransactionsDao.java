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
import fr.formation.inti.entities.MotsClefs;
import fr.formation.inti.entities.Transactions;

/**
 * Home object for domain model class Transactions.
 * @see fr.formation.inti.Dao.Transactions
 * @author Hibernate Tools
 */
@Stateless
public class TransactionsDao {

	private static final Log log = LogFactory.getLog(TransactionsDao.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Transactions transientInstance) {
		log.debug("persisting Transactions instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Transactions persistentInstance) {
		log.debug("removing Transactions instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Transactions merge(Transactions detachedInstance) {
		log.debug("merging Transactions instance");
		try {
			Transactions result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Transactions findById(int id) {
		log.debug("getting Transactions instance with id: " + id);
		try {
			Transactions instance = entityManager.find(Transactions.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	public void create (Transactions transactions) {
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			session.create(transactions);
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

	public void update(Transactions transactions) {
			
			Session session = HibernateUtils.getSessionFactory().getCurrentSession();
			Transaction tx = session.getTransaction();
			try {
				tx.begin();
				session.update(transactions);
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

	public void delete(Transactions transactions) {
			Session session = HibernateUtils.getSessionFactory().getCurrentSession();
			Transaction tx = session.getTransaction();
			try {
				tx.begin();
				session.delete(transactions);
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
		public List<Transactions> getAll() {
			Session session = HibernateUtils.getSessionFactory().getCurrentSession();
			Transaction tx = session.getTransaction();
			List<Transactions> transactions = null;
			
			try {
				tx.begin();
				transactions = session.createQuery("from Transactions).list()"
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
			return transactions;
					
		}
			
		}

}
