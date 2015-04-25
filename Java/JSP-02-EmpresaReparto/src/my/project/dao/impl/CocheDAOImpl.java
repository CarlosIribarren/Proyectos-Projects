package my.project.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import my.project.dao.CocheDAO;
import my.project.database.ConnectionFactory;
import my.project.database.DatabaseUtil;
import my.project.model.Coche;

public class CocheDAOImpl implements CocheDAO {

	public CocheDAOImpl() {}
	
	@Override
	public List<Coche> findAll() {
		String query = "SELECT * FROM Coche";
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;

		List<Coche> Coches = new ArrayList<Coche>();
		try {
			connection = ConnectionFactory.getConnection();
			st = connection.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()){
				Coche Coche = new Coche();
				Coche.setMatricula(rs.getString("matricula"));
				Coche.setNumeroPlazas(rs.getInt("numeroPlazas"));
				//Coche.setCif(rs.getString("cif"));
				//Coche.setNombre(rs.getString("nombre"));				
				Coches.add(Coche);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseUtil.close(rs);
			DatabaseUtil.close(st);
			DatabaseUtil.close(connection);
		}
		return Coches;
	}

	@Override
	public Coche getById(String id) {
		String query = "SELECT * FROM Coche WHERE matricula = ?";
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Coche Coche = new Coche();
		
		try {
			connection = ConnectionFactory.getConnection();
			ps = connection.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				Coche.setMatricula(rs.getString("matricula"));
				Coche.setNumeroPlazas(rs.getInt("numeroPlazas"));
				//Coche.setCif(rs.getString("cif"));
				//Coche.setNombre(rs.getString("nombre"));	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseUtil.close(rs);
			DatabaseUtil.close(ps);
			DatabaseUtil.close(connection);
		}
		
		return Coche;
	}

	@Override
	public ArrayList<Coche> obtenerCochesPorEmpresaID(Integer id) {
		
		//preparar respuesta
		ArrayList<Coche> coches = new ArrayList<Coche>();
		
		String queryCoches ="SELECT  C.matricula, C.numeroPlazas FROM empresa AS EM, coche AS C WHERE EM.idEmpresa = ? AND C.idEmpresa=EM.idEmpresa";
		
		Connection connection = null;
		PreparedStatement psCoche = null;
		ResultSet rsCoche = null;


		try {
			connection = ConnectionFactory.getConnection();
			psCoche = connection.prepareStatement(queryCoches);
			psCoche.setInt(1, id);
			rsCoche = psCoche.executeQuery();
			while (rsCoche.next()) {
				Coche c1 = new Coche();
				c1.setMatricula(rsCoche.getString("matricula"));
				c1.setNumeroPlazas(rsCoche.getInt("numeroPlazas"));
				//FALTARIA EMPLEADO
				//aladir el coche
				coches.add(c1);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseUtil.close(rsCoche);
			DatabaseUtil.close(psCoche);
			DatabaseUtil.close(connection);
		}
		
		return coches;
		
	}

	@Override
	public Integer obtenerMaxID() {
		//Presparar respuesta
		Integer maxID=0;
		
		String query = "SELECT MAX(idCoche) as maximo FROM coche";
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

	@Override
	public void insertarCoche(Coche c) {
		String query = "insert into coche values(?,?,?,?,?,?,?)";
		Connection connection = null;
		PreparedStatement ps = null;

		try {
			connection = ConnectionFactory.getConnection();
			ps = connection.prepareStatement(query);
			// ----------PREPARAR CONSULTA-----------------
			ps.setInt(1, c.getIdCoche());
			ps.setString(2, c.getMatricula());
			ps.setString(3, c.getModelo());
			ps.setString(4, c.getMarca());
			ps.setInt(5, c.getNumeroPlazas());
			//añadir empleado asignado
			ps.setInt(6, c.getEmpleadoAsigando().getIdEmpleado());
			//añadir empresa a la que pertenece
			ps.setInt(6, c.getEmpresa().getIdEmpresa());
			
			int insert = ps.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			DatabaseUtil.close(ps);
			DatabaseUtil.close(connection);
		}
		
	}


}
