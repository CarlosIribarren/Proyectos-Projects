package net.eurohelp.hge.facade;

import java.util.List;

import net.eurohelp.hge.beans.Modelo;


public interface ModeloFacade {

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
