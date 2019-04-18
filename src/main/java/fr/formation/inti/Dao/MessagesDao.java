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
import org.hibernate.SessionFactory;

import fr.formation.inti.entities.Messageries;
import fr.formation.inti.entities.Messages;
import fr.formation.inti.interfaces.dao.IMessagesDao;

/**
 * Home object for domain model class Messages.
 * @see fr.formation.inti.Dao.Messages
 * @author Hibernate Tools
 */
@Stateless
public class MessagesDao implements IMessagesDao{

	//@Autowired
    private SessionFactory sessionFactory;
	
	private static final Log log = LogFactory.getLog(MessagesDao.class);

	
	public Messages findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Messages instance;
		try {
			session.getTransaction().begin();
			instance = (Messages) session.get(Messages.class, id);
			session.getTransaction().commit();
			return instance;
		} catch (HibernateException e) {
			log.error(e.getLocalizedMessage());
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
			return null;
		} finally {
			if (session.isConnected() != false) {
				session.close();
			}
		}
	}
	public void create(Messages messages) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.getTransaction().begin();
session.persist(messages);
session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error(e.getLocalizedMessage());
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
		} finally {
			if (session.isConnected() != false) {
				session.close();
			}
		}
	}
	public void update(Messages messages) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.getTransaction().begin();
session.update(messages);
session.getTransaction().commit();

		} catch (HibernateException e) {
			log.error(e.getLocalizedMessage());
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
		} finally {
			if (session.isConnected() != false) {
				session.close();
			}
		}
	}
	public void delete(Messages messages) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.getTransaction().begin();
session.delete(messages);
session.getTransaction().commit();

		} catch (HibernateException e) {
			log.error(e.getLocalizedMessage());
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
		} finally {
			if (session.isConnected() != false) {
				session.close();
			}
		}
	}
	public List<Messages> getAll() {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.getTransaction().begin();
			List<Messages> list = session.createQuery("from Messages").list();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
			return null;
		} finally {
			if (session.isConnected() != false) {
				session.close();
			}
		}

	}

}