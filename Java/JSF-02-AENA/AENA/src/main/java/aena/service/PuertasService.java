package aena.service;

import java.util.List;

import aena.dao.PuertaDAO;
import aena.dao.impl.PuertaDAOImpl;
import aena.model.Puerta;

public class PuertasService {

	private PuertaDAO puertaDAO = new PuertaDAOImpl();
	
	public List<Puerta> obtenerPuertasPorAeropuerto(Integer id)
	{
		return puertaDAO.findByAeropuerto(id);
	}
	
}
