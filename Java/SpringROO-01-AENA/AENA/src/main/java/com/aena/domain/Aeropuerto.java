package com.aena.domain;
import org.springframework.roo.addon.dbre.RooDbManaged;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooJpaActiveRecord(versionField = "", table = "AEROPUERTO")
@RooDbManaged(automaticallyDelete = true)
@RooToString(excludeFields = { "puertas", "vueloes", "vueloes1" })
public class Aeropuerto {
}
