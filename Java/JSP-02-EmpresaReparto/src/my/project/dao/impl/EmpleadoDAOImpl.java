package my.project.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import my.project.dao.EmpleadoDAO;
import my.project.database.ConnectionFactory;
import my.project.database.DatabaseUtil;
import my.project.model.Empleado;

public class EmpleadoDAOImpl implements EmpleadoDAO {
    
    public EmpleadoDAOImpl() { }
    
	@Override
	public List<Empleado> findAll() {
		String query = "SELECT * FROM empleado";
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;

		List<Empleado> empleados = new ArrayList<Empleado>();
		try {
			connection = ConnectionFactory.getConnection();
			st = connection.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()){
				Empleado empleado = new Empleado();
				empleado.setNombre(rs.getString("nombre"));
				java.util.Date fecha = rs.getDate("fechaNacimiento");
				empleado.setFechaNacimiento(fecha);
				//empleado.setNombreJefe(rs.getString("nombreJefe"));
				empleados.add(empleado);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseUtil.close(rs);
			DatabaseUtil.close(st);
			DatabaseUtil.close(connection);
		}
		return empleados;
	}

	@Override
	public Empleado getById(String id) {
		String query = "SELECT * FROM empleado WHERE nombre = ?";
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Empleado empleado = new Empleado();
		
		try {
			connection = ConnectionFactory.getConnection();
			ps = connection.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				empleado.setNombre(rs.getString("nombre"));
				java.util.Date fecha = rs.getDate("fechaNacimiento");
				empleado.setFechaNacimiento(fecha);
				//empleado.setNombreJefe(rs.getString("nombreJefe"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseUtil.close(rs);
			DatabaseUtil.close(ps);
			DatabaseUtil.close(connection);
		}
		
		return empleado;
	}

	@Override
	public void insertEmpleado(Empleado e) {
		String query = "insert into empleado values(?,?,?,?)";
		Connection connection = null;
		PreparedStatement ps = null;
		
		try {
			connection = ConnectionFactory.getConnection();
			ps = connection.prepareStatement(query);
			//----------PREPARAR CONSULTA-----------------
			ps.setString(1, e.getNombre());			
			
			//comprobar la fecha que no sea null
			if(e.getFechaNacimiento()==null)
			{
				ps.setDate(2, null);
			}
			else
			{
				ps.setDate(2, new java.sql.Date(e.getFechaNacimiento().getTime()) );
			}
				
			//ps.setString(4, e.getNombreJefe());
			
			int insert = ps.executeUpdate();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			DatabaseUtil.close(ps);
			DatabaseUtil.close(connection);
		}
		
		
	}

	@Override
	public void updateEmpleado(Empleado e) {

		//RECIBIR NOMBRE
		String nombreClave = e.getNombre();
		
		String query = "UPDATE empleado SET fechaNacimiento=?, edad=?, nombreJefe=? WHERE nombre = ?";
		Connection connection = null;
		PreparedStatement ps = null;
		
		try {
			connection = ConnectionFactory.getConnection();
			ps = connection.prepareStatement(query);
			//----------PREPARAR CONSULTA-----------------
			
			//comprobar la fecha que no sea null
			if(e.getFechaNacimiento()==null)
			{
				ps.setDate(1, null);
			}
			else
			{
				ps.setDate(1, new java.sql.Date(e.getFechaNacimiento().getTime()) );
			}

			//ps.setString(3, e.getNombreJefe());
			
			ps.setString(4, nombreClave);			
			
			int update = ps.executeUpdate();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			DatabaseUtil.close(ps);
			DatabaseUtil.close(connection);
		}
		
	}

	@Override
	public void deleteEmpleado(Empleado e) {

		//RECIBIR NOMBRE
		String nombreClave = e.getNombre();
		
		String query = "DELETE FROM  empleado WHERE nombre = ?";
		Connection connection = null;
		PreparedStatement ps = null;
		
		try {
			connection = ConnectionFactory.getConnection();
			ps = connection.prepareStatement(query);
			//----------PREPARAR CONSULTA-----------------
		
			ps.setString(1, nombreClave);			
			
			int delete = ps.executeUpdate();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			DatabaseUtil.close(ps);
			DatabaseUtil.close(connection);
		}
		
		
		
	}

	@Override
	public ArrayList<Empleado> obtenerEmpleadosPorEmpresaID(Integer id) {
		//preparar respuesta
		ArrayList<Empleado> empleados= new ArrayList<Empleado>();
		
		String queryEmpleados ="SELECT E.nombre, E.fechaNacimiento, E.nombreJefe FROM empleadoEmpresa AS EE, empleado AS E  WHERE EE.idEmpresa = ? AND EE.idEmpleado=E.idEmpleado";
		
		Connection connection = null;
		PreparedStatement psEmpleados = null;
		ResultSet rsEmpleados = null;
		
		try {
			connection = ConnectionFactory.getConnection();
			psEmpleados = connection.prepareStatement(queryEmpleados);
			psEmpleados.setInt(1, id);
			rsEmpleados = psEmpleados.executeQuery();
			while (rsEmpleados.next()) {
				Empleado e1 = new Empleado();
				e1.setNombre(rsEmpleados.getString("nombre"));
				e1.setFechaNacimiento(rsEmpleados.getDate("fechaNacimiento"));
				//FALTA AÑADIR EL JEFE
				//añadir empleado a la empresa
				empleados.add(e1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseUtil.close(rsEmpleados);
			DatabaseUtil.close(psEmpleados);;
		}
		
		return empleados;
	}




	

}
