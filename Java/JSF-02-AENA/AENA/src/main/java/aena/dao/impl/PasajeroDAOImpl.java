package aena.dao.impl;

// Generated 19-abr-2015 22:55:28 by Hibernate Tools 4.0.0

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import aena.model.Pasajero;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Pasajero.
 * @see aena.model.Pasajero
 * @author Hibernate Tools
 */
public class PasajeroDAOImpl {

	private static final Log log = LogFactory.getLog(PasajeroDAOImpl.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext()
					.lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Pasajero transientInstance) {
		log.debug("persisting Pasajero instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Pasajero instance) {
		log.debug("attaching dirty Pasajero instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Pasajero instance) {
		log.debug("attaching clean Pasajero instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Pasajero persistentInstance) {
		log.debug("deleting Pasajero instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Pasajero merge(Pasajero detachedInstance) {
		log.debug("merging Pasajero instance");
		try {
			Pasajero result = (Pasajero) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Pasajero findById(int id) {
		log.debug("getting Pasajero instance with id: " + id);
		try {
			Pasajero instance = (Pasajero) sessionFactory.getCurrentSession()
					.get("aena.model.Pasajero", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Pasajero> findByExample(Pasajero instance) {
		log.debug("finding Pasajero instance by example");
		try {
			List<Pasajero> results = (List<Pasajero>) sessionFactory
					.getCurrentSession().createCriteria("aena.model.Pasajero")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
