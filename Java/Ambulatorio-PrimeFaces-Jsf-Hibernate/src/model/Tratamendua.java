package model;
// Generated 08-ene-2013 2:46:33 by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * Tratamendua generated by hbm2java
 */
public class Tratamendua  implements java.io.Serializable {


     private Integer tratamenduzenbakia;
     private Episodioa episodioa;
     private Date emandakodata;
     private String deskribapena;

    public Tratamendua() {
    }

    public Tratamendua(Episodioa episodioa, Date emandakodata, String deskribapena) {
       this.episodioa = episodioa;
       this.emandakodata = emandakodata;
       this.deskribapena = deskribapena;
    }
   
    public Integer getTratamenduzenbakia() {
        return this.tratamenduzenbakia;
    }
    
    public void setTratamenduzenbakia(Integer tratamenduzenbakia) {
        this.tratamenduzenbakia = tratamenduzenbakia;
    }
    public Episodioa getEpisodioa() {
        return this.episodioa;
    }
    
    public void setEpisodioa(Episodioa episodioa) {
        this.episodioa = episodioa;
    }
    public Date getEmandakodata() {
        return this.emandakodata;
    }
    
    public void setEmandakodata(Date emandakodata) {
        this.emandakodata = emandakodata;
    }
    public String getDeskribapena() {
        return this.deskribapena;
    }
    
    public void setDeskribapena(String deskribapena) {
        this.deskribapena = deskribapena;
    }




}


