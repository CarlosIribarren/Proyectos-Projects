package my.project.service;

import java.util.List;

import my.project.model.Empleado;
import my.project.model.Empresa;

public interface EmpresaService {
	
	public List<Empresa> getEmpresas();
	public Empresa getEmpresaByID(Integer id);

	public void anadirEmpresa(Empresa e);
	public void modificarEmpresa(Empresa e);
	public void eliminarEmpresa(Empresa e);

}
