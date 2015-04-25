package my.project.service.impl;

import java.util.List;

import my.project.dao.EmpleadoDAO;
import my.project.dao.impl.EmpleadoDAOImpl;
import my.project.model.Empleado;
import my.project.service.EmpleadoService;

public class EmpleadoServiceImpl implements EmpleadoService{

	private EmpleadoDAO empleadoDAO = new EmpleadoDAOImpl();
	
	public EmpleadoServiceImpl() {
	}


}
