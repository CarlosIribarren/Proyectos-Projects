package aena.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import aena.model.Aeropuerto;
import aena.model.Puerta;
import aena.service.AeropuertoService;
import aena.service.PuertasService;

@ManagedBean(name="puertasDeAeropuertoBean")
@SessionScoped
public class PuertasDeAeropuertoBean implements Serializable {

	private static final long serialVersionUID = 2440980515517865682L;

	private AeropuertoService aeropuertoService;
	private PuertasService puertasService;
	
	//nombre del aeropuerto elegido
	private String nombreAeropuerto;
	//total de las puertas del aeropuerto elegido
	private Integer toalPuertasAeropuerto;
	//se utiliza al mapa solo de manera interna, se usa para mapear los 
	// nombres de los aeropuertos con sus id correspondiente.
	private Map<String,Integer> mapaAeropuertoNombreIde = new HashMap<String,Integer>();
	//Lista para rellenar el combo con los aeropuertos
	private List<String> nombreAeropuertos = new ArrayList<String>();
	//Resultado de la busqueda
	private List<Puerta> puertasDeAeropuerto = new ArrayList<Puerta>();
	
	public PuertasDeAeropuertoBean(){}
	
    @PostConstruct
    public void init() {
    	aeropuertoService = new AeropuertoService();
    	puertasService = new PuertasService();
    	List<Aeropuerto> aeropuertos = aeropuertoService.obtenerAeropuertos();
    	for(Aeropuerto  a : aeropuertos )
    	{
    		Integer i = new Integer(a.getIdAeropuerto());
    		mapaAeropuertoNombreIde.put(a.getNombre(),i);
    	}
    	
    	
    	nombreAeropuertos = aeropuertoService.obtenerNombreAeropuertos();
    }
    
    public void buscarPuertasDeAeropuerto(){
    	
    	//obtener el id del aeropuerto
    	Integer id = mapaAeropuertoNombreIde.get(nombreAeropuerto);
    	//obtener las puertas
    	puertasDeAeropuerto = puertasService.obtenerPuertasPorAeropuerto(id);
    	//Guardar el numero total de puertas
    	toalPuertasAeropuerto = puertasDeAeropuerto.size();
    	
    	
    	
    }

	public AeropuertoService getAeropuertoService() {
		return aeropuertoService;
	}

	public void setAeropuertoService(AeropuertoService aeropuertoService) {
		this.aeropuertoService = aeropuertoService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<String> getNombreAeropuertos() {
		return nombreAeropuertos;
	}

	public void setNombreAeropuertos(List<String> nombreAeropuertos) {
		this.nombreAeropuertos = nombreAeropuertos;
	}

	public String getNombreAeropuerto() {
		return nombreAeropuerto;
	}

	public void setNombreAeropuerto(String nombreAeropuerto) {
		this.nombreAeropuerto = nombreAeropuerto;
	}

	public Map<String, Integer> getMapaNombreIde() {
		return mapaAeropuertoNombreIde;
	}

	public void setMapaNombreIde(Map<String, Integer> mapaNombreIde) {
		this.mapaAeropuertoNombreIde = mapaNombreIde;
	}

	public List<Puerta> getPuertasDeAeropuerto() {
		return puertasDeAeropuerto;
	}

	public void setPuertasDeAeropuerto(List<Puerta> puertasDeAeropuerto) {
		this.puertasDeAeropuerto = puertasDeAeropuerto;
	}

	public PuertasService getPuertasService() {
		return puertasService;
	}

	public void setPuertasService(PuertasService puertasService) {
		this.puertasService = puertasService;
	}

	public Integer getToalPuertasAeropuerto() {
		return toalPuertasAeropuerto;
	}

	public void setToalPuertasAeropuerto(Integer toalPuertasAeropuerto) {
		this.toalPuertasAeropuerto = toalPuertasAeropuerto;
	}


	
}
