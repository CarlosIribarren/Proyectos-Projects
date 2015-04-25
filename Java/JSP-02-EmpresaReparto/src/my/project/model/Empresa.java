package my.project.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer idEmpresa;
	private String nombre;
	private String cif;
	private String direccion;
	private String pais;
	
	private ArrayList<Empleado> listaEmpleados = new  ArrayList<Empleado>();
	private ArrayList<Coche> listaCoches = new ArrayList<Coche>();
	
	public Empresa() {}
	
	public Empresa(String nombre, String cif) {
		super();
		this.nombre = nombre;
		this.cif = cif;
	}

	public ArrayList<Empleado> getListaEmpleados() {
		return listaEmpleados;
	}
	public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}
	public ArrayList<Coche> getListaCoches() {
		return listaCoches;
	}
	public void setListaCoches(ArrayList<Coche> listaCoches) {
		this.listaCoches = listaCoches;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getCif() {
		return cif;
	}
	public void setCif(String cif) {
		this.cif = cif;
	}

	public Integer getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String midireccion) {
		direccion = midireccion;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
	
}
