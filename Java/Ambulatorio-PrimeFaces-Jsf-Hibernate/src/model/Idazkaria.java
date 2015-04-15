package model;
// Generated 08-ene-2013 2:46:33 by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Idazkaria generated by hbm2java
 */
public class Idazkaria  implements java.io.Serializable {


     private Integer idazkarizenbakia;
     private Perfil perfil;
     private String dni;
     private String izena;
     private String abizena;
     private String helbidea;
     private String tlf;
     private Date jaoitzedata;
     private String user;
     private String pass;
     private Set<LanOrduakIdazkaria> lanOrduakIdazkarias = new HashSet<LanOrduakIdazkaria>(0);
     private Set<Froga> frogas = new HashSet<Froga>(0);
     private Set<CitaSendagile> citaSendagiles = new HashSet<CitaSendagile>(0);

    public Idazkaria() {
    }

	
    public Idazkaria(Perfil perfil, String dni, String izena, String abizena, String helbidea, String tlf, Date jaoitzedata, String user, String pass) {
        this.perfil = perfil;
        this.dni = dni;
        this.izena = izena;
        this.abizena = abizena;
        this.helbidea = helbidea;
        this.tlf = tlf;
        this.jaoitzedata = jaoitzedata;
        this.user = user;
        this.pass = pass;
    }
    public Idazkaria(Perfil perfil, String dni, String izena, String abizena, String helbidea, String tlf, Date jaoitzedata, String user, String pass, Set<LanOrduakIdazkaria> lanOrduakIdazkarias, Set<Froga> frogas, Set<CitaSendagile> citaSendagiles) {
       this.perfil = perfil;
       this.dni = dni;
       this.izena = izena;
       this.abizena = abizena;
       this.helbidea = helbidea;
       this.tlf = tlf;
       this.jaoitzedata = jaoitzedata;
       this.user = user;
       this.pass = pass;
       this.lanOrduakIdazkarias = lanOrduakIdazkarias;
       this.frogas = frogas;
       this.citaSendagiles = citaSendagiles;
    }
   
    public Integer getIdazkarizenbakia() {
        return this.idazkarizenbakia;
    }
    
    public void setIdazkarizenbakia(Integer idazkarizenbakia) {
        this.idazkarizenbakia = idazkarizenbakia;
    }
    public Perfil getPerfil() {
        return this.perfil;
    }
    
    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
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
    public Date getJaoitzedata() {
        return this.jaoitzedata;
    }
    
    public void setJaoitzedata(Date jaoitzedata) {
        this.jaoitzedata = jaoitzedata;
    }
    public String getUser() {
        return this.user;
    }
    
    public void setUser(String user) {
        this.user = user;
    }
    public String getPass() {
        return this.pass;
    }
    
    public void setPass(String pass) {
        this.pass = pass;
    }
    public Set<LanOrduakIdazkaria> getLanOrduakIdazkarias() {
        return this.lanOrduakIdazkarias;
    }
    
    public void setLanOrduakIdazkarias(Set<LanOrduakIdazkaria> lanOrduakIdazkarias) {
        this.lanOrduakIdazkarias = lanOrduakIdazkarias;
    }
    public Set<Froga> getFrogas() {
        return this.frogas;
    }
    
    public void setFrogas(Set<Froga> frogas) {
        this.frogas = frogas;
    }
    public Set<CitaSendagile> getCitaSendagiles() {
        return this.citaSendagiles;
    }
    
    public void setCitaSendagiles(Set<CitaSendagile> citaSendagiles) {
        this.citaSendagiles = citaSendagiles;
    }




}


