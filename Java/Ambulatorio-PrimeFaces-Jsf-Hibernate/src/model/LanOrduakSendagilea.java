package model;
// Generated 08-ene-2013 2:46:33 by Hibernate Tools 3.2.1.GA



/**
 * LanOrduakSendagilea generated by hbm2java
 */
public class LanOrduakSendagilea  implements java.io.Serializable {


     private LanOrduakSendagileaId id;
     private Sendagilea sendagilea;
     private String gela;
     private boolean okupatua;

    public LanOrduakSendagilea() {
    }

    public LanOrduakSendagilea(LanOrduakSendagileaId id, Sendagilea sendagilea, String gela, boolean okupatua) {
       this.id = id;
       this.sendagilea = sendagilea;
       this.gela = gela;
       this.okupatua = okupatua;
    }
   
    public LanOrduakSendagileaId getId() {
        return this.id;
    }
    
    public void setId(LanOrduakSendagileaId id) {
        this.id = id;
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
    public boolean isOkupatua() {
        return this.okupatua;
    }
    
    public void setOkupatua(boolean okupatua) {
        this.okupatua = okupatua;
    }




}


