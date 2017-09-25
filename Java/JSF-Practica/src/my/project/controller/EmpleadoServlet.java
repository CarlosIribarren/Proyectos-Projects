package my.project.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import my.project.model.Empleado;
import my.project.service.EmpleadoService;
import my.project.service.impl.EmpleadoServiceImpl;

public class EmpleadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EmpleadoService empleadoService;

	public EmpleadoServlet() {
		super();
		empleadoService = new EmpleadoServiceImpl();
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println(request.getServletPath());
		System.out.println(request.getPathInfo());

		String funcion = request.getPathInfo();

		String substring = funcion.substring(1);
		if ("GestionEmpleados".equals(substring))
		{
			ArrayList<Empleado> listaEmpleados =  empleadoService.getEmpleados();
			
			request.setAttribute("listaEmpleados", listaEmpleados);
			request.getRequestDispatcher("/WEB-INF/views/empleados/GestionEmpleados.jsp")
					.forward(request, response);
		} 
		else if ("buscarCompleto".equals(substring)) 
		{
			
			//---------- RECIBIR PARAMETROS -----------------------------------
			String numeroEmpleado = request.getParameter("numeroEmpleado");
			Integer numeroEmpleadoInteger=0;
			if (request.getParameter("numeroEmpleado")=="" )
			{
				numeroEmpleadoInteger=null;
			}else
			{
				numeroEmpleadoInteger =new Integer(numeroEmpleado);
			}
			
			Date fechaNacimiento=null;
			if (request.getParameter("fechaNacimiento")!="")
			{
				String fechaNacimientoString = request.getParameter("fechaNacimiento");
				SimpleDateFormat lFormatter = new SimpleDateFormat("dd-MM-yyyy");
				
			    try {
			    	fechaNacimiento = lFormatter.parse(fechaNacimientoString);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	
		    
			String nombre = (request.getParameter("nombre")=="")?null:request.getParameter("nombre");
			String apellido = (request.getParameter("apellido")=="")?null:request.getParameter("apellido");
			String genero = (request.getParameter("genero")=="")?null:request.getParameter("genero");
			
			
			Date fechaContratacion=null;
			if (request.getParameter("fechaContratacion")!="")
			{
				SimpleDateFormat lFormatter2 = new SimpleDateFormat("dd-MM-yyyy");
				String fechaContratacionString = request.getParameter("fechaContratacion");
				
			    try {
			    	fechaContratacion = lFormatter2.parse(fechaContratacionString);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		    
			//-------------- PREPARAR EL OBJETO ----------------------
		    Empleado e1 = new Empleado();
		    
			e1.setNumeroEmpleado(numeroEmpleadoInteger);
			e1.setFechaNacimiento(fechaNacimiento);
			e1.setNombre(nombre);
			e1.setApellido(apellido);
			e1.setGenero(genero);
			e1.setFechaContratacion(fechaContratacion);

			
			ArrayList<Empleado> listaResultadoBuscar = empleadoService.buscarCompleto(e1);
			
			
			//añadir empleado al request
			request.setAttribute("listaEmpleados", listaResultadoBuscar);
			
			//REDIRIGIR
			request.getRequestDispatcher("/WEB-INF/views/empleados/GestionEmpleados.jsp")
					.forward(request, response);
		
		}else if ("add".equals(substring)) 
		{

		} else if ("detalle".equals(substring))
		{

		} else if ("modificar".equals(substring))
		{
			
		} else if ("eliminar".equals(substring))
		{
		
		}
		else
		{
			//SINO ENCUENTRA NINGUN MAPPIN ENTONCES REDIRIGE A LA PANTALLA DE GESTION de empleados
			request.getRequestDispatcher("/WEB-INF/views/empleados/GestionEmpleados.jsp")
			.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	}


}
