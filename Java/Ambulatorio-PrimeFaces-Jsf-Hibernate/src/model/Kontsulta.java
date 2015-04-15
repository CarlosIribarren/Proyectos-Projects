package model;
// Generated 08-ene-2013 2:46:33 by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Kontsulta generated by hbm2java
 */
public class Kontsulta  implements java.io.Serializable {


     private Integer kontsultazenbakia;
     private Gaixoa gaixoa;
     private Sendagilea sendagilea;
     private Date data;
     private Date hasiera;
     private String gela;
     private Set<Episodioa> episodioas = new HashSet<Episodioa>(0);

    public Kontsulta() {
    }

	
    public Kontsulta(Gaixoa gaixoa, Sendagilea sendagilea, Date data, Date hasiera, String gela) {
        this.gaixoa = gaixoa;
        this.sendagilea = sendagilea;
        this.data = data;
        this.hasiera = hasiera;
        this.gela = gela;
    }
    public Kontsulta(Gaixoa gaixoa, Sendagilea sendagilea, Date data, Date hasiera, String gela, Set<Episodioa> episodioas) {
       this.gaixoa = gaixoa;
       this.sendagilea = sendagilea;
       this.data = data;
       this.hasiera = hasiera;
       this.gela = gela;
       this.episodioas = episodioas;
    }
   
    public Integer getKontsultazenbakia() {
        return this.kontsultazenbakia;
    }
    
    public void setKontsultazenbakia(Integer kontsultazenbakia) {
        this.kontsultazenbakia = kontsultazenbakia;
    }
    public Gaixoa getGaixoa() {
        return this.gaixoa;
    }
    
    public void setGaixoa(Gaixoa gaixoa) {
        this.gaixoa = gaixoa;
    }
    public Sendagilea getSendagilea() {
        return this.sendagilea;
    }
    
    public void setSendagilea(Sendagilea sendagilea) {
        this.sendagilea = sendagilea;
    }
    public Date getData() {
        return this.data;
    }
    
    public void setData(Date data) {
        this.data = data;
    }
    public Date getHasiera() {
        return this.hasiera;
    }
    
    public void setHasiera(Date hasiera) {
        this.hasiera = hasiera;
    }
    public String getGela() {
        return this.gela;
    }
    
    public void setGela(String gela) {
        this.gela = gela;
    }
    public Set<Episodioa> getEpisodioas() {
        return this.episodioas;
    }
    
    public void setEpisodioas(Set<Episodioa> episodioas) {
        this.episodioas = episodioas;
    }




}

