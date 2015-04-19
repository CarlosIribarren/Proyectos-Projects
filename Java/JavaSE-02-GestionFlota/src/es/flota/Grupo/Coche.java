package es.flota.Grupo;

import java.io.Serializable;

import es.flota.DB.GestorDB;

public class Coche extends Vehiculo implements Serializable {
	
	private static final long serialVersionUID = 5812833440213001272L;
	
	private double capacidadMaletero;
	private static final Double PRECIOKM = 7.56;

	public Coche(String matricula, String marca, String modelo, double cap, Boolean disponible) {
		super(matricula, marca, modelo,disponible);
		this.capacidadMaletero = cap;
	}
	
	public Coche(String matricula, String marca, String modelo, double cap, Boolean disponible,Empleado empleadoAsignado) {
		super(matricula, marca, modelo,disponible,empleadoAsignado );
		this.capacidadMaletero = cap;
	}
	//------- METODOS DE LA CLASE ----------------------
	
	// POLIMORFISMO
	@Override
	public Double calcularCoste(Double km) {
		//el coste del coche 
		return PRECIOKM*km*(capacidadMaletero*0.75d);
	}
	
	public void cambiarCapacidadMaletero(Double cap)
	{
		this.capacidadMaletero=cap;
		GestorDB.getInstance().añadirLog("Al Coche [ " + this.getMatricula() + " ] se le ha cambiado la capacidad del maletero por " + cap + " .");
		GestorDB.getInstance().guardarBD();
	}

	//------- HASHCODE Y EQUALS ----------------------
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(capacidadMaletero);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coche other = (Coche) obj;
		if (Double.doubleToLongBits(capacidadMaletero) != Double
				.doubleToLongBits(other.capacidadMaletero))
			return false;
		return true;
	}
	
	//------- GETTER Y SETTER ----------------------
	public double getCapacidadMaletero() {
		return capacidadMaletero;
	}
	public void setCapacidadMaletero(double capacidadMaletero) {
		this.capacidadMaletero = capacidadMaletero;
	}

}
