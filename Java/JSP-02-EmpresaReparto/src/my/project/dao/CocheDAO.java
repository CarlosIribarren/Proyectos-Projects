package my.project.dao;

import java.util.ArrayList;
import java.util.List;

import my.project.model.Coche;
import my.project.model.Empleado;

public interface CocheDAO  {
	
	public List<Coche> findAll();
	public Coche getById(String id);
	
	public void insertarCoche(Coche c);
	public ArrayList<Coche> obtenerCochesPorEmpresaID(Integer id);
	
	public Integer obtenerMaxID();
	
	
}
