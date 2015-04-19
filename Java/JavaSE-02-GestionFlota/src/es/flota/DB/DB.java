package es.flota.DB;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import es.flota.Grupo.Grupo;

public class DB implements Serializable {

	private static final long serialVersionUID = 1L;

	private ArrayList<Grupo> listaGrupos = new ArrayList<Grupo>();
	private Date ultimaConexion;
	private String log="";
	
	//------------- METODOS DE LA CLASE ----------------
	
	public void añadirGrupo(Grupo g1)
	{
		listaGrupos.add(g1);
	}
	public Boolean borrarGrupo(Grupo g1)
	{
		return listaGrupos.remove(g1);
	}	
	
	//--------------- GETTER Y SETTER ------------------------
	public Date getUltimaConexion() {
		return ultimaConexion;
	}
	public void setUltimaConexion(Date ultimaConexion) {
		this.ultimaConexion = ultimaConexion;
	}
	public String getLog() {
		return log;
	}
	public void setLog(String log) {
		this.log = log;
	}
	public ArrayList<Grupo> getListaGrupos() {
		return listaGrupos;
	}
	public void setListaGrupos(ArrayList<Grupo> listaGrupos) {
		this.listaGrupos = listaGrupos;
	}
	
}
