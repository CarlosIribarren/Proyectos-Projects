package aena.dao;

// Generated 19-abr-2015 22:55:28 by Hibernate Tools 4.0.0

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import aena.model.Aeropuerto;
import aena.model.Puerta;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Puerta.
 * @see aena.model.Puerta
 * @author Hibernate Tools
 */
public interface PuertaDAO extends GenericDAO<Puerta,Integer>{

	static final Log log = LogFactory.getLog(PuertaDAO.class);

	public void persist(Puerta transientInstance);
	public void attachDirty(Puerta instance);

	public void attachClean(Puerta instance);
	public void delete(Puerta persistentInstance);
	public Puerta merge(Puerta detachedInstance);
	
	public Puerta findById(int id);
	public List<Puerta> findByExample(Puerta instance);
	public List<Puerta> findByAeropuerto(Integer id);
	
}
