package my.project.dao;

import java.util.List;

import my.project.model.Empleado;
import my.project.model.Empresa;

public interface EmpresaDAO {
	
	public List<Empresa> findAll();
	public Empresa getById(Integer id);

	public void insertEmpresa(Empresa e);
	public void updateEmpresa(Empresa e);
	public void deleteEmpresa(Empresa e);
	
	public Integer obtenerMaxID();
	
	
	
}
