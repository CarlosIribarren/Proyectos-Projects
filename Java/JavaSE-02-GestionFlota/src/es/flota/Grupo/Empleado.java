package es.flota.Grupo;

import java.io.Serializable;

import es.flota.DB.GestorDB;

public class  Empleado implements Serializable{

	private static final long serialVersionUID = -44573040066340541L;
	
	private String nombre;
	private String apellido;
	private String dni;
	private Double carga;
	private Departamento departamento;
	private Vehiculo vehiculoAsignado;
	
	public Empleado(String dNI, String nombre, String apellido, Double carga,
			Departamento departamento,Vehiculo vehiculoAsignado) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dNI;
		this.carga = carga;
		this.departamento = departamento;
		this.vehiculoAsignado=vehiculoAsignado;
	}
	public Empleado(String dNI, String nombre, String apellido, Double carga,
			Departamento departamento) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dNI;
		this.carga = carga;
		this.departamento = departamento;
		this.vehiculoAsignado=null;
	}
	
	
	public void asignarVehiculo(Vehiculo v1)
	{
		//poner el doble enlace
		//1enlace
		this.vehiculoAsignado=v1;
		//2enlace
		v1.setAsigandoEmpleado(this);
		v1.cambiarDisponibilidad(Boolean.FALSE);

		//añadir log ( antes de eliminar la informacion ) 
		GestorDB.getInstance().añadirLog("El Empleado [ " + this.getDni() + " : " + this.getNombre()  + " ]  se ha asignado correctamente al vehiculo ( " + this.getVehiculoAsignado().getClass().getSimpleName()+ " : " + this.getVehiculoAsignado().getMatricula()+ " ) con exito."); 
		//guardar en la BD
		GestorDB.getInstance().guardarBD();
	}
	
	public void desAsignarVehiculo()
	{
		 //añadir log ( antes de eliminar la informacion ) 
		 GestorDB.getInstance().añadirLog("El Empleado [ " + this.getDni() + " : " + this.getNombre()  + " ]  se ha des-asignado correctamente del vehiculo ( " + this.getVehiculoAsignado().getClass().getSimpleName()+ " : " + this.getVehiculoAsignado().getMatricula()+ " ) con exito."); 
		
		
		//quitar el doble enlace
		//1ENLACE : obtener vehiculo para quitar enlace
		Vehiculo v1 = this.getVehiculoAsignado();
		v1.setAsigandoEmpleado(null);
		v1.cambiarDisponibilidad(Boolean.TRUE);
		//2ENLACE
		this.vehiculoAsignado=null;
		
		 //guardar en la BD
		GestorDB.getInstance().guardarBD();
	}
	public void cambiarCarga(Double carga)
	{
		this.carga=carga;
		GestorDB.getInstance().añadirLog("Al Empleado [ " + this.getDni() + " ] se le ha cambiado la carga por " + carga + " .");
		GestorDB.getInstance().guardarBD();
	}
	
	
	//------- HASHCODE Y EQUALS ----------------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((apellido == null) ? 0 : apellido.hashCode());
		result = prime * result + ((carga == null) ? 0 : carga.hashCode());
		result = prime * result
				+ ((departamento == null) ? 0 : departamento.hashCode());
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime
				* result
				+ ((vehiculoAsignado == null) ? 0 : vehiculoAsignado.hashCode());
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
		Empleado other = (Empleado) obj;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
		if (carga == null) {
			if (other.carga != null)
				return false;
		} else if (!carga.equals(other.carga))
			return false;
		if (departamento == null) {
			if (other.departamento != null)
				return false;
		} else if (!departamento.equals(other.departamento))
			return false;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (vehiculoAsignado == null) {
			if (other.vehiculoAsignado != null)
				return false;
		} else if (!vehiculoAsignado.equals(other.vehiculoAsignado))
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
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Double getCarga() {
		return carga;
	}
	public void setCarga(Double carga) {
		this.carga = carga;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public Vehiculo getVehiculoAsignado() {
		return vehiculoAsignado;
	}
	public void setVehiculoAsignado(Vehiculo vehiculoAsignado) {
		this.vehiculoAsignado = vehiculoAsignado;
	}
	
	//------- TO STRING ----------------------
	@Override
	public String toString() {
		return "\nEmpleado [nombre=" + nombre + ", apellido=" + apellido
				+ ", DNI=" + dni + ", carga=" + carga ;
	}


}
