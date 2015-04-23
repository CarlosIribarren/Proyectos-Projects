package aena.dao;

// Generated 19-abr-2015 22:55:28 by Hibernate Tools 4.0.0

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import aena.model.Avion;
import aena.model.Empleado;
import aena.util.HibernateUtil;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Avion.
 * @see aena.model.Avion
 * @author Hibernate Tools
 */
public interface AvionDAO extends GenericDAO<Avion,Integer>{

	static final Log log = LogFactory.getLog(EmpleadoDAO.class);
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = sessionFactory.openSession();
	
	public void persist(Avion transientInstance);
	public void attachDirty(Avion instance);
	public void attachClean(Avion instance);
	public void delete(Avion persistentInstance);
	public Avion merge(Avion detachedInstance);
	public Avion findById(int id);
	public List<Avion> findByExample(Avion instance);
	public List<Avion> buscarAvionesCaducados();
	public List<Avion> obtenerAvionesRutaSpain();
}
