// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.aena.domain;

import com.aena.domain.Avion;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

privileged aspect Avion_Roo_Jpa_Entity {
    
    declare @type: Avion: @Entity;
    
    declare @type: Avion: @Table(name = "AVION");
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idAvion")
    private Integer Avion.idAvion;
    
    public Integer Avion.getIdAvion() {
        return this.idAvion;
    }
    
    public void Avion.setIdAvion(Integer id) {
        this.idAvion = id;
    }
    
}