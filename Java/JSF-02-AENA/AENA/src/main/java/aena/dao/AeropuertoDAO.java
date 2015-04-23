package aena.dao;

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import aena.model.Aeropuerto;
import aena.model.Empleado;
import aena.util.HibernateUtil;
import static org.hibernate.criterion.Example.create;


public interface AeropuertoDAO extends GenericDAO<Aeropuerto,Integer>{

	static final Log log = LogFactory.getLog(AeropuertoDAO.class);

	public void persist(Aeropuerto transientInstance);
	public void attachDirty(Aeropuerto instance);
	public void attachClean(Aeropuerto instance) ;
	public void delete(Aeropuerto persistentInstance);
	public Aeropuerto merge(Aeropuerto detachedInstance);
	public Aeropuerto findById(int id);
	public List<Aeropuerto> findByExample(Aeropuerto instance);
	
	public List<Aeropuerto> obtenerAeropuertos();
}
