package com.aena.web;
import com.aena.domain.Pasajero;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/pasajeroes")
@Controller
@RooWebScaffold(path = "pasajeroes", formBackingObject = Pasajero.class)
public class PasajeroController {
}
