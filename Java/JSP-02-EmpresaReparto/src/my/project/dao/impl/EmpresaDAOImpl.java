package my.project.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import my.project.dao.CocheDAO;
import my.project.dao.EmpleadoDAO;
import my.project.dao.EmpresaDAO;
import my.project.database.ConnectionFactory;
import my.project.database.DatabaseUtil;
import my.project.model.Coche;
import my.project.model.Empleado;
import my.project.model.Empresa;

public class EmpresaDAOImpl implements EmpresaDAO {

	EmpleadoDAO empleadoDAO = new EmpleadoDAOImpl();
	CocheDAO cocheDAO = new CocheDAOImpl();
	
	public EmpresaDAOImpl() {
	}

	@Override
	public List<Empresa> findAll() {
		String query = "SELECT * FROM empresa";
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;

		List<Empresa> listaEmpresas = new ArrayList<Empresa>();
		try {
			connection = ConnectionFactory.getConnection();
			st = connection.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				Empresa empresa = new Empresa();
				empresa.setIdEmpresa(rs.getInt("idEmpresa"));
				empresa.setNombre(rs.getString("nombre"));
				empresa.setCif(rs.getString("cif"));
				empresa.setDireccion(rs.getString("direccion"));
				empresa.setPais(rs.getString("pais"));
				listaEmpresas.add(empresa);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseUtil.close(rs);
			DatabaseUtil.close(st);
			DatabaseUtil.close(connection);
		}
		return listaEmpresas;
	}

	@Override
	public Empresa getById(Integer id) {
		
		//CONSULTA GENERAL => SELECT E.nombre, E.fechaNacimiento, E.edad, E.nombreJefe, C.matricula, C.numeroPlazas FROM empresa AS EM, empleadoEmpresa AS EE, empleado AS E, coche AS C WHERE EE.cif = 1 AND EE.nombre=E.nombre AND EM.cif=C.cif AND EE.cif=EM.cif
		
		
		//OBTENER DATOS DE LA EMPRESA
		
		String queryDatosEmpresa = "SELECT idEmpresa, cif, nombre, direccion, pais FROM empresa  WHERE idEmpresa = ?";
		
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Empresa empresa = new Empresa();
		try {
			connection = ConnectionFactory.getConnection();
			ps = connection.prepareStatement(queryDatosEmpresa);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				empresa.setIdEmpresa(rs.getInt("idEmpresa"));
				empresa.setNombre(rs.getString("nombre"));
				empresa.setCif(rs.getString("cif"));
				empresa.setDireccion(rs.getString("direccion"));
				empresa.setPais(rs.getString("pais"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseUtil.close(rs);
			DatabaseUtil.close(ps);;
		}
		
		
		//OBTENER EMPLEADOS
		ArrayList<Empleado> empleados = empleadoDAO.obtenerEmpleadosPorEmpresaID(id);
		//añadir empleados al la empresa
		empresa.setListaEmpleados(empleados);
		
		//OBTENER COCHES
		ArrayList<Coche> coches = cocheDAO.obtenerCochesPorEmpresaID(id);
		//añadir coches al  resultado
		empresa.setListaCoches(coches);

		return empresa;
	}


	@Override
	public void insertEmpresa(Empresa e) {
		String query = "insert into empresa values(?,?,?,?,?)";
		Connection connection = null;
		PreparedStatement ps = null;

		try {
			connection = ConnectionFactory.getConnection();
			ps = connection.prepareStatement(query);
			// ----------PREPARAR CONSULTA-----------------
			ps.setInt(1, e.getIdEmpresa());
			ps.setString(2, e.getNombre());
			ps.setString(3, e.getCif());
			ps.setString(4, e.getDireccion());
			ps.setString(5, e.getPais());
			
			int insert = ps.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			DatabaseUtil.close(ps);
			DatabaseUtil.close(connection);
		}

	}

	@Override
	public void updateEmpresa(Empresa e) {

		//NOTA : el id no se modifica
		
		String query = "UPDATE empresa SET nombre=?, cif=?, direccion=?, pais=? WHERE idEmpresa = ?";
		Connection connection = null;
		PreparedStatement ps = null;

		try {
			connection = ConnectionFactory.getConnection();
			ps = connection.prepareStatement(query);
			// ----------PREPARAR CONSULTA-----------------

			ps.setString(1, e.getNombre());
			ps.setString(2, e.getCif());
			ps.setString(3, e.getDireccion() );
			ps.setString(4, e.getPais());
			ps.setInt(5, e.getIdEmpresa());

			int update = ps.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			DatabaseUtil.close(ps);
			DatabaseUtil.close(connection);
		}

	}

	@Override
	public void deleteEmpresa(Empresa e) {

		// RECIBIR NOMBRE
		Integer id = e.getIdEmpresa();

		String query = "DELETE FROM empresa WHERE idEmpresa = ?";
		Connection connection = null;
		PreparedStatement ps = null;

		try {
			connection = ConnectionFactory.getConnection();
			ps = connection.prepareStatement(query);
			// ----------PREPARAR CONSULTA-----------------

			ps.setInt(1, id);

			int delete = ps.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			DatabaseUtil.close(ps);
			DatabaseUtil.close(connection);
		}
	}

	@Override
	public Integer obtenerMaxID() {
		//Presparar respuesta
		Integer maxID=0;
		
		String query = "SELECT MAX(idEmpresa) as maximo FROM empresa";
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			connection = ConnectionFactory.getConnection();
			st = connection.createStatement();
			rs = st.executeQuery(query);
			if (rs.next()) 
			{
				maxID= (rs.getInt("maximo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseUtil.close(rs);
			DatabaseUtil.close(st);
			DatabaseUtil.close(connection);
		}

		return maxID;
	}

	
}
