package com.aena.web;
import com.aena.domain.Vuelo;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/vueloes")
@Controller
@RooWebScaffold(path = "vueloes", formBackingObject = Vuelo.class)
public class VueloController {
}
