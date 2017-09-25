package my.project.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import my.project.dao.EmpleadoDAO;
import my.project.database.ConnectionFactory;
import my.project.database.DatabaseUtil;
import my.project.model.Empleado;

public class EmpleadoDAOImpl implements EmpleadoDAO {
    
    public EmpleadoDAOImpl() { }

	@Override
	public ArrayList<Empleado> findAll() {

		String query = "SELECT emp_no , birth_date, first_name, last_name, gender, hire_date FROM employees limit 10";
		Connection connection = null;
		Statement stEmpleados = null;
		ResultSet rsEmpleados = null;

		ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();
		try {
			connection = ConnectionFactory.getConnection();
			stEmpleados = connection.createStatement();
			rsEmpleados = stEmpleados.executeQuery(query);
			while (rsEmpleados.next()) {
				Empleado empleado = new Empleado();
				//obtener datos 
				empleado.setNumeroEmpleado(rsEmpleados.getInt("emp_no"));
				//fechaNacimiento
				//------ OBTENER FECHA JOSE  ---------------
				
				java.sql.Date fecha = rsEmpleados.getDate("birth_date");
				if(fecha!=null)
				{
					Date fechaTipoUtil = new Date(fecha.getTime());
					empleado.setFechaNacimiento(fechaTipoUtil);
				}
				else
				{
					empleado.setFechaNacimiento(null);
				}	
				//-------------------------------------------
				
				empleado.setNombre(rsEmpleados.getString("first_name"));
				empleado.setApellido((rsEmpleados.getString("last_name")));
				empleado.setGenero((rsEmpleados.getString("gender")));
				//fechaContratacionFin
				//------ OBTENER FECHA JOSE  ---------------
				
				java.sql.Date fechaContrato = rsEmpleados.getDate("hire_date");
				if(fechaContrato!=null)
				{
					Date fechaTipoUtil = new Date(fechaContrato.getTime());
					empleado.setFechaContratacion(fechaTipoUtil);
				}
				else
				{
					empleado.setFechaContratacion(null);
				}	
				//-------------------------------------------
				//añadir empleado a la lista
				listaEmpleados.add(empleado);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseUtil.close(rsEmpleados);
			DatabaseUtil.close(stEmpleados);
			DatabaseUtil.close(connection);
		}
		return listaEmpleados;
	}

	@Override
	public Empleado getById(String id) {

		return null;
	}

	@Override
	public void insertar(Empleado e) {

		
	}

	@Override
	public void modificar(Empleado e) {

		
	}

	@Override
	public void eliminar(Empleado e) {

		
	}

	@Override
	public ArrayList<Empleado> findComplex(Empleado e1) {

		//mirar como viene de relleno el empleado y en funcion de eso
		// montar la sql compleja
		
		String baseQuery = "SELECT emp_no , birth_date, first_name, last_name, gender, hire_date FROM employees WHERE 1=1";
		//NUMERO EMPLEADO
		String queryNumeroEmpleado = "";
		if (e1.getNumeroEmpleado()!=null)
		{
			queryNumeroEmpleado=" AND emp_no="+ e1.getNumeroEmpleado() + " ";
		}
		//fechaNacimiento
		String queryFechaNacimiento = "";
		if (e1.getFechaNacimiento()!=null)
		{
			//comvertir de util a sql
			Date f = e1.getFechaNacimiento();
			java.sql.Date fSQL = new java.sql.Date(f.getTime());
			queryFechaNacimiento=" AND birth_date='"+ fSQL + "' ";
		}
		//nombre
		String queryNombre = "";
		if (e1.getNombre()!=null)
		{
			queryNombre=" AND first_name='"+ e1.getNombre() +"' ";
		}
		//apellido
		String queryApellido = "";
		if (e1.getApellido()!=null)
		{
			queryApellido=" AND last_name='"+ e1.getApellido() + "' ";
		}
		//genero
		String queryGenero = "";
		if (e1.getGenero()!=null)
		{
			queryGenero=" AND gender='"+ e1.getGenero() + "' ";
		}
		//fechaContratacion
		String queryFechaContratacion = "";
		if (e1.getFechaContratacion()!=null)
		{
			Date f = e1.getFechaContratacion();
			java.sql.Date fSQL = new java.sql.Date(f.getTime());
			queryFechaContratacion=" AND hire_date='"+ fSQL + "' ";
		}
		
		String query = baseQuery+
				queryNumeroEmpleado+
				queryFechaNacimiento+
				queryNombre+
				queryApellido+
				queryGenero+
				queryFechaContratacion;
		
		System.out.println(query);
		//-----------------EJECUTAR SQL ------------------
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;
		
		ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();
		try {
			connection = ConnectionFactory.getConnection();
			st = connection.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				Empleado empleado = new Empleado();
				//obtener datos 
				empleado.setNumeroEmpleado(rs.getInt("emp_no"));
				//fechaNacimiento
				//------ OBTENER FECHA JOSE  ---------------
				
				java.sql.Date fecha = rs.getDate("birth_date");
				if(fecha!=null)
				{
					Date fechaTipoUtil = new Date(fecha.getTime());
					empleado.setFechaNacimiento(fechaTipoUtil);
				}
				else
				{
					empleado.setFechaNacimiento(null);
				}	
				//-------------------------------------------
				
				empleado.setNombre(rs.getString("first_name"));
				empleado.setApellido((rs.getString("last_name")));
				empleado.setGenero((rs.getString("gender")));
				//fechaContratacionFin
				//------ OBTENER FECHA JOSE  ---------------
				
				java.sql.Date fechaContrato = rs.getDate("hire_date");
				if(fechaContrato!=null)
				{
					Date fechaTipoUtil = new Date(fechaContrato.getTime());
					empleado.setFechaContratacion(fechaTipoUtil);
				}
				else
				{
					empleado.setFechaContratacion(null);
				}	
				//-------------------------------------------
				//añadir empleado a la lista
				listaEmpleados.add(empleado);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseUtil.close(rs);
			DatabaseUtil.close(st);
			DatabaseUtil.close(connection);
		}
		return listaEmpleados;
		
	}
  

}
