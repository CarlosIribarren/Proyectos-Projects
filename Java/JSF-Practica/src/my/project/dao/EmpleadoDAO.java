package my.project.dao;

import java.util.ArrayList;
import java.util.List;

import my.project.model.Empleado;

public interface EmpleadoDAO {
	
	public ArrayList<Empleado> findAll();
	
	public Empleado getById(String id);
	
	public ArrayList<Empleado> findComplex(Empleado e1);
	
	
	public void insertar(Empleado e);
	public void modificar(Empleado e);
	public void eliminar(Empleado e);

}
