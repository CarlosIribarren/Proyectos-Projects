package net.hge.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.hge.beans.Modelo;
import net.hge.dao.ModeloDao;
import net.hge.facade.ModeloFacade;


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
