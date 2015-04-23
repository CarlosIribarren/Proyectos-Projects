package com.aena.web;
import com.aena.domain.Puerta;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/puertas")
@Controller
@RooWebScaffold(path = "puertas", formBackingObject = Puerta.class)
public class PuertaController {
}
