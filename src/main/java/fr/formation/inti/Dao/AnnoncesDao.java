package fr.formation.inti.Dao;
// Generated 10 avr. 2019 10:55:56 by Hibernate Tools 5.1.10.Final

import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.formation.inti.entities.Annonces;
import fr.formation.inti.entities.MotsClefs;
import fr.formation.inti.interfaces.dao.IAnnoncesDao;
import fr.formation.inti.interfaces.services.IMotsClefsService;

/**
 * Home object for domain model class Annonces.
 * 
 * @see fr.formation.inti.Dao.Annonces
 * @author Hibernate Tools
 */
@Repository("AnnonceDao")
public class AnnoncesDao implements IAnnoncesDao {

	 @Autowired
	 private SessionFactory sessionFactory;
	 
	 @Autowired
	 private IMotsClefsService motsClefsServices;

	private static final Log log = LogFactory.getLog(AnnoncesDao.class);

	public Annonces findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Annonces instance;
		try {
			instance = (Annonces) session.get(Annonces.class, id);
			return instance;
		} catch (HibernateException e) {
			log.error(e.getLocalizedMessage());

			return null;
		}

	}

	public void create(Annonces annonces) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.persist(annonces);
		} catch (HibernateException e) {
			log.error(e.getLocalizedMessage());

		}
	}

	public void update(Annonces annonces) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(annonces);
		} catch (HibernateException e) {
			log.error(e.getLocalizedMessage());

		}
	}

	public void delete(Annonces annonces) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.delete(annonces);
		} catch (HibernateException e) {
			log.error(e.getLocalizedMessage());
			
		}
	}

	public List<Annonces> getAll() {
		Session session = sessionFactory.getCurrentSession();
		try {
			List<Annonces> list = session.createQuery("from Annonces").list();
			return list;
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());

			return null;

		}

	}
	
	public Set<Annonces> getAnnoncesByMotClef(String motClef) {
	
		MotsClefs mc = motsClefsServices.findByMotClef(motClef);
		return mc.getAnnonceses();
		
		
	}

}
