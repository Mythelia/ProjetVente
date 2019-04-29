package fr.formation.inti.Dao;
// Generated 10 avr. 2019 10:55:56 by Hibernate Tools 5.1.10.Final

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.formation.inti.entities.Messages;
import fr.formation.inti.entities.Utilisateurs;
import fr.formation.inti.interfaces.dao.IMessagesDao;

@Repository("MessageDao")
public class MessagesDao implements IMessagesDao {

	@Autowired
	private SessionFactory sessionFactory;

	private static final Log log = LogFactory.getLog(MessagesDao.class);

	public Messages findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Messages instance;
		try {
			instance = (Messages) session.get(Messages.class, id);
			return instance;
		} catch (HibernateException e) {
			log.error(e.getLocalizedMessage());

			return null;
		}

	}

	public void create(Messages messages) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.persist(messages);
		} catch (HibernateException e) {
			log.error(e.getLocalizedMessage());

		}
	}

	public void update(Messages messages) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(messages);

		} catch (HibernateException e) {
			log.error(e.getLocalizedMessage());

		}
	}

	public void delete(Messages messages) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.delete(messages);

		} catch (HibernateException e) {
			log.error(e.getLocalizedMessage());

		}
	}

	public List<Messages> getAll() {
		Session session = sessionFactory.getCurrentSession();
		try {
			List<Messages> list = session.createQuery("from Messages").list();
			return list;
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
			return null;
		}

	}

	public List<Messages> getMessagesByUtilisateur(Utilisateurs utlisateur) {

		Set<Messages> set = utlisateur.getMessagesesForIdUtilisateurReceveur();
		List<Messages> items = new ArrayList<>();
		for (Messages messages : set) {

			items.add(messages);

		}

		return items;

	}

}