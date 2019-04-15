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

/**
 * Home object for domain model class MotsClefs.
 * @see fr.formation.inti.Dao.MotsClefs
 * @author Hibernate Tools
 */
@Stateless
public class MotsClefsDao {

	private static final Log log = LogFactory.getLog(MotsClefsDao.class);

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
	public void create (MotsClefs motsclefs) {
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			session.create(motsclefs);
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

	public void update(MotsClefs motsclefs) {
			
			Session session = HibernateUtils.getSessionFactory().getCurrentSession();
			Transaction tx = session.getTransaction();
			try {
				tx.begin();
				session.update(motsclefs);
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

	public void delete(MotsClefs motsclefs) {
			Session session = HibernateUtils.getSessionFactory().getCurrentSession();
			Transaction tx = session.getTransaction();
			try {
				tx.begin();
				session.delete(motsclefs);
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
		public List<MotsClefs> getAll() {
			Session session = HibernateUtils.getSessionFactory().getCurrentSession();
			Transaction tx = session.getTransaction();
			List<MotsClefs> motsclefs = null;
			
			try {
				tx.begin();
				motsclefs = session.createQuery("from MotsClefs).list()"
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
			return motsclefs;
					
		}
			
		}

}
