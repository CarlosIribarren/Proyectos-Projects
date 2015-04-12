package bean;
import IraunkortasunMaila.ZenbakiJokoaDatuBasea;
import java.util.*;

public class ZenbakiaIgarriBean {

  int erantzuna;
  boolean arrakasta;
  String aholkua;
  int probaKopurua;
  int uneko_balioa;
  int saioa;
  String izena;

  public ZenbakiaIgarriBean() {}

  public void setProba(String proba) {
    probaKopurua++;
    int balioa;
    try {
      balioa = Integer.parseInt(proba);
    }
    catch (NumberFormatException e) {
      balioa = -1;
    }
    uneko_balioa=balioa;
    if (balioa == erantzuna) {
      arrakasta = true;
      aholkua= "Zenbakia asmatuta!!";
    }
    else if (balioa == -1) {
      aholkua = "hurrengoan zenbaki batekin, mesedez";
      sartuAkatsa();
    }
    else if (balioa < erantzuna) {
      aholkua = "handiagoa";
    }
    else if (balioa > erantzuna) {
      aholkua = "txikiagoa";
    }
    
    sartuSaiakera();
    
  }

  public void sartuSaiakera()
  {
       ZenbakiJokoaDatuBasea.instantzia().sartuSaiakeraBat(uneko_balioa,  aholkua, saioa);
  }
  public void sartuAkatsa()
  {
       ZenbakiJokoaDatuBasea.instantzia().eguneratuSarreraAkatsakKop(saioa);
  }
  public void saioaEguneratu()
  {
      //saioaren balioak eguneratu
  }
  
  public boolean getarrakasta() {
    return arrakasta;
  }

  public String getaholkua() {
    return "" + aholkua;
  }

  public int getprobaKopurua() {
    return probaKopurua;
  }

  public void hasieratu() {
    erantzuna = Math.abs(new Random().nextInt() % 100) + 1;
    arrakasta = false;
    probaKopurua = 0;
    //---------lortu saio zenbakia-----------------
    saioa=ZenbakiJokoaDatuBasea.instantzia().lortuAzkenSaioID();
    saioa=saioa+1;
    //SAIO BERRIA SORTU
    ZenbakiJokoaDatuBasea.instantzia().sartuSaioBerria(getIzena(), erantzuna,saioa);    
  }
  public void bukatu()
  {
    arrakasta = false;
    probaKopurua = 0;
  }

    public int getErantzuna() {
        return erantzuna;
    }

    public int getUneko_balioa() {
        return uneko_balioa;
    }

    public void setUneko_balioa(int uneko_balioa) {
        this.uneko_balioa = uneko_balioa;
    }

    public int getSaioa() {
        return saioa;
    }

    public void setSaioa(int saioa) {
        this.saioa = saioa;
    }

    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public int getProbaKopurua() {
        return probaKopurua;
    }

    public void setProbaKopurua(int probaKopurua) {
        this.probaKopurua = probaKopurua;
    }
    
    
}
