package my.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import my.project.model.Empresa;
import my.project.service.EmpresaService;
import my.project.service.impl.EmpresaServiceImpl;

//Añadimos los maping
@WebServlet(urlPatterns = { 
		"/MostrarPantallaPrincipal",
		"/MostrarInsertarEmpresa",
		"/MostrarEliminarJSP",
		"/MostrarEditarJSP",
		"/InsertarUnaEmpresa",
		"/EliminarUnaEmpresa",
		"/ModificarUnaEmpresa"})


public class EmpresaController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private EmpresaService empresaService = new EmpresaServiceImpl();
	
    public EmpresaController() {super();}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//comprobar de donde se le llama
		if ("/M2ACTIVIDAD4/MostrarInsertarEmpresa".equals(request.getRequestURI()))
		{	
			request.getRequestDispatcher("/WEB-INF/views/empresa/InsertarEmpresa.jsp")
			.forward(request, response);
		}
		else
		{
			//POR DEFECTO
			List<Empresa> listaEmpresas = empresaService.getEmpresas();
			request.setAttribute("listaEmpresas", listaEmpresas);
				
			request.getRequestDispatcher("/WEB-INF/views/empresa/PantallaPrincipal.jsp")
			.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		
		System.out.println(request.getRequestURI());
		

		if ("/M2ACTIVIDAD4/MostrarPantallaPrincipal".equals(request.getRequestURI()))
		{
			//POR DEFECTO
			List<Empresa> listaEmpresas = empresaService.getEmpresas();
			request.setAttribute("listaEmpresas", listaEmpresas);
			
			request.getRequestDispatcher("/WEB-INF/views/empresa/PantallaPrincipal.jsp").forward(request, response);
		}		
		else if ("/M2ACTIVIDAD4/MostrarEliminarJSP".equals(request.getRequestURI()))
		{
			//recibir parametros
			String idSelecionado = request.getParameter("id");
			
			//obtener la empresa
			Integer idEmpresa = new Integer(idSelecionado); 
			Empresa e = empresaService.getEmpresaByID(idEmpresa);
			
			//añadir empresa a la respuesta
			request.setAttribute("empresa", e);
			 
			request.getRequestDispatcher("/WEB-INF/views/empresa/EliminarEmpresa.jsp").forward(request, response);
			
		}
		else if("/M2ACTIVIDAD4/MostrarEditarJSP".equals(request.getRequestURI()))
		{
			//recibir el parametro
			String idString = request.getParameter("id");
			Integer id = new Integer(idString);
			
			//obtener la empresa
			Empresa e = empresaService.getEmpresaByID(id);
			
			//añadir empresa a la respuesta
			request.setAttribute("empresa", e);
			 
			request.getRequestDispatcher("/WEB-INF/views/empresa/EditarEmpresa.jsp").forward(request, response);
			
			
			
			
		}//ELIMINAR UNA EMPRESA
		else if("/M2ACTIVIDAD4/EliminarUnaEmpresa".equals(request.getRequestURI()))
		{
			//recibir el parametro
			String idString = request.getParameter("id");
			Integer id = new Integer(idString);
						
			//obtener empresa
			Empresa e = empresaService.getEmpresaByID(id);
			
			//eliminar la empresa	
			empresaService.eliminarEmpresa(e);
			
			//redirigir a la pagina principal esando el mapping
			request.getRequestDispatcher("MostrarPantallaPrincipal").forward(request, response);
			
		}//INSERTAR UNA EMPRESA
		else if("/M2ACTIVIDAD4/InsertarUnaEmpresa".equals(request.getRequestURI()))
		{
			//recibir parametros
			String nombre = request.getParameter("nombre");
			String cif = request.getParameter("cif");
			String direccion = request.getParameter("direccion");
			String pais = request.getParameter("pais");
			
			//Crear obj Empresa
			Empresa e = new Empresa();
			//se asigna un valor al id, pero luego el service le dara el valor que le corresponde (max +1)
			e.setIdEmpresa(1);
			e.setNombre(nombre);
			e.setCif(cif);
			e.setDireccion(direccion);
			e.setPais(pais);
			
			//insertar empresa con el servicio
			empresaService.anadirEmpresa(e);
			
			//redirigir a la pagina principal esando el mapping
			request.getRequestDispatcher("MostrarPantallaPrincipal").forward(request, response);
		}
		else if("/M2ACTIVIDAD4/ModificarUnaEmpresa".equals(request.getRequestURI()))
		{
			//recibir parametros
			String idString = request.getParameter("id");
			Integer id = new Integer(idString);
			String nombre = request.getParameter("nombre");
			String cif = request.getParameter("cif");
			String direccion = request.getParameter("direccion");
			String pais = request.getParameter("pais");
						
			//obtener la empresa que se quiere modificar
			Empresa e = empresaService.getEmpresaByID(id);
			//modificar en el objeto os valores, menos el id
			e.setNombre(nombre);
			e.setCif(cif);
			e.setDireccion(direccion);
			e.setPais(pais);
			
			//modificar la empresa	
			empresaService.modificarEmpresa(e);
			
			//redirigir a la pagina principal esando el mapping
			request.getRequestDispatcher("MostrarPantallaPrincipal").forward(request, response);
			
		}
		else
		{
			//POR DEFECTO
			List<Empresa> listaEmpresas = empresaService.getEmpresas();
			request.setAttribute("listaEmpresas", listaEmpresas);
			
			request.getRequestDispatcher("/WEB-INF/views/empresa/PantallaPrincipal.jsp")
			.forward(request, response);
		}
		

		
	}

}
