package bean;

import IraunkortasunMaila.ZenbakiJokoaDatuBasea;

public class ErabiltzaileaBean {
    
    String izena;
    String pass;
    String aurreko_izena;
    int saiakerak;
//-------------------- set definitu ---------------------------------------    
      public void setCaxaizena(String caxaizena)                        //-
      {                                                                 //-
          if (izena==null )                                             //- 
          {                                                             //-
              //1go aldian                                              //-
                aurreko_izena=caxaizena;                                //-
                izena=caxaizena;                                        //-
          }                                                             //-
          else                                                          //-
          {                                                             //-
              //normalean                                               //-
                aurreko_izena=izena;                                    //-
                izena=caxaizena;                                        //-
          }                                                             //-
          if (aurreko_izena.equals(izena) )                             //-
          {                                                             //-
              saiakerak=saiakerak+1;                                    //-
          }                                                             //-
          else                                                          //-
          {                                                             //-
              saiakerak=1;                                              //-
          }                                                             //-
      }                                                                 //-
      public void setCaxapass(String caxapass)                          //-
      {                                                                 //-
           pass=caxapass;                                               //-
      }                                                                 //-
//----------------------------------------------------------------------//-
      
      public boolean loginaEgiaztatu()
      {
          return ZenbakiJokoaDatuBasea.instantzia().eginLogin(izena,pass );
      }
      public boolean erabilExistitzenda()
      {
          return ZenbakiJokoaDatuBasea.instantzia().existitzendaErabil(izena);
      }
      public void aldatuBaimena(String baimena)
      {
          ZenbakiJokoaDatuBasea.instantzia().baimenaAldatu(izena,baimena);
      }    
          
    public ErabiltzaileaBean(){}
    
    public void hasieratu()
    {
        saiakerak=1;
    }
    public String getIzena() {
        return izena;
    }
    public void setIzena(String izena) {
        this.izena = izena;
    }
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
    public int getSaiakerak() {
        return saiakerak;
    }
    public void setSaiakerak(int saiakerak) {
        this.saiakerak = saiakerak;
    }
    
    
    
}
