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

import aena.dao.AeropuertoDAO;
import aena.dao.PuertaDAO;
import aena.model.Aeropuerto;
import aena.model.Empleado;
import aena.model.Puerta;
import aena.util.HibernateUtil;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Puerta.
 * @see aena.model.Puerta
 * @author Hibernate Tools
 */
public class PuertaDAOImpl  extends GenericDAOImpl<Puerta, Integer> implements PuertaDAO {

	private static final Log log = LogFactory.getLog(PuertaDAOImpl.class);

	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = sessionFactory.openSession();

	public void persist(Puerta transientInstance) {
		log.debug("persisting Puerta instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Puerta instance) {
		log.debug("attaching dirty Puerta instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Puerta instance) {
		log.debug("attaching clean Puerta instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Puerta persistentInstance) {
		log.debug("deleting Puerta instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Puerta merge(Puerta detachedInstance) {
		log.debug("merging Puerta instance");
		try {
			Puerta result = (Puerta) sessionFactory.getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Puerta findById(int id) {
		log.debug("getting Puerta instance with id: " + id);
		try {
			Puerta instance = (Puerta) sessionFactory.getCurrentSession().get(
					"aena.model.Puerta", id);
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

	public List<Puerta> findByExample(Puerta instance) {
		log.debug("finding Puerta instance by example");
		try {
			List<Puerta> results = (List<Puerta>) sessionFactory
					.getCurrentSession().createCriteria("aena.model.Puerta")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	//Obtener las puertas disponibles de un aeropuerto en concreto
	public List<Puerta> findByAeropuerto(Integer id)
	{
		String estadoDisponible = "Disponible";
        String sql = "from Puerta u where aeropuerto.idAeropuerto=:id and estado=:estadoDisponible";
        Query query = session.createQuery(sql);
        query.setInteger("id",id);
        query.setString("estadoDisponible",estadoDisponible);
        return (List<Puerta>) query.list(); 
	}

	
}
