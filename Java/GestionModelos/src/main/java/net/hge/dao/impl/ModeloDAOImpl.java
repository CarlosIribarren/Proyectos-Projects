package net.hge.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import net.hge.beans.Modelo;
import net.hge.dao.ModeloDao;


@Repository
public class ModeloDAOImpl implements ModeloDao {

  private JdbcTemplate jdbcTemplate;

  public void setDataSource(final DataSource dataSource) {
    this.jdbcTemplate = new JdbcTemplate(dataSource);
  }

  @Override
  public Modelo getModelo(final String numeroModelo) {
    final String SQL = "SELECT MODL_TMOD_COD,MODL_EJERCICIO_INI,MODL_ZERGA, MODL_REG_ACTIVO FROM HZGA30101 WHERE MODL_TMOD_COD IN (?)";
    final Modelo modelo = this.jdbcTemplate.queryForObject(SQL, new Object[] { numeroModelo }, new ModeloMapper());
    return modelo;
  }

  @Override
  public List<Modelo> getModelos() {
    final String SQL = "SELECT MODL_TMOD_COD,MODL_EJERCICIO_INI,MODL_ZERGA, MODL_REG_ACTIVO FROM HZGA30101 ORDER BY MODL_TMOD_COD,MODL_EJERCICIO_INI";
    final List<Modelo> students = this.jdbcTemplate.query(SQL, new ModeloMapper());
    return students;
  }

}
