package my.project.service.impl;

import java.util.ArrayList;
import java.util.List;

import my.project.dao.EmpleadoDAO;
import my.project.dao.impl.EmpleadoDAOImpl;
import my.project.model.Empleado;
import my.project.service.EmpleadoService;

public class EmpleadoServiceImpl implements EmpleadoService{

	private EmpleadoDAO empleadoDAO = new EmpleadoDAOImpl();
	
	public EmpleadoServiceImpl() {
	}
	
	@Override
	public ArrayList<Empleado> getEmpleados() {
		return empleadoDAO.findAll();
	}

	@Override
	public Empleado getEmpleadoByName(String name) {
		return empleadoDAO.getById(name);
	}
	
	public ArrayList<Empleado> buscarCompleto(Empleado e1)
	{
		//--- PREGUNTAR POR CUANTOS CAMPOS SE PUEDE BUSCAR
		//recuperar informacion y montar la sql e
		
		//verificar que el empleado existe
		//buscar el resultado
		return empleadoDAO.findComplex(e1);
		
	}
	

}
