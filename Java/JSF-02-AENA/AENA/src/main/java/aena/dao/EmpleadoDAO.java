package aena.dao;

// Generated 20-abr-2015 23:40:25 by Hibernate Tools 3.4.0.CR1

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import aena.model.Empleado;
import aena.util.HibernateUtil;

public interface EmpleadoDAO extends GenericDAO<Empleado,Integer>{

	static final Log log = LogFactory.getLog(EmpleadoDAO.class);
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = sessionFactory.openSession();
	

	public void persist(Empleado transientInstance);
	public void attachDirty(Empleado instance);
	public void attachClean(Empleado instance);
	public void delete(Empleado persistentInstance);
	public Empleado merge(Empleado detachedInstance);
	public Empleado findById(int id);	
	public Empleado findByUserPass(String user_aldagaia, String pass_aldagaia);	
	public List<Empleado> findByExample(Empleado instance);
}
