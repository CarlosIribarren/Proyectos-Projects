package my.project.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Empleado implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer numeroEmpleado;
	private Date fechaNacimiento;
	private String nombre;
	private String apellido;
	private String genero;
	private Date fechaContratacion;
	
	private ArrayList<Salario> listaSalarios = new ArrayList<Salario>();
	private ArrayList<Titulo> listaTitulos = new ArrayList<Titulo>();
	
	
	public Empleado(){
		
	}
	
	public Integer getNumeroEmpleado() {
		return numeroEmpleado;
	}
	public void setNumeroEmpleado(Integer numeroEmpleado) {
		this.numeroEmpleado = numeroEmpleado;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
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
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Date getFechaContratacion() {
		return fechaContratacion;
	}
	public void setFechaContratacion(Date fechaContratacion) {
		this.fechaContratacion = fechaContratacion;
	}

	public ArrayList<Salario> getListaSalarios() {
		return listaSalarios;
	}

	public void setListaSalarios(ArrayList<Salario> listaSalarios) {
		this.listaSalarios = listaSalarios;
	}

	public ArrayList<Titulo> getListaTitulos() {
		return listaTitulos;
	}

	public void setListaTitulos(ArrayList<Titulo> listaTitulos) {
		this.listaTitulos = listaTitulos;
	}
	

}
