package aena.service;

import aena.dao.EmpleadoDAO;
import aena.dao.impl.EmpleadoDAOImpl;
import aena.model.Empleado;

public class EmpleadoService {
	
	EmpleadoDAO empleadoDAO = new EmpleadoDAOImpl();
	
	public Empleado obtenerEmpleado(String user, String pass)
	{
		//preparar respuesta
		Empleado e = null;
		
		e = empleadoDAO.findByUserPass(user, pass);
		
		return e;
	}
	

}
