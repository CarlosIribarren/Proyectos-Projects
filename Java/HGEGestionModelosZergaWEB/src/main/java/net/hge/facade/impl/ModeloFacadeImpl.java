package net.eurohelp.hge.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.eurohelp.hge.beans.Modelo;
import net.eurohelp.hge.dao.ModeloDao;
import net.eurohelp.hge.facade.ModeloFacade;


@Service
public class ModeloFacadeImpl implements ModeloFacade {

  @Autowired
  private ModeloDao modeloDAO;

  @Override
  public Modelo getModelo(final String numeroModelo) {
    return null;
  }

  @Override
  public List<Modelo> getModelos() {
    return null;
  }

}
