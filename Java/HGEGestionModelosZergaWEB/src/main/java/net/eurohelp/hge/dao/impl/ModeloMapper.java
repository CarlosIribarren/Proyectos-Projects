package net.eurohelp.hge.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import net.eurohelp.hge.beans.Modelo;


public class ModeloMapper implements RowMapper<Modelo> {

  @Override
  public Modelo mapRow(final ResultSet rs, final int arg1) throws SQLException {
    final Modelo modelo = new Modelo();
    modelo.setModelo(rs.getString("MODL_TMOD_COD"));
    modelo.setEjercicioReal(rs.getInt("MODL_EJERCICIO_INI"));
    modelo.setModl_zerga(rs.getString("MODL_REG_ACTIVO"));
    modelo.setModl_reg_activo(rs.getString("MODL_ZERGA"));
    return modelo;
  }

}
