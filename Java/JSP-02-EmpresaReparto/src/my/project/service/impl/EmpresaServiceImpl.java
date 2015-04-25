package my.project.service.impl;

import java.util.List;

import my.project.dao.EmpresaDAO;
import my.project.dao.impl.EmpresaDAOImpl;
import my.project.model.Empleado;
import my.project.model.Empresa;
import my.project.service.EmpresaService;

public class EmpresaServiceImpl implements EmpresaService {

	EmpresaDAO empresaDao = new EmpresaDAOImpl();
	
	
	@Override
	public List<Empresa> getEmpresas() {
		return empresaDao.findAll();
	}

	@Override
	public Empresa getEmpresaByID(Integer id) {
		return empresaDao.getById(id);
	}

	@Override
	public void anadirEmpresa(Empresa e) {
		//obtener el id maximo
		Integer maxID = empresaDao.obtenerMaxID();
		//Sumar uno al indice mayor
		maxID = maxID + 1;
		//asignar id que le corresponde
		e.setIdEmpresa(maxID);
		//guardar en la BD
		empresaDao.insertEmpresa(e);
		
	}

	@Override
	public void modificarEmpresa(Empresa e) {
		empresaDao.updateEmpresa(e);

	}

	@Override
	public void eliminarEmpresa(Empresa e) {
		empresaDao.deleteEmpresa(e);
	}


}
