package es.flota.Grupo;

import java.io.Serializable;
import java.util.ArrayList;

import es.flota.DB.GestorDB;

public class Grupo implements Serializable {

	private static final long serialVersionUID = -2443268121939311636L;
	
	private String nombre;
	private ArrayList<Empresa> listaEmpresas = new ArrayList<Empresa>();
	private ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();

	public Grupo(String nombre) {
		super();
		this.nombre = nombre;
	}
	
//------------- METODOS DE LA CLASE ----------------
	
	public ArrayList<Empleado> buscarEmpleadosDisponibles()
	{
		ArrayList<Empleado> listaEmlpleadosDisponibles = new ArrayList<Empleado>();

		ArrayList<Empresa> listaEmpresas = this.getListaEmpresas();
		for(Empresa e : listaEmpresas)
		{
			ArrayList<Departamento> listaDepartamentos = e.getListaDepartamentos();
			for(Departamento d : listaDepartamentos)
			{
				ArrayList<Empleado> listaEmpleados = d.getListaEmpleados();
				for(Empleado empleado : listaEmpleados){
					//seleccionar solo los empleados libres
					if (empleado.getVehiculoAsignado()==null)
					{	
						//guardar en la List
						listaEmlpleadosDisponibles.add(empleado);	
					}
				}
			}
		}
		return listaEmlpleadosDisponibles;
	}
	
	public void añadirVehiculo(Vehiculo v)
	{
		vehiculos.add(v);
		GestorDB.getInstance().añadirLog("Vehiculo [ " + v.getClass().getSimpleName() + v.getMatricula() + " ] añadido.");
		GestorDB.getInstance().guardarBD();
	}
	public Boolean eliminarVehiculo(Vehiculo v)
	{
		Boolean accion = vehiculos.remove(v);
		if ( accion==true)
		{
			GestorDB.getInstance().añadirLog("Vehiculo [ " + v.getClass().getSimpleName() + v.getMatricula() + " ] borrado.");
		}
		else
		{
			GestorDB.getInstance().añadirLog("Error al borrar el vehiculo [ " + v.getClass().getSimpleName() + v.getMatricula() + " ].");	
		}
		GestorDB.getInstance().guardarBD();
		return accion;
	}
	public Empresa obtenerEmpresa(Integer index)
	{
		int indexInt = index;
		return listaEmpresas.get(indexInt);
	}
	public Vehiculo obtenerVehiculo(Integer index)
	{
		int indexInt = index;
		return vehiculos.get(indexInt);
	}
	public void añadirEmpresa(Empresa e1)
	{
		listaEmpresas.add(e1);
		GestorDB.getInstance().añadirLog("Empresa [ " + e1.getNombre() + " ] añadida.");
		GestorDB.getInstance().guardarBD();
	}
	public boolean eliminarEmpresa(Empresa e1)
	{
		Boolean accion = listaEmpresas.remove(e1);
		if (accion==true)
		{
			GestorDB.getInstance().añadirLog("Empresa [ " + e1.getNombre() + " ] borrada.");
		}
		else
		{
			GestorDB.getInstance().añadirLog("Error al borrar la empresa [ " + e1.getNombre() + " ].");	
		}
		GestorDB.getInstance().guardarBD();
		return accion;
	}
	public void cambiarNombre(String nombreGrupo)
	{
		String nombreViejo = this.getNombre();
		this.setNombre(nombreGrupo);
		GestorDB.getInstance().añadirLog("El Grupo [ " + nombreViejo + " ] ha sido modificado por [ " + nombreGrupo +" ].");
		GestorDB.getInstance().guardarBD();
	}




	//------- GETTER Y SETTER ----------------------


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Empresa> getListaEmpresas() {
		return listaEmpresas;
	}

	public void setListaEmpresas(ArrayList<Empresa> listaEmpresas) {
		this.listaEmpresas = listaEmpresas;
	}


	public ArrayList<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}


	//------- TO STRING ----------------------
	@Override
	public String toString() {
		return "Grupo : "+ nombre + " \nlistaEmpresas :" + listaEmpresas
				+ "]";
	}
	
	//------- HASHCODE Y EQUALS ----------------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((listaEmpresas == null) ? 0 : listaEmpresas.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result
				+ ((vehiculos == null) ? 0 : vehiculos.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grupo other = (Grupo) obj;
		if (listaEmpresas == null) {
			if (other.listaEmpresas != null)
				return false;
		} else if (!listaEmpresas.equals(other.listaEmpresas))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (vehiculos == null) {
			if (other.vehiculos != null)
				return false;
		} else if (!vehiculos.equals(other.vehiculos))
			return false;
		return true;
	}
}
