package net.hge.dao;

import java.util.List;

import net.hge.beans.Modelo;


public interface ModeloDao {

  /**
   * Obtiene un modelo dado un numero de modelo.
   *
   * @param numeroModelo
   * @return Retorna un modelo concreto.
   */
  public Modelo getModelo(String numeroModelo);

  /**
   * Obtiene todos los modelos.
   *
   * @return Retorna un listado de todos los modelos.
   */
  public List<Modelo> getModelos();

}
