package my.project.model;

import java.io.Serializable;

public class Coche implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer idCoche;
	private String matricula;
	private String modelo;
	private String marca;
	private int numeroPlazas;
	private Empleado empleadoAsigando;
	private Empresa empresa;
	
	public Coche () {}

	public Integer getIdCoche() {
		return idCoche;
	}

	public void setIdCoche(Integer idCoche) {
		this.idCoche = idCoche;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
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

	public int getNumeroPlazas() {
		return numeroPlazas;
	}

	public void setNumeroPlazas(int numeroPlazas) {
		this.numeroPlazas = numeroPlazas;
	}

	public Empleado getEmpleadoAsigando() {
		return empleadoAsigando;
	}

	public void setEmpleadoAsigando(Empleado empleadoAsigando) {
		this.empleadoAsigando = empleadoAsigando;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	
}
