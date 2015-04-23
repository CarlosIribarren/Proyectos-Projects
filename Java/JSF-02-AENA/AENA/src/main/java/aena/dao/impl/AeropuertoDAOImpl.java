package aena.dao.impl;

// Generated 19-abr-2015 22:55:28 by Hibernate Tools 4.0.0

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import aena.dao.AeropuertoDAO;
import aena.dao.EmpleadoDAO;
import aena.model.Aeropuerto;
import aena.model.Empleado;
import aena.util.HibernateUtil;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Aeropuerto.
 * @see aena.model.Aeropuerto
 * @author Hibernate Tools
 */
public class AeropuertoDAOImpl  extends GenericDAOImpl<Aeropuerto, Integer> implements AeropuertoDAO {

	private static final Log log = LogFactory.getLog(EmpresaDAOImpl.class);

	private final SessionFactory sessionFactory =  HibernateUtil.getSessionFactory();

	public void persist(Aeropuerto transientInstance) {
		log.debug("persisting Aeropuerto instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Aeropuerto instance) {
		log.debug("attaching dirty Aeropuerto instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Aeropuerto instance) {
		log.debug("attaching clean Aeropuerto instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Aeropuerto persistentInstance) {
		log.debug("deleting Aeropuerto instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Aeropuerto merge(Aeropuerto detachedInstance) {
		log.debug("merging Aeropuerto instance");
		try {
			Aeropuerto result = (Aeropuerto) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Aeropuerto findById(int id) {
		log.debug("getting Aeropuerto instance with id: " + id);
		try {
			Aeropuerto instance = (Aeropuerto) sessionFactory.getCurrentSession().get("aena.model.Aeropuerto", id);
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

	public List<Aeropuerto> findByExample(Aeropuerto instance) {
		log.debug("finding Aeropuerto instance by example");
		try {
			List<Aeropuerto> results = (List<Aeropuerto>) sessionFactory.getCurrentSession().createCriteria("aena.model.Aeropuerto")
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
	public List<Aeropuerto> obtenerAeropuertos() {
		
        String sql = "from Aeropuerto";
        Query query = session.createQuery(sql);
        return (List<Aeropuerto>)query.list();
        
	}
}
