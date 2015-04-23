package aena.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import aena.dao.GenericDAO;
import aena.util.HibernateUtil;

public abstract class GenericDAOImpl <T, Id extends Serializable> implements GenericDAO<T,Id> {

	private Class<T> claseDePersistencia;
	
	static final Log log = LogFactory.getLog(EmpleadoDAOImpl.class);
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = sessionFactory.openSession();
	
	@SuppressWarnings("unchecked")
	public GenericDAOImpl() {
		this.claseDePersistencia = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		}
	
	@Override
	public String insert(T object) {
		
		String id;
		try{
			session.beginTransaction();
			id=session.save(object).toString();
			session.getTransaction().commit();
			return id;
		}catch(Exception e){
			session.getTransaction().rollback();
			throw e;
		}finally{
			HibernateUtil.getSessionFactory().getCurrentSession().close();
		}	
	}
	
	@Override
	public void save(T object) {
		
		try{
			session.beginTransaction();
			session.update(object);
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			throw e;
		}finally{
			HibernateUtil.getSessionFactory().getCurrentSession().close();
		}
	}
	
	@Override
	public void remove(T object) {
		try{
			session.beginTransaction();
			session.delete(object);
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			throw e;
		}finally{
			HibernateUtil.getSessionFactory().getCurrentSession().close();
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T findById(Id id) {
		
		T object=null;
		try{
			session.beginTransaction();
			object=(T)session.get(claseDePersistencia,id);
			session.getTransaction().commit();
			return object;
		}catch(Exception e){
			session.getTransaction().rollback();
			throw e;
		}finally{
			HibernateUtil.getSessionFactory().getCurrentSession().close();
		}
		
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		
		List<T> listOfObject=null;
		listOfObject = session.createQuery(" from "+claseDePersistencia.getSimpleName()).list(); 
		return listOfObject;
		
	}
	
}
