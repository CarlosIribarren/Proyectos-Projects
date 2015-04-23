package aena.dao;

// Generated 19-abr-2015 22:55:28 by Hibernate Tools 4.0.0

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import aena.model.Reserva;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Reserva.
 * @see aena.model.Reserva
 * @author Hibernate Tools
 */
public class ReservaDAO {

	private static final Log log = LogFactory.getLog(ReservaDAO.class);

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

	public void persist(Reserva transientInstance) {
		log.debug("persisting Reserva instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Reserva instance) {
		log.debug("attaching dirty Reserva instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Reserva instance) {
		log.debug("attaching clean Reserva instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Reserva persistentInstance) {
		log.debug("deleting Reserva instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Reserva merge(Reserva detachedInstance) {
		log.debug("merging Reserva instance");
		try {
			Reserva result = (Reserva) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Reserva findById(int id) {
		log.debug("getting Reserva instance with id: " + id);
		try {
			Reserva instance = (Reserva) sessionFactory.getCurrentSession()
					.get("aena.model.Reserva", id);
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

	public List<Reserva> findByExample(Reserva instance) {
		log.debug("finding Reserva instance by example");
		try {
			List<Reserva> results = (List<Reserva>) sessionFactory
					.getCurrentSession().createCriteria("aena.model.Reserva")
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
