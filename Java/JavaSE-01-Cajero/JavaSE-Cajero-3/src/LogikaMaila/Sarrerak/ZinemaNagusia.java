package LogikaMaila.Sarrerak;
// Class izena: 	LogikaMaila.Sarrerak.ZinemaNagusia.java
// Function:	Zinema baten objetuak kontrolatzeko klasea 
import IraunkortasunaMaila.KontuDatuBasea;
import java.util.Date;
import java.util.Vector;

public class ZinemaNagusia {
    
    private Zinema uneko_zinema=null;
    private String eguna=null;
    private Integer saldutakoSarrera_Kop=0;

    public ZinemaNagusia() {
    }
    public void egin_Erosketa(int bezeroID_bat, int kontu_bat,String sarreraEguna )
    {
        //sartu zinema_data taulan
        KontuDatuBasea.instantzia().sartu_DataZinema(uneko_zinema.getIzena(), eguna);
        //sartu erosketa
        KontuDatuBasea.instantzia().sartuErosketa(bezeroID_bat, kontu_bat, uneko_zinema.getIzena(), sarreraEguna);
        saldutakoSarrera_Kop=saldutakoSarrera_Kop+1;      
    }  
    public void egunaEguneratu(String sarreraEguna)
    {
            this.setEguna(sarreraEguna);
            //lortu egun horretako saldutako sarrera kopurua
            int kopurua=0;
            kopurua=lortuSaldutakoSarrerak();
            this.setSaldutakoSarrera_Kop(kopurua);            
    
    }   
    public int lortuSaldutakoSarrerak()
    {
        
        return KontuDatuBasea.instantzia().lortuSaldutakoSarrerak(uneko_zinema.getIzena(), eguna);
    }
    public Zinema emanZinema(String izena)
    {
        return KontuDatuBasea.instantzia().emanZineBat(izena);
    }       
    public Vector<Zinema> emanZinemaLista(String hiria)
    {
        return KontuDatuBasea.instantzia().eman_ZinemaLista(hiria);
    }   
    public Vector<String> emanHiriaLista()
    {
       return  KontuDatuBasea.instantzia().eman_Hiria();
    }
    public Zinema getUneko_zinema() {
        return uneko_zinema;
    }
    public void setUneko_zinema(Zinema uneko_zinema) {
        this.uneko_zinema = uneko_zinema;     
    }
    public String getEguna() {
        return eguna;
    }
    public void setEguna(String eguna) {
        this.eguna = eguna;
    }
    public Integer getSaldutakoSarrera_Kop() {
        return saldutakoSarrera_Kop;
    }
    public void setSaldutakoSarrera_Kop(Integer saldutakoSarrera_Kop) {
        this.saldutakoSarrera_Kop = saldutakoSarrera_Kop;
    }
  
}
