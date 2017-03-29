package net.eurohelp.hge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.eurohelp.hge.facade.ModeloFacade;
import net.eurohelp.hge.facade.impl.ModeloFacadeImpl;


@Controller
public class ModelosController {

  private final ModeloFacade modeloFacade = new ModeloFacadeImpl();

  @RequestMapping(value = "/")
  public String inicio(final Model model) {
    // Obtener lista de modelos
    model.addAttribute("modelos", this.modeloFacade.getModelos());
    return "inicio";
  }

}
