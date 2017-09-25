package my.project.service;

import java.util.ArrayList;
import java.util.List;

import my.project.model.Empleado;

public interface EmpleadoService {
	public ArrayList<Empleado> getEmpleados();
	public Empleado getEmpleadoByName(String name);
	public ArrayList<Empleado> buscarCompleto(Empleado e1);

}
