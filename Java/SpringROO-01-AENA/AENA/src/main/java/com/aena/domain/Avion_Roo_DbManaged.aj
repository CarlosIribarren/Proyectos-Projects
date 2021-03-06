// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.aena.domain;

import com.aena.domain.Avion;
import com.aena.domain.Empresa;
import com.aena.domain.Vuelo;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

privileged aspect Avion_Roo_DbManaged {
    
    @OneToMany(mappedBy = "idAvion")
    private Set<Vuelo> Avion.vueloes;
    
    @ManyToOne
    @JoinColumn(name = "idEmpresa", referencedColumnName = "idEmpresa")
    private Empresa Avion.idEmpresa;
    
    @Column(name = "matricula", length = 40)
    private String Avion.matricula;
    
    @Column(name = "modelo", length = 40)
    private String Avion.modelo;
    
    @Column(name = "numeroPlazas")
    private Integer Avion.numeroPlazas;
    
    public Set<Vuelo> Avion.getVueloes() {
        return vueloes;
    }
    
    public void Avion.setVueloes(Set<Vuelo> vueloes) {
        this.vueloes = vueloes;
    }
    
    public Empresa Avion.getIdEmpresa() {
        return idEmpresa;
    }
    
    public void Avion.setIdEmpresa(Empresa idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
    
    public String Avion.getMatricula() {
        return matricula;
    }
    
    public void Avion.setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    public String Avion.getModelo() {
        return modelo;
    }
    
    public void Avion.setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    public Integer Avion.getNumeroPlazas() {
        return numeroPlazas;
    }
    
    public void Avion.setNumeroPlazas(Integer numeroPlazas) {
        this.numeroPlazas = numeroPlazas;
    }
    
}
