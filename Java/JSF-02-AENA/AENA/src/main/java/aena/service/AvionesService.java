package aena.service;

import java.util.List;

import aena.dao.AvionDAO;
import aena.dao.impl.AvionDAOImpl;
import aena.model.Avion;

public class AvionesService {
	
	private AvionDAO avionDAO = new AvionDAOImpl();  
	
	public List<Avion> obtenerAvionesCaducados()
	{
		return avionDAO.buscarAvionesCaducados();
	}

	public List<Avion> obtenerAvionesRutaSpain() {
		
		return avionDAO.obtenerAvionesRutaSpain();
	}
}
