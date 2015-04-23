package model;
// Generated 08-ene-2013 2:46:33 by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * CitaSendagile generated by hbm2java
 */
public class CitaSendagile  implements java.io.Serializable {


     private CitaSendagileId id;
     private Idazkaria idazkaria;
     private Gaixoa gaixoa;
     private Sendagilea sendagilea;
     private String gela;
     private Date hasiera;

    public CitaSendagile() {
    }

    public CitaSendagile(CitaSendagileId id, Idazkaria idazkaria, Gaixoa gaixoa, Sendagilea sendagilea, String gela, Date hasiera) {
       this.id = id;
       this.idazkaria = idazkaria;
       this.gaixoa = gaixoa;
       this.sendagilea = sendagilea;
       this.gela = gela;
       this.hasiera = hasiera;
    }
   
    public CitaSendagileId getId() {
        return this.id;
    }
    
    public void setId(CitaSendagileId id) {
        this.id = id;
    }
    public Idazkaria getIdazkaria() {
        return this.idazkaria;
    }
    
    public void setIdazkaria(Idazkaria idazkaria) {
        this.idazkaria = idazkaria;
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
    public String getGela() {
        return this.gela;
    }
    
    public void setGela(String gela) {
        this.gela = gela;
    }
    public Date getHasiera() {
        return this.hasiera;
    }
    
    public void setHasiera(Date hasiera) {
        this.hasiera = hasiera;
    }




}

