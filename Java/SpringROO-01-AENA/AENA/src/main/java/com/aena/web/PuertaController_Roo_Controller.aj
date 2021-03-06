// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.aena.web;

import com.aena.domain.Aeropuerto;
import com.aena.domain.Puerta;
import com.aena.domain.Vuelo;
import com.aena.web.PuertaController;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

privileged aspect PuertaController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String PuertaController.create(@Valid Puerta puerta, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, puerta);
            return "puertas/create";
        }
        uiModel.asMap().clear();
        puerta.persist();
        return "redirect:/puertas/" + encodeUrlPathSegment(puerta.getIdPuerta().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", produces = "text/html")
    public String PuertaController.createForm(Model uiModel) {
        populateEditForm(uiModel, new Puerta());
        return "puertas/create";
    }
    
    @RequestMapping(value = "/{idPuerta}", produces = "text/html")
    public String PuertaController.show(@PathVariable("idPuerta") Integer idPuerta, Model uiModel) {
        uiModel.addAttribute("puerta", Puerta.findPuerta(idPuerta));
        uiModel.addAttribute("itemId", idPuerta);
        return "puertas/show";
    }
    
    @RequestMapping(produces = "text/html")
    public String PuertaController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("puertas", Puerta.findPuertaEntries(firstResult, sizeNo, sortFieldName, sortOrder));
            float nrOfPages = (float) Puerta.countPuertas() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("puertas", Puerta.findAllPuertas(sortFieldName, sortOrder));
        }
        return "puertas/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String PuertaController.update(@Valid Puerta puerta, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, puerta);
            return "puertas/update";
        }
        uiModel.asMap().clear();
        puerta.merge();
        return "redirect:/puertas/" + encodeUrlPathSegment(puerta.getIdPuerta().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{idPuerta}", params = "form", produces = "text/html")
    public String PuertaController.updateForm(@PathVariable("idPuerta") Integer idPuerta, Model uiModel) {
        populateEditForm(uiModel, Puerta.findPuerta(idPuerta));
        return "puertas/update";
    }
    
    @RequestMapping(value = "/{idPuerta}", method = RequestMethod.DELETE, produces = "text/html")
    public String PuertaController.delete(@PathVariable("idPuerta") Integer idPuerta, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Puerta puerta = Puerta.findPuerta(idPuerta);
        puerta.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/puertas";
    }
    
    void PuertaController.populateEditForm(Model uiModel, Puerta puerta) {
        uiModel.addAttribute("puerta", puerta);
        uiModel.addAttribute("aeropuertoes", Aeropuerto.findAllAeropuertoes());
        uiModel.addAttribute("vueloes", Vuelo.findAllVueloes());
    }
    
    String PuertaController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
        String enc = httpServletRequest.getCharacterEncoding();
        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        try {
            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
        } catch (UnsupportedEncodingException uee) {}
        return pathSegment;
    }
    
}
