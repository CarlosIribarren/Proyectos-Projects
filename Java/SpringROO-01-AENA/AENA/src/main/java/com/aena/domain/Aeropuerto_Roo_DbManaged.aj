// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.aena.domain;

import com.aena.domain.Aeropuerto;
import com.aena.domain.Puerta;
import com.aena.domain.Vuelo;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.OneToMany;

privileged aspect Aeropuerto_Roo_DbManaged {
    
    @OneToMany(mappedBy = "idAeropuerto")
    private Set<Puerta> Aeropuerto.puertas;
    
    @OneToMany(mappedBy = "idAeropuertoSalida")
    private Set<Vuelo> Aeropuerto.vueloes;
    
    @OneToMany(mappedBy = "idAeropuertoLlegada")
    private Set<Vuelo> Aeropuerto.vueloes1;
    
    @Column(name = "nombre", length = 40)
    private String Aeropuerto.nombre;
    
    @Column(name = "provincia", length = 40)
    private String Aeropuerto.provincia;
    
    @Column(name = "direccion", length = 40)
    private String Aeropuerto.direccion;
    
    @Column(name = "pais", length = 40)
    private String Aeropuerto.pais;
    
    public Set<Puerta> Aeropuerto.getPuertas() {
        return puertas;
    }
    
    public void Aeropuerto.setPuertas(Set<Puerta> puertas) {
        this.puertas = puertas;
    }
    
    public Set<Vuelo> Aeropuerto.getVueloes() {
        return vueloes;
    }
    
    public void Aeropuerto.setVueloes(Set<Vuelo> vueloes) {
        this.vueloes = vueloes;
    }
    
    public Set<Vuelo> Aeropuerto.getVueloes1() {
        return vueloes1;
    }
    
    public void Aeropuerto.setVueloes1(Set<Vuelo> vueloes1) {
        this.vueloes1 = vueloes1;
    }
    
    public String Aeropuerto.getNombre() {
        return nombre;
    }
    
    public void Aeropuerto.setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String Aeropuerto.getProvincia() {
        return provincia;
    }
    
    public void Aeropuerto.setProvincia(String provincia) {
        this.provincia = provincia;
    }
    
    public String Aeropuerto.getDireccion() {
        return direccion;
    }
    
    public void Aeropuerto.setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public String Aeropuerto.getPais() {
        return pais;
    }
    
    public void Aeropuerto.setPais(String pais) {
        this.pais = pais;
    }
    
}
