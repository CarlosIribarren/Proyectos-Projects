// Class izena: 	LogikaMaila.Sarrerak.Zinema.java
// Function:	Zinema baten datuak eskuratzeko klasea 
package LogikaMaila.Sarrerak;

public class Zinema {
    
    private String izena;
    private String hiria;
    private Integer sarrera_totala;

    public Zinema() {
    }
    public Zinema(String izena, String hiria, Integer sarrera_totala) {
        this.izena = izena;
        this.hiria = hiria;
        this.sarrera_totala = sarrera_totala;
    }   
    public String getIzena() {
        return izena;
    }
    public void setIzena(String izena) {
        this.izena = izena;
    }
    public String getHiria() {
        return hiria;
    }
    public void setHiria(String hiria) {
        this.hiria = hiria;
    }
    public Integer getSarrera_totala() {
        return sarrera_totala;
    }
    public void setSarrera_totala(Integer sarrera_totala) {
        this.sarrera_totala = sarrera_totala;
    }
    @Override
    public String toString() {
        return "Zinema{" + "izena=" + izena + ", hiria=" + hiria + ", sarrera_totala=" + sarrera_totala + '}';
    }
    
    
    
}
