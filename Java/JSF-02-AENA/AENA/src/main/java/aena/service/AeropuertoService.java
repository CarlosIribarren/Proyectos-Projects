package aena.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import aena.dao.AeropuertoDAO;
import aena.dao.impl.AeropuertoDAOImpl;
import aena.model.Aeropuerto;

public class AeropuertoService implements Serializable {

	private AeropuertoDAO aeropuertoDAO = new AeropuertoDAOImpl();
	
	public AeropuertoService(){} 
	
	public List<Aeropuerto> obtenerAeropuertos(){
		return aeropuertoDAO.findAll();
	}
	

	public List<String> obtenerNombreAeropuertos(){
		List<String> resultado = new ArrayList<String>();	
		List<Aeropuerto> aeropuertos = aeropuertoDAO.obtenerAeropuertos();
		for(Aeropuerto aeropuerto : aeropuertos )
		{
			resultado.add(aeropuerto.getNombre());
		}
		return resultado;
	}
	
	public AeropuertoDAO getAeropuertoDAO() {
		return aeropuertoDAO;
	}

	public void setAeropuertoDAO(AeropuertoDAO aeropuertoDAO) {
		this.aeropuertoDAO = aeropuertoDAO;
	}
	
	
}
