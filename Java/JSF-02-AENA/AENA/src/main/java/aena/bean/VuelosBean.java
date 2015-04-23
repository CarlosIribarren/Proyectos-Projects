package aena.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import aena.model.Aeropuerto;
import aena.model.Vuelo;
import aena.service.AeropuertoService;
import aena.service.PuertasService;
import aena.service.VueloService;

@ManagedBean(name="vuelosBean")
@RequestScoped
public class VuelosBean {

	private VueloService vueloService = new VueloService();
	private List<Vuelo> vuelos = new ArrayList<Vuelo>();
	
    @PostConstruct
    public void init() {
    	//cargar vuelos
    	vuelos = vueloService.obtenerVuelos();
    }	
    
	public VuelosBean(){}

	public List<Vuelo> getVuelos() {
		return vuelos;
	}

	public void setVuelos(List<Vuelo> vuelos) {
		this.vuelos = vuelos;
	}


	
	
	
	
}
