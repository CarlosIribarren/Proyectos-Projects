package aena.model;

// Generated 19-abr-2015 22:55:28 by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Vuelo generated by hbm2java
 */
public class Vuelo implements java.io.Serializable {

	private int idVuelo;
	private Aeropuerto aeropuertoByIdAeropuertoLlegada;
	private Aeropuerto aeropuertoByIdAeropuertoSalida;
	private Puerta puertaByIdPuertaSalida;
	private Puerta puertaByIdPuertaLlegada;
	private Avion avion;
	private String nombre;
	private Date horaSalida;
	private Date horaLlegada;
	private Set<Pasajero> pasajeros = new HashSet<Pasajero>(0);
	private Set<Reserva> reservas = new HashSet<Reserva>(0);

	public Vuelo() {
	}

	public Vuelo(int idVuelo) {
		this.idVuelo = idVuelo;
	}

	public Vuelo(int idVuelo, Aeropuerto aeropuertoByIdAeropuertoLlegada,
			Aeropuerto aeropuertoByIdAeropuertoSalida,
			Puerta puertaByIdPuertaSalida, Puerta puertaByIdPuertaLlegada,
			Avion avion, String nombre, Date horaSalida, Date horaLlegada,
			Set<Pasajero> pasajeros, Set<Reserva> reservas) {
		this.idVuelo = idVuelo;
		this.aeropuertoByIdAeropuertoLlegada = aeropuertoByIdAeropuertoLlegada;
		this.aeropuertoByIdAeropuertoSalida = aeropuertoByIdAeropuertoSalida;
		this.puertaByIdPuertaSalida = puertaByIdPuertaSalida;
		this.puertaByIdPuertaLlegada = puertaByIdPuertaLlegada;
		this.avion = avion;
		this.nombre = nombre;
		this.horaSalida = horaSalida;
		this.horaLlegada = horaLlegada;
		this.pasajeros = pasajeros;
		this.reservas = reservas;
	}

	public int getIdVuelo() {
		return this.idVuelo;
	}

	public void setIdVuelo(int idVuelo) {
		this.idVuelo = idVuelo;
	}

	public Aeropuerto getAeropuertoByIdAeropuertoLlegada() {
		return this.aeropuertoByIdAeropuertoLlegada;
	}

	public void setAeropuertoByIdAeropuertoLlegada(
			Aeropuerto aeropuertoByIdAeropuertoLlegada) {
		this.aeropuertoByIdAeropuertoLlegada = aeropuertoByIdAeropuertoLlegada;
	}

	public Aeropuerto getAeropuertoByIdAeropuertoSalida() {
		return this.aeropuertoByIdAeropuertoSalida;
	}

	public void setAeropuertoByIdAeropuertoSalida(
			Aeropuerto aeropuertoByIdAeropuertoSalida) {
		this.aeropuertoByIdAeropuertoSalida = aeropuertoByIdAeropuertoSalida;
	}

	public Puerta getPuertaByIdPuertaSalida() {
		return this.puertaByIdPuertaSalida;
	}

	public void setPuertaByIdPuertaSalida(Puerta puertaByIdPuertaSalida) {
		this.puertaByIdPuertaSalida = puertaByIdPuertaSalida;
	}

	public Puerta getPuertaByIdPuertaLlegada() {
		return this.puertaByIdPuertaLlegada;
	}

	public void setPuertaByIdPuertaLlegada(Puerta puertaByIdPuertaLlegada) {
		this.puertaByIdPuertaLlegada = puertaByIdPuertaLlegada;
	}

	public Avion getAvion() {
		return this.avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getHoraSalida() {
		return this.horaSalida;
	}

	public void setHoraSalida(Date horaSalida) {
		this.horaSalida = horaSalida;
	}

	public Date getHoraLlegada() {
		return this.horaLlegada;
	}

	public void setHoraLlegada(Date horaLlegada) {
		this.horaLlegada = horaLlegada;
	}

	public Set<Pasajero> getPasajeros() {
		return this.pasajeros;
	}

	public void setPasajeros(Set<Pasajero> pasajeros) {
		this.pasajeros = pasajeros;
	}

	public Set<Reserva> getReservas() {
		return this.reservas;
	}

	public void setReservas(Set<Reserva> reservas) {
		this.reservas = reservas;
	}

}
