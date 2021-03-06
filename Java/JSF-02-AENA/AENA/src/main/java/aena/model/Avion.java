package aena.model;

// Generated 23-abr-2015 0:48:43 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Avion generated by hbm2java
 */
public class Avion implements java.io.Serializable {

	private int idAvion;
	private Empresa empresa;
	private String matricula;
	private String modelo;
	private Integer numeroPlazas;
	private Date fechaConcesionLicencia;
	private Date fechaCaducidadLicencia;
	private Set<Vuelo> vuelos = new HashSet<Vuelo>(0);

	public Avion() {
	}

	public Avion(int idAvion) {
		this.idAvion = idAvion;
	}

	public Avion(int idAvion, Empresa empresa, String matricula, String modelo,
			Integer numeroPlazas, Date fechaConcesionLicencia,
			Date fechaCaducidadLicencia, Set<Vuelo> vuelos) {
		this.idAvion = idAvion;
		this.empresa = empresa;
		this.matricula = matricula;
		this.modelo = modelo;
		this.numeroPlazas = numeroPlazas;
		this.fechaConcesionLicencia = fechaConcesionLicencia;
		this.fechaCaducidadLicencia = fechaCaducidadLicencia;
		this.vuelos = vuelos;
	}

	public int getIdAvion() {
		return this.idAvion;
	}

	public void setIdAvion(int idAvion) {
		this.idAvion = idAvion;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public String getMatricula() {
		return this.matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getNumeroPlazas() {
		return this.numeroPlazas;
	}

	public void setNumeroPlazas(Integer numeroPlazas) {
		this.numeroPlazas = numeroPlazas;
	}

	public Date getFechaConcesionLicencia() {
		return this.fechaConcesionLicencia;
	}

	public void setFechaConcesionLicencia(Date fechaConcesionLicencia) {
		this.fechaConcesionLicencia = fechaConcesionLicencia;
	}

	public Date getFechaCaducidadLicencia() {
		return this.fechaCaducidadLicencia;
	}

	public void setFechaCaducidadLicencia(Date fechaCaducidadLicencia) {
		this.fechaCaducidadLicencia = fechaCaducidadLicencia;
	}

	public Set<Vuelo> getVuelos() {
		return this.vuelos;
	}

	public void setVuelos(Set<Vuelo> vuelos) {
		this.vuelos = vuelos;
	}

}
