package es.flota.Grupo;

import java.io.Serializable;

import es.flota.DB.GestorDB;


public abstract class Vehiculo implements Serializable {

	private static final long serialVersionUID = -2304721904232543149L;
	 
	 private String matricula;
	 private String marca;
	 private String modelo;
	 private Boolean disponible;
	 private Empleado asigandoEmpleado;
	 
	public Vehiculo(String matricula, String marca, String modelo, Boolean disponible) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.disponible=disponible;
	}
	public Vehiculo(String matricula, String marca, String modelo, Boolean disponible,
			Empleado asigandoEmpleado) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.disponible=disponible;
		this.asigandoEmpleado = asigandoEmpleado;
	}

	//------- METODOS DE LA CLASE ----------------------
	
	//luego se redefine este metodo en los hijos
	public Double calcularCoste(Double km) { return 0d; }

	public void asignarEmpleado( Empleado e1) {
		 
		 //poner no disponible
		 this.disponible=false;
		 
		//Poner los dos enlaces
		 	//Enlace de Vehiculo a empleado, es decir, asignar empleado al vehiculo
		 	this.asigandoEmpleado = e1;
		 	//Asignar vehiculo al empleado
		 	e1.setVehiculoAsignado(this);
		 
		 //añadir log 
		 GestorDB.getInstance().añadirLog("El Vehiculo "  + this.getClass().getSimpleName() +  " [ " + this.matricula + " ] se ha asignado al empleado ( " + this.asigandoEmpleado.getDni() + " : " + this.asigandoEmpleado.getNombre() + " ) con exito."); 
		 //guardar en la BD
		GestorDB.getInstance().guardarBD();
	}
	public void desAsignarVehiculo()
	 {
		 //añadir log antes de borrar los datos
		 GestorDB.getInstance().añadirLog("El Vehiculo "  + this.getClass().getSimpleName() +  " [ " + this.matricula + " ] se ha des-asignado del empleado ( " + this.asigandoEmpleado.getDni() + " : " + this.asigandoEmpleado.getNombre() + " ) con exito.");
		 
		 //poner disponible
		 this.disponible=true;
		 
		 //Quitar los dos enlaces
			 //obtener empleado
			 Empleado e = this.asigandoEmpleado;
			// 1 Quitar enlace del empleado;
			 e.setVehiculoAsignado(null);
	
			 // 2 Quitar enlace del vehiculo
			 this.asigandoEmpleado=null;
		 
		 //guardar en la BD
		GestorDB.getInstance().guardarBD();
	 }
	
	public void cambiarDisponibilidad(Boolean estado)
	{
		this.disponible=estado;
		String disponibilidad = (estado.booleanValue()==Boolean.TRUE)?"Disponible":"Ocupado";
		GestorDB.getInstance().añadirLog("Al Vehiculo [ " + this.getClass().getSimpleName() + this.getMatricula() + " ] se le ha cambiado su disponibilidad a " + disponibilidad + " .");
		GestorDB.getInstance().guardarBD();
	}
	public void cambiarModelo(String modelo)
	{
		this.modelo=modelo;
		GestorDB.getInstance().añadirLog("Al Vehiculo [ " + this.getClass().getSimpleName() + this.getMatricula() + " ] se le ha cambiado el modelo a : " + modelo + " .");
		GestorDB.getInstance().guardarBD();
	}
	
	//------- HASHCODE Y EQUALS ----------------------


		@Override
	public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime
					* result
					+ ((asigandoEmpleado == null) ? 0 : asigandoEmpleado.hashCode());
			result = prime * result
					+ ((disponible == null) ? 0 : disponible.hashCode());
			result = prime * result + ((marca == null) ? 0 : marca.hashCode());
			result = prime * result
					+ ((matricula == null) ? 0 : matricula.hashCode());
			result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
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
			Vehiculo other = (Vehiculo) obj;
			if (asigandoEmpleado == null) {
				if (other.asigandoEmpleado != null)
					return false;
			} else if (!asigandoEmpleado.equals(other.asigandoEmpleado))
				return false;
			if (disponible == null) {
				if (other.disponible != null)
					return false;
			} else if (!disponible.equals(other.disponible))
				return false;
			if (marca == null) {
				if (other.marca != null)
					return false;
			} else if (!marca.equals(other.marca))
				return false;
			if (matricula == null) {
				if (other.matricula != null)
					return false;
			} else if (!matricula.equals(other.matricula))
				return false;
			if (modelo == null) {
				if (other.modelo != null)
					return false;
			} else if (!modelo.equals(other.modelo))
				return false;
			return true;
		}


	//------- GETTER Y SETTER ----------------------
	public Empleado getAsigandoEmpleado() {
		return asigandoEmpleado;
	}
	public void setAsigandoEmpleado(Empleado asigandoEmpleado) {
		this.asigandoEmpleado = asigandoEmpleado;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public Boolean getDisponible() {
		return disponible;
	}
	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}

	//------- TO STRING ----------------------
	@Override
	public String toString() {
		return "\n matricula=" + matricula
				+ ", marca=" + marca + ", modelo=" + modelo
				+ ", asigandoEmpleado=" + asigandoEmpleado;
	}

}
