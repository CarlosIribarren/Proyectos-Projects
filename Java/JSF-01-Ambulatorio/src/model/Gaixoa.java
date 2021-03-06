package model;
// Generated 08-ene-2013 2:46:33 by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Gaixoa generated by hbm2java
 */
public class Gaixoa  implements java.io.Serializable {


     private Integer gaixozenbakia;
     private Sendagilea sendagilea;
     private String dni;
     private String izena;
     private String abizena;
     private String helbidea;
     private String tlf;
     private Date jaiotzedata;
     private Set<Episodioa> episodioas = new HashSet<Episodioa>(0);
     private Set<CitaSendagile> citaSendagiles = new HashSet<CitaSendagile>(0);
     private Set<Kontsulta> kontsultas = new HashSet<Kontsulta>(0);
     private Set<Froga> frogas = new HashSet<Froga>(0);

    public Gaixoa() {
    }

	
    public Gaixoa(Sendagilea sendagilea) {
        this.sendagilea = sendagilea;
    }
    public Gaixoa(Sendagilea sendagilea, String dni, String izena, String abizena, String helbidea, String tlf, Date jaiotzedata, Set<Episodioa> episodioas, Set<CitaSendagile> citaSendagiles, Set<Kontsulta> kontsultas, Set<Froga> frogas) {
       this.sendagilea = sendagilea;
       this.dni = dni;
       this.izena = izena;
       this.abizena = abizena;
       this.helbidea = helbidea;
       this.tlf = tlf;
       this.jaiotzedata = jaiotzedata;
       this.episodioas = episodioas;
       this.citaSendagiles = citaSendagiles;
       this.kontsultas = kontsultas;
       this.frogas = frogas;
    }
   
    public Integer getGaixozenbakia() {
        return this.gaixozenbakia;
    }
    
    public void setGaixozenbakia(Integer gaixozenbakia) {
        this.gaixozenbakia = gaixozenbakia;
    }
    public Sendagilea getSendagilea() {
        return this.sendagilea;
    }
    
    public void setSendagilea(Sendagilea sendagilea) {
        this.sendagilea = sendagilea;
    }
    public String getDni() {
        return this.dni;
    }
    
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getIzena() {
        return this.izena;
    }
    
    public void setIzena(String izena) {
        this.izena = izena;
    }
    public String getAbizena() {
        return this.abizena;
    }
    
    public void setAbizena(String abizena) {
        this.abizena = abizena;
    }
    public String getHelbidea() {
        return this.helbidea;
    }
    
    public void setHelbidea(String helbidea) {
        this.helbidea = helbidea;
    }
    public String getTlf() {
        return this.tlf;
    }
    
    public void setTlf(String tlf) {
        this.tlf = tlf;
    }
    public Date getJaiotzedata() {
        return this.jaiotzedata;
    }
    
    public void setJaiotzedata(Date jaiotzedata) {
        this.jaiotzedata = jaiotzedata;
    }
    public Set<Episodioa> getEpisodioas() {
        return this.episodioas;
    }
    
    public void setEpisodioas(Set<Episodioa> episodioas) {
        this.episodioas = episodioas;
    }
    public Set<CitaSendagile> getCitaSendagiles() {
        return this.citaSendagiles;
    }
    
    public void setCitaSendagiles(Set<CitaSendagile> citaSendagiles) {
        this.citaSendagiles = citaSendagiles;
    }
    public Set<Kontsulta> getKontsultas() {
        return this.kontsultas;
    }
    
    public void setKontsultas(Set<Kontsulta> kontsultas) {
        this.kontsultas = kontsultas;
    }
    public Set<Froga> getFrogas() {
        return this.frogas;
    }
    
    public void setFrogas(Set<Froga> frogas) {
        this.frogas = frogas;
    }




}


