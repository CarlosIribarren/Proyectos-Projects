package aena.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aena.dao.AeropuertoDAO;
import aena.dao.impl.AeropuertoDAOImpl;
import aena.model.Aeropuerto;

//Añadimos los maping
@WebServlet(urlPatterns = { "/hasiera"})

public class InicioController extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public InicioController() {
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//redirigir a la pagina principal esando el mapping
		/*
		AeropuertoDAO aeropuertoDAO = new AeropuertoDAOImpl();
		Aeropuerto aeropuerto1 = aeropuertoDAO.findById(1);
		Aeropuerto aeropuerto2 = aeropuertoDAO.findById(2);
		
		request.setAttribute("aeropuerto1", aeropuerto1);
		request.setAttribute("aeropuerto2", aeropuerto2);
		*/
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
