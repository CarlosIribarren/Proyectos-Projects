package model;
// Generated 08-ene-2013 2:46:33 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Episodioa generated by hbm2java
 */
public class Episodioa  implements java.io.Serializable {


     private Integer episodiozenbakia;
     private Gaixoa gaixoa;
     private Kontsulta kontsulta;
     private String deskribapena;
     private String larritasuna;
     private Set<Tratamendua> tratamenduas = new HashSet<Tratamendua>(0);
     private Set<Errezeta> errezetas = new HashSet<Errezeta>(0);
     private Set<Froga> frogas = new HashSet<Froga>(0);

    public Episodioa() {
    }

	
    public Episodioa(Gaixoa gaixoa, Kontsulta kontsulta, String deskribapena, String larritasuna) {
        this.gaixoa = gaixoa;
        this.kontsulta = kontsulta;
        this.deskribapena = deskribapena;
        this.larritasuna = larritasuna;
    }
    public Episodioa(Gaixoa gaixoa, Kontsulta kontsulta, String deskribapena, String larritasuna, Set<Tratamendua> tratamenduas, Set<Errezeta> errezetas, Set<Froga> frogas) {
       this.gaixoa = gaixoa;
       this.kontsulta = kontsulta;
       this.deskribapena = deskribapena;
       this.larritasuna = larritasuna;
       this.tratamenduas = tratamenduas;
       this.errezetas = errezetas;
       this.frogas = frogas;
    }
   
    public Integer getEpisodiozenbakia() {
        return this.episodiozenbakia;
    }
    
    public void setEpisodiozenbakia(Integer episodiozenbakia) {
        this.episodiozenbakia = episodiozenbakia;
    }
    public Gaixoa getGaixoa() {
        return this.gaixoa;
    }
    
    public void setGaixoa(Gaixoa gaixoa) {
        this.gaixoa = gaixoa;
    }
    public Kontsulta getKontsulta() {
        return this.kontsulta;
    }
    
    public void setKontsulta(Kontsulta kontsulta) {
        this.kontsulta = kontsulta;
    }
    public String getDeskribapena() {
        return this.deskribapena;
    }
    
    public void setDeskribapena(String deskribapena) {
        this.deskribapena = deskribapena;
    }
    public String getLarritasuna() {
        return this.larritasuna;
    }
    
    public void setLarritasuna(String larritasuna) {
        this.larritasuna = larritasuna;
    }
    public Set<Tratamendua> getTratamenduas() {
        return this.tratamenduas;
    }
    
    public void setTratamenduas(Set<Tratamendua> tratamenduas) {
        this.tratamenduas = tratamenduas;
    }
    public Set<Errezeta> getErrezetas() {
        return this.errezetas;
    }
    
    public void setErrezetas(Set<Errezeta> errezetas) {
        this.errezetas = errezetas;
    }
    public Set<Froga> getFrogas() {
        return this.frogas;
    }
    
    public void setFrogas(Set<Froga> frogas) {
        this.frogas = frogas;
    }




}

