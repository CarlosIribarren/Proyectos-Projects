package aena.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO <T,Id extends Serializable> {
	
	String insert(T object);
	void save(T object);
	void remove(T object);
	T findById (Id id);
	List<T>findAll();

}
