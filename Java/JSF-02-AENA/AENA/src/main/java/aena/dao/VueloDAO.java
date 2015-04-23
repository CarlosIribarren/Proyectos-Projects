package aena.dao;

// Generated 19-abr-2015 22:55:28 by Hibernate Tools 4.0.0

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import aena.model.Empleado;
import aena.model.Vuelo;
import aena.util.HibernateUtil;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Vuelo.
 * @see aena.model.Vuelo
 * @author Hibernate Tools
 */
public interface VueloDAO extends GenericDAO<Vuelo,Integer>{

	static final Log log = LogFactory.getLog(EmpleadoDAO.class);
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = sessionFactory.openSession();

	public void persist(Vuelo transientInstance);
	public void attachDirty(Vuelo instance);
	public void attachClean(Vuelo instance);
	public void delete(Vuelo persistentInstance);
	public Vuelo merge(Vuelo detachedInstance);
	public Vuelo findById(int id);
	public List<Vuelo> findByExample(Vuelo instance);
	public List<Vuelo> buscarTodos();
	
}
