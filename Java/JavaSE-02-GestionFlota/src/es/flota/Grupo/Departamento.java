package es.flota.Grupo;

import java.io.Serializable;
import java.util.ArrayList;

import es.flota.DB.GestorDB;

public class Departamento implements Serializable {

	private static final long serialVersionUID = -8844377768349854987L;
	
	private String nombre;
	private String codigo;
	private ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();
	//doble union
	private Empresa empresaPadre;
	
	public Departamento( String codigo, String nombre, Empresa empresaPadre ) {
		super();
		this.empresaPadre=empresaPadre;
		this.nombre = nombre;
		this.codigo = codigo;
	}
	
	//------------- METODOS DE LA CLASE ----------------
	public ArrayList<Empleado> buscarEmpleadosOcupados()
	{
		ArrayList<Empleado> listaEmlpleadosOcupados = new ArrayList<Empleado>();

		ArrayList<Empleado> listaEmpleados = this.listaEmpleados;
		for(Empleado empleado : listaEmpleados){
			//seleccionar solo los empleados libres
			if (empleado.getVehiculoAsignado()!=null)
			{	
				//guardar en la List
				listaEmlpleadosOcupados.add(empleado);	
			}
		}
		return listaEmlpleadosOcupados;
	}
	public ArrayList<Empleado> buscarEmpleadosDisponibles()
	{
		ArrayList<Empleado> listaEmlpleadosDisponibles = new ArrayList<Empleado>();

		ArrayList<Empleado> listaEmpleados = this.listaEmpleados;
		for(Empleado empleado : listaEmpleados){
			//seleccionar solo los empleados libres
			if (empleado.getVehiculoAsignado()==null)
			{	
				//guardar en la List
				listaEmlpleadosDisponibles.add(empleado);	
			}
		}
		return listaEmlpleadosDisponibles;
	}
	public Empleado obtenerEmpleado(Integer index)
	{
		int indexInt = index;
		return listaEmpleados.get(indexInt);
	}
	public void añadirEmpleado(Empleado e1)
	{
		listaEmpleados.add(e1);
		GestorDB.getInstance().añadirLog("Empleado [ " + e1.getNombre() + " ] añadido.");
		GestorDB.getInstance().guardarBD();
	}
	public Boolean borrarEmpleado(Empleado e1)
	{
		Boolean accion = listaEmpleados.remove(e1);
		if ( accion==true)
		{
			GestorDB.getInstance().añadirLog("Empleado [ " + e1.getNombre() + " ] eliminado.");
		}
		else
		{
			GestorDB.getInstance().añadirLog("Error al borrar el Empleado [ " + e1.getNombre() + " ].");
		}
		GestorDB.getInstance().guardarBD();
		return accion;
	}


	//------- GETTER Y SETTER ----------------------
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public ArrayList<Empleado> getListaEmpleados() {
		return listaEmpleados;
	}
	public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}
	public Empresa getEmpresaPadre() {
		return empresaPadre;
	}

	public void setEmpresaPadre(Empresa empresaPadre) {
		this.empresaPadre = empresaPadre;
	}
	
	//------- HASHCODE Y EQUALS ----------------------
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result
				+ ((empresaPadre == null) ? 0 : empresaPadre.hashCode());
		result = prime * result
				+ ((listaEmpleados == null) ? 0 : listaEmpleados.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Departamento other = (Departamento) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (empresaPadre == null) {
			if (other.empresaPadre != null)
				return false;
		} else if (!empresaPadre.equals(other.empresaPadre))
			return false;
		if (listaEmpleados == null) {
			if (other.listaEmpleados != null)
				return false;
		} else if (!listaEmpleados.equals(other.listaEmpleados))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}


	
	
	
}
