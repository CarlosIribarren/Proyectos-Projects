// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.aena.domain;

import com.aena.domain.Aeropuerto;
import com.aena.domain.Avion;
import com.aena.domain.Pasajero;
import com.aena.domain.Puerta;
import com.aena.domain.Reserva;
import com.aena.domain.Vuelo;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

privileged aspect Vuelo_Roo_DbManaged {
    
    @OneToMany(mappedBy = "idVuelo")
    private Set<Pasajero> Vuelo.pasajeroes;
    
    @OneToMany(mappedBy = "idVuelo")
    private Set<Reserva> Vuelo.reservas;
    
    @ManyToOne
    @JoinColumn(name = "idAvion", referencedColumnName = "idAvion")
    private Avion Vuelo.idAvion;
    
    @ManyToOne
    @JoinColumn(name = "idPuertaSalida", referencedColumnName = "idPuerta")
    private Puerta Vuelo.idPuertaSalida;
    
    @ManyToOne
    @JoinColumn(name = "idPuertaLlegada", referencedColumnName = "idPuerta")
    private Puerta Vuelo.idPuertaLlegada;
    
    @ManyToOne
    @JoinColumn(name = "idAeropuertoSalida", referencedColumnName = "idAeropuerto")
    private Aeropuerto Vuelo.idAeropuertoSalida;
    
    @ManyToOne
    @JoinColumn(name = "idAeropuertoLlegada", referencedColumnName = "idAeropuerto")
    private Aeropuerto Vuelo.idAeropuertoLlegada;
    
    @Column(name = "nombre", length = 40)
    private String Vuelo.nombre;
    
    @Column(name = "horaSalida")
    @Temporal(TemporalType.TIME)
    @DateTimeFormat(style = "M-")
    private Date Vuelo.horaSalida;
    
    @Column(name = "horaLlegada")
    @Temporal(TemporalType.TIME)
    @DateTimeFormat(style = "M-")
    private Date Vuelo.horaLlegada;
    
    public Set<Pasajero> Vuelo.getPasajeroes() {
        return pasajeroes;
    }
    
    public void Vuelo.setPasajeroes(Set<Pasajero> pasajeroes) {
        this.pasajeroes = pasajeroes;
    }
    
    public Set<Reserva> Vuelo.getReservas() {
        return reservas;
    }
    
    public void Vuelo.setReservas(Set<Reserva> reservas) {
        this.reservas = reservas;
    }
    
    public Avion Vuelo.getIdAvion() {
        return idAvion;
    }
    
    public void Vuelo.setIdAvion(Avion idAvion) {
        this.idAvion = idAvion;
    }
    
    public Puerta Vuelo.getIdPuertaSalida() {
        return idPuertaSalida;
    }
    
    public void Vuelo.setIdPuertaSalida(Puerta idPuertaSalida) {
        this.idPuertaSalida = idPuertaSalida;
    }
    
    public Puerta Vuelo.getIdPuertaLlegada() {
        return idPuertaLlegada;
    }
    
    public void Vuelo.setIdPuertaLlegada(Puerta idPuertaLlegada) {
        this.idPuertaLlegada = idPuertaLlegada;
    }
    
    public Aeropuerto Vuelo.getIdAeropuertoSalida() {
        return idAeropuertoSalida;
    }
    
    public void Vuelo.setIdAeropuertoSalida(Aeropuerto idAeropuertoSalida) {
        this.idAeropuertoSalida = idAeropuertoSalida;
    }
    
    public Aeropuerto Vuelo.getIdAeropuertoLlegada() {
        return idAeropuertoLlegada;
    }
    
    public void Vuelo.setIdAeropuertoLlegada(Aeropuerto idAeropuertoLlegada) {
        this.idAeropuertoLlegada = idAeropuertoLlegada;
    }
    
    public String Vuelo.getNombre() {
        return nombre;
    }
    
    public void Vuelo.setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Date Vuelo.getHoraSalida() {
        return horaSalida;
    }
    
    public void Vuelo.setHoraSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
    }
    
    public Date Vuelo.getHoraLlegada() {
        return horaLlegada;
    }
    
    public void Vuelo.setHoraLlegada(Date horaLlegada) {
        this.horaLlegada = horaLlegada;
    }
    
}
