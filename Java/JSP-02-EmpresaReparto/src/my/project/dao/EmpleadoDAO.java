package my.project.dao;

import java.util.ArrayList;
import java.util.List;

import my.project.model.Empleado;

public interface EmpleadoDAO {
	public List<Empleado> findAll();
	public Empleado getById(String id);
	
	public void insertEmpleado(Empleado e);
	public void updateEmpleado(Empleado e);
	public void deleteEmpleado(Empleado e);
	
	public ArrayList<Empleado> obtenerEmpleadosPorEmpresaID(Integer id);
	
}
