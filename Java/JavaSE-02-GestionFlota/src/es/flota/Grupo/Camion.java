package es.flota.Grupo;

import java.io.Serializable;

import es.flota.DB.GestorDB;

public class Camion extends Vehiculo implements Serializable {

	private static final long serialVersionUID = 3612434084483856247L;
	
	private Double tara;
	private Double mma;
	private static final Double PRECIOKM = 23.6;

	public Camion(String matricula, String marca, String modelo, Double tara, Double mma, Boolean disponible) {
		super(matricula, marca, modelo,disponible);
		this.tara = tara;
		this.mma=mma;
	}
	//------- METODOS DE LA CLASE ----------------------
	
	// POLIMORFISMO
	@Override
	public Double calcularCoste(Double km) {
		Double coste;
		//el coste del camion se calcula con la siguiente formula
		coste=(tara<2250)? (PRECIOKM*km)*(mma*1.2d) : (PRECIOKM*km)*(1.7d)*(mma*1.5d);
		return coste;
	}	
	
	public void cambiarMMA(Double mma)
	{
		this.mma=mma;
		GestorDB.getInstance().añadirLog("Al Camion [ " + this.getMatricula() + " ] se le ha cambiado la MMA por " + mma + " .");
		GestorDB.getInstance().guardarBD();
	}
	public void cambiarTARA(Double tara)
	{
		this.tara=tara;
		GestorDB.getInstance().añadirLog("Al Camion [ " + this.getMatricula() + " ] se le ha cambiado la TARA por " + tara + " .");
		GestorDB.getInstance().guardarBD();
	}
	//------- HASHCODE Y EQUALS ----------------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((mma == null) ? 0 : mma.hashCode());
		result = prime * result + ((tara == null) ? 0 : tara.hashCode());
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
		Camion other = (Camion) obj;
		if (mma == null) {
			if (other.mma != null)
				return false;
		} else if (!mma.equals(other.mma))
			return false;
		if (tara == null) {
			if (other.tara != null)
				return false;
		} else if (!tara.equals(other.tara))
			return false;
		return true;
	}
	//------- GETTER Y SETTER ----------------------
	public Double getTara() {
		return tara;
	}
	public void setTara(Double tara) {
		this.tara = tara;
	}
	public Double getMma() {
		return mma;
	}
	public void setMma(Double mma) {
		this.mma = mma;
	}
}
