package aena.dao.impl;

// Generated 19-abr-2015 22:55:28 by Hibernate Tools 4.0.0

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import aena.dao.AvionDAO;
import aena.dao.EmpleadoDAO;
import aena.model.Aeropuerto;
import aena.model.Avion;
import aena.model.Empleado;
import aena.model.Puerta;
import aena.util.HibernateUtil;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Avion.
 * @see aena.model.Avion
 * @author Hibernate Tools
 */
public class AvionDAOImpl extends GenericDAOImpl<Avion, Integer> implements AvionDAO {

	static final Log log = LogFactory.getLog(EmpleadoDAOImpl.class);
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = sessionFactory.openSession();
	
	public void persist(Avion transientInstance) {
		log.debug("persisting Avion instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Avion instance) {
		log.debug("attaching dirty Avion instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Avion instance) {
		log.debug("attaching clean Avion instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Avion persistentInstance) {
		log.debug("deleting Avion instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Avion merge(Avion detachedInstance) {
		log.debug("merging Avion instance");
		try {
			Avion result = (Avion) sessionFactory.getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Avion findById(int id) {
		log.debug("getting Avion instance with id: " + id);
		try {
			Avion instance = (Avion) sessionFactory.getCurrentSession().get(
					"aena.model.Avion", id);
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

	public List<Avion> findByExample(Avion instance) {
		log.debug("finding Avion instance by example");
		try {
			List<Avion> results = (List<Avion>) sessionFactory
					.getCurrentSession().createCriteria("aena.model.Avion")
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
	public List<Avion> buscarAvionesCaducados() {
		Date hoy = new Date(System.currentTimeMillis());
        String sql = "from Avion u where fechaCaducidadLicencia<:hoy";
        Query query = session.createQuery(sql);
        query.setDate("hoy",hoy);
        return (List<Avion>) query.list(); 
	}

	@Override
	public List<Avion> obtenerAvionesRutaSpain() {
		
		/*
		
		//HQL RELACIONES IMPLICITAS
        String sql = "select A.idAvion from AVION as A INNER JOIN VUELO as V INNER JOIN AEROPUERTO as AE WHERE A.idAvion = V.idAvion AND V.idAeropuertoSalida = AE.idAeropuerto AND AE.pais='España'";
                
        Query query = session.createSQLQuery(sql);
        //query.setString("spain","España");
        return (List<Avion>) query.list();
        
        */
		List<Avion> respuesta= new ArrayList<Avion>();
		return respuesta;
	}
}
