package model;
// Generated 08-ene-2013 2:46:33 by Hibernate Tools 3.2.1.GA



/**
 * LanOrduakIdazkaria generated by hbm2java
 */
public class LanOrduakIdazkaria  implements java.io.Serializable {


     private LanOrduakIdazkariaId id;
     private Idazkaria idazkaria;
     private String gela;
     private boolean okupatua;

    public LanOrduakIdazkaria() {
    }

    public LanOrduakIdazkaria(LanOrduakIdazkariaId id, Idazkaria idazkaria, String gela, boolean okupatua) {
       this.id = id;
       this.idazkaria = idazkaria;
       this.gela = gela;
       this.okupatua = okupatua;
    }
   
    public LanOrduakIdazkariaId getId() {
        return this.id;
    }
    
    public void setId(LanOrduakIdazkariaId id) {
        this.id = id;
    }
    public Idazkaria getIdazkaria() {
        return this.idazkaria;
    }
    
    public void setIdazkaria(Idazkaria idazkaria) {
        this.idazkaria = idazkaria;
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


