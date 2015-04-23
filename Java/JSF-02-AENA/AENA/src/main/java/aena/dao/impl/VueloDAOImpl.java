package aena.dao.impl;

// Generated 19-abr-2015 22:55:28 by Hibernate Tools 4.0.0

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import aena.dao.EmpleadoDAO;
import aena.dao.VueloDAO;
import aena.model.Aeropuerto;
import aena.model.Empleado;
import aena.model.Puerta;
import aena.model.Vuelo;
import aena.util.HibernateUtil;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Vuelo.
 * @see aena.model.Vuelo
 * @author Hibernate Tools
 */
public class VueloDAOImpl extends GenericDAOImpl<Vuelo, Integer> implements VueloDAO {

	private static final Log log = LogFactory.getLog(PuertaDAOImpl.class);

	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = sessionFactory.openSession();

	public void persist(Vuelo transientInstance) {
		log.debug("persisting Vuelo instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Vuelo instance) {
		log.debug("attaching dirty Vuelo instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Vuelo instance) {
		log.debug("attaching clean Vuelo instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Vuelo persistentInstance) {
		log.debug("deleting Vuelo instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Vuelo merge(Vuelo detachedInstance) {
		log.debug("merging Vuelo instance");
		try {
			Vuelo result = (Vuelo) sessionFactory.getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Vuelo findById(int id) {
		log.debug("getting Vuelo instance with id: " + id);
		try {
			Vuelo instance = (Vuelo) sessionFactory.getCurrentSession().get(
					"aena.model.Vuelo", id);
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

	public List<Vuelo> findByExample(Vuelo instance) {
		log.debug("finding Vuelo instance by example");
		try {
			List<Vuelo> results = (List<Vuelo>) sessionFactory
					.getCurrentSession().createCriteria("aena.model.Vuelo")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}


	@Override
	public List<Vuelo> buscarTodos() {
        String sql = "from Vuelo";
        Query query = session.createQuery(sql);
        return (List<Vuelo>)query.list();
	}
}
