package com.aena.domain;
import org.springframework.roo.addon.dbre.RooDbManaged;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooJpaActiveRecord(versionField = "", table = "USUARIO")
@RooDbManaged(automaticallyDelete = true)
@RooToString(excludeFields = { "pasajeroes", "reservas" })
public class Usuario {
}
