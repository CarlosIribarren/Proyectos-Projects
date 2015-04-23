package com.aena.web;
import com.aena.domain.Reserva;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/reservas")
@Controller
@RooWebScaffold(path = "reservas", formBackingObject = Reserva.class)
public class ReservaController {
}
