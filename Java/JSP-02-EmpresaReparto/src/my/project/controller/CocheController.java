package my.project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import my.project.model.Empresa;

//Añadimos los maping
@WebServlet(urlPatterns = { 
		"/InsertarUnaCoche"
		

})

public class CocheController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	
	

    public CocheController() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if("/M2ACTIVIDAD4/InsertarUnaEmpresa".equals(request.getRequestURI()))
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
			//empresaService.anadirEmpresa(e);
			
			//redirigir a la pagina principal esando el mapping
			request.getRequestDispatcher("MostrarPantallaPrincipal").forward(request, response);
		}
		
		
	}

}
