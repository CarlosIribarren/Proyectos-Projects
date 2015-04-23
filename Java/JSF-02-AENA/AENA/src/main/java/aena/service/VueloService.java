package aena.service;

import java.util.List;

import aena.dao.VueloDAO;
import aena.dao.impl.VueloDAOImpl;
import aena.model.Puerta;
import aena.model.Vuelo;

public class VueloService {

	private VueloDAO vueloDAO = new VueloDAOImpl();
	
	public List<Vuelo> obtenerVuelos()
	{
		return vueloDAO.buscarTodos();
	}
	
}
