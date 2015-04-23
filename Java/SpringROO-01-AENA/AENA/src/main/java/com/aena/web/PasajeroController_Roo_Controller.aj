// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.aena.web;

import com.aena.domain.Pasajero;
import com.aena.domain.Usuario;
import com.aena.domain.Vuelo;
import com.aena.web.PasajeroController;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.joda.time.format.DateTimeFormat;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

privileged aspect PasajeroController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String PasajeroController.create(@Valid Pasajero pasajero, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, pasajero);
            return "pasajeroes/create";
        }
        uiModel.asMap().clear();
        pasajero.persist();
        return "redirect:/pasajeroes/" + encodeUrlPathSegment(pasajero.getIdPasajero().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", produces = "text/html")
    public String PasajeroController.createForm(Model uiModel) {
        populateEditForm(uiModel, new Pasajero());
        return "pasajeroes/create";
    }
    
    @RequestMapping(value = "/{idPasajero}", produces = "text/html")
    public String PasajeroController.show(@PathVariable("idPasajero") Integer idPasajero, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("pasajero", Pasajero.findPasajero(idPasajero));
        uiModel.addAttribute("itemId", idPasajero);
        return "pasajeroes/show";
    }
    
    @RequestMapping(produces = "text/html")
    public String PasajeroController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("pasajeroes", Pasajero.findPasajeroEntries(firstResult, sizeNo, sortFieldName, sortOrder));
            float nrOfPages = (float) Pasajero.countPasajeroes() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("pasajeroes", Pasajero.findAllPasajeroes(sortFieldName, sortOrder));
        }
        addDateTimeFormatPatterns(uiModel);
        return "pasajeroes/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String PasajeroController.update(@Valid Pasajero pasajero, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, pasajero);
            return "pasajeroes/update";
        }
        uiModel.asMap().clear();
        pasajero.merge();
        return "redirect:/pasajeroes/" + encodeUrlPathSegment(pasajero.getIdPasajero().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{idPasajero}", params = "form", produces = "text/html")
    public String PasajeroController.updateForm(@PathVariable("idPasajero") Integer idPasajero, Model uiModel) {
        populateEditForm(uiModel, Pasajero.findPasajero(idPasajero));
        return "pasajeroes/update";
    }
    
    @RequestMapping(value = "/{idPasajero}", method = RequestMethod.DELETE, produces = "text/html")
    public String PasajeroController.delete(@PathVariable("idPasajero") Integer idPasajero, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Pasajero pasajero = Pasajero.findPasajero(idPasajero);
        pasajero.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/pasajeroes";
    }
    
    void PasajeroController.addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("pasajero_horaenbarque_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }
    
    void PasajeroController.populateEditForm(Model uiModel, Pasajero pasajero) {
        uiModel.addAttribute("pasajero", pasajero);
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("usuarios", Usuario.findAllUsuarios());
        uiModel.addAttribute("vueloes", Vuelo.findAllVueloes());
    }
    
    String PasajeroController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
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
