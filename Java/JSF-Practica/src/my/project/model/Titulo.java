package my.project.model;

import java.util.Date;

public class Titulo {

	private String titulo;
	private Date desdeFecha;
	private Date hastaFecha;
	
	public Titulo(){
		
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Date getDesdeFecha() {
		return desdeFecha;
	}
	public void setDesdeFecha(Date desdeFecha) {
		this.desdeFecha = desdeFecha;
	}
	public Date getHastaFecha() {
		return hastaFecha;
	}
	public void setHastaFecha(Date hastaFecha) {
		this.hastaFecha = hastaFecha;
	}
	
	
	
}
