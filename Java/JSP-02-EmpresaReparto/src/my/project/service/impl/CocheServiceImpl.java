package my.project.service.impl;

import my.project.dao.CocheDAO;
import my.project.dao.impl.CocheDAOImpl;
import my.project.model.Coche;
import my.project.model.Empresa;
import my.project.service.CocheService;

public class CocheServiceImpl implements CocheService {

	CocheDAO cocheDAO = new CocheDAOImpl();
	
	public void anadirCoche(Coche c) {
		//obtener el id maximo
		Integer maxID = cocheDAO.obtenerMaxID();
		//Sumar uno al indice mayor
		maxID = maxID + 1;
		//asignar id que le corresponde
		c.setIdCoche(maxID);
		//guardar en la BD
		// TODO Auto-generated method stub
		//empresaDao.insertEmpresa(e);
		
	}

	@Override
	public void anadirCoche(Empresa e) {
		
		
	}

}
