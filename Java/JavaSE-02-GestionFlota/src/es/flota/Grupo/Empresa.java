package es.flota.Grupo;

import java.io.Serializable;
import java.util.ArrayList;

import es.flota.DB.GestorDB;

public class Empresa implements Serializable{

	private static final long serialVersionUID = -332649780554337318L;
	
	private String nombre;
	private String direccion;
	private ArrayList<Departamento> listaDepartamentos = new ArrayList<Departamento>();
	//doble union
	private Grupo grupoPadre;

	public Empresa(String nombre, String direccion, Grupo grupoPadre) {
		super();
		this.grupoPadre=grupoPadre;
		this.nombre = nombre;
		this.direccion = direccion;
	}
	//------------- METODOS DE LA CLASE ----------------
	public Departamento obtenerDepartamento(Integer index)
	{
		int indexInt = index;
		return listaDepartamentos.get(indexInt);
	}
	public void cambiarNombre(String nombreNuevo)
	{
		String nombreViejo = this.getNombre();
		this.setNombre(nombreNuevo);
		GestorDB.getInstance().añadirLog("La Empresa [ " + nombreViejo + " ] ha sido modificado por [ " + nombreNuevo +" ].");
		GestorDB.getInstance().guardarBD();
	}
	
	public void añadirDepartamento(Departamento d1)
	{
		listaDepartamentos.add(d1);
		GestorDB.getInstance().añadirLog("Departamento [ " + d1.getNombre() + " ] añadido.");
		GestorDB.getInstance().guardarBD();
	}
	public void borrarDepartamento(Departamento d1)
	{
		Boolean accion = listaDepartamentos.remove(d1);
		if ( accion==true)
		{
			GestorDB.getInstance().añadirLog("Departamento [ " + d1.getNombre() + " ] eliminado.");
		}
		else
		{
			GestorDB.getInstance().añadirLog("Error al eliminar el Departamento [ " + d1.getNombre() + " ].");
		}
		GestorDB.getInstance().guardarBD();
	}
	
	//------- HASHCODE Y EQUALS ----------------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((direccion == null) ? 0 : direccion.hashCode());
		result = prime
				* result
				+ ((listaDepartamentos == null) ? 0 : listaDepartamentos
						.hashCode());
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
		Empresa other = (Empresa) obj;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (listaDepartamentos == null) {
			if (other.listaDepartamentos != null)
				return false;
		} else if (!listaDepartamentos.equals(other.listaDepartamentos))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	//------- GETTER Y SETTER ----------------------
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public ArrayList<Departamento> getListaDepartamentos() {
		return listaDepartamentos;
	}
	public void setListaDepartamentos(ArrayList<Departamento> listaDepartamentos) {
		this.listaDepartamentos = listaDepartamentos;
	}
	public Grupo getGrupoPadre() {
		return grupoPadre;
	}
	public void setGrupoPadre(Grupo grupoPadre) {
		this.grupoPadre = grupoPadre;
	}

}
