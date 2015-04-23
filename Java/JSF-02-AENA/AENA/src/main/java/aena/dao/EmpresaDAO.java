package aena.dao;

// Generated 19-abr-2015 22:55:28 by Hibernate Tools 4.0.0

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import aena.model.Empresa;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Empresa.
 * @see aena.model.Empresa
 * @author Hibernate Tools
 */
public class EmpresaDAO {

	private static final Log log = LogFactory.getLog(EmpresaDAO.class);

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

	public void persist(Empresa transientInstance) {
		log.debug("persisting Empresa instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Empresa instance) {
		log.debug("attaching dirty Empresa instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Empresa instance) {
		log.debug("attaching clean Empresa instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Empresa persistentInstance) {
		log.debug("deleting Empresa instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Empresa merge(Empresa detachedInstance) {
		log.debug("merging Empresa instance");
		try {
			Empresa result = (Empresa) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Empresa findById(int id) {
		log.debug("getting Empresa instance with id: " + id);
		try {
			Empresa instance = (Empresa) sessionFactory.getCurrentSession()
					.get("aena.model.Empresa", id);
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

	public List<Empresa> findByExample(Empresa instance) {
		log.debug("finding Empresa instance by example");
		try {
			List<Empresa> results = (List<Empresa>) sessionFactory
					.getCurrentSession().createCriteria("aena.model.Empresa")
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
