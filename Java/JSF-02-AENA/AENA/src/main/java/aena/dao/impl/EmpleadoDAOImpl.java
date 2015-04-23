package aena.dao.impl;

// Generated 20-abr-2015 23:40:25 by Hibernate Tools 3.4.0.CR1

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import aena.dao.EmpleadoDAO;
import aena.model.Empleado;
import aena.util.HibernateUtil;

public class EmpleadoDAOImpl extends GenericDAOImpl<Empleado, Integer> implements EmpleadoDAO {

	static final Log log = LogFactory.getLog(EmpleadoDAOImpl.class);
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = sessionFactory.openSession();
	
	public void persist(Empleado transientInstance) {
		log.debug("persisting Empleado instance");
		try {
			 
			session.beginTransaction();
			session.persist(transientInstance);
			session.getTransaction().commit();
			
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Empleado instance) {
		log.debug("attaching dirty Empleado instance");
		try {
			
			session.beginTransaction();
			session.saveOrUpdate(instance);
			session.getTransaction().commit();
	
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Empleado instance) {
		log.debug("attaching clean Empleado instance");
		try {
			
			
			session.lock(instance, LockMode.NONE);
			
			
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Empleado persistentInstance) {
		log.debug("deleting Empleado instance");
		try {
			
			session.beginTransaction();
			session.delete(persistentInstance);
			session.getTransaction().commit();
	
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Empleado merge(Empleado detachedInstance) {
		log.debug("merging Empleado instance");
		try {
			
			session.beginTransaction();
			Empleado result = (Empleado)session.merge(detachedInstance);
			session.getTransaction().commit();
					
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Empleado findById(int id) {
		log.debug("getting Empleado instance with id: " + id);
		try {
			

			session.beginTransaction();
			Empleado instance = (Empleado)session.get("aena.model.Empleado", id);
			session.getTransaction().commit();
			
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
	
	public Empleado findByUserPass(String user_aldagaia, String pass_aldagaia) 
	{    
        String sql = "select u from Empleado u where user=:user_aldagaia and pass=:pass_aldagaia";
        Query query = session.createQuery(sql);
        query.setString("user_aldagaia",user_aldagaia);
        query.setString("pass_aldagaia",pass_aldagaia);
        return (Empleado) query.uniqueResult(); 
	}
	
	

	public List<Empleado> findByExample(Empleado instance) {
		log.debug("finding Empleado instance by example");
		try {
			List<Empleado> results = (List<Empleado>) session.createCriteria("aena.model.Empleado")
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
