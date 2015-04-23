package aena.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import aena.model.Avion;
import aena.service.AvionesService;

@ManagedBean(name="avionesBean")
@RequestScoped
public class AvionesBean {

	private AvionesService avionesService = new AvionesService();
	private List<Avion> avionesCaducados = new ArrayList<Avion>();
	private List<Avion> avionesRutaSpain = new ArrayList<Avion>();
	
	
    @PostConstruct
    public void init() {
    	//cargar aviones caducados
    	avionesCaducados = avionesService.obtenerAvionesCaducados();
    	//cargar aviones con ruta española
    	avionesRutaSpain = avionesService.obtenerAvionesRutaSpain();
    }


	public List<Avion> getAvionesCaducados() {
		return avionesCaducados;
	}


	public void setAvionesCaducados(List<Avion> avionesCaducados) {
		this.avionesCaducados = avionesCaducados;
	}


	public List<Avion> getAvionesRutaSpain() {
		return avionesRutaSpain;
	}


	public void setAvionesRutaSpain(List<Avion> avionesRutaSpain) {
		this.avionesRutaSpain = avionesRutaSpain;
	}
	
	
}
