package LogikaMaila.Bezeroak;
// Class izena: 	LogikaMaila.Bezeroak.Bezeroa.java
// Function:	Bezeroaren objektua enkasulatzea 
public class Bezeroa
{
    private int bezeroId;
    private int pinZenbakia;
    private String izena;
    private long telefonoZenbakia;
    
    //ERAIKITZAILEA PARAMETRO GUZTIAK
    public Bezeroa(int bezeroId, int pinZenbakia, String izena, long telefonoZenbakia) {
        this.bezeroId = bezeroId;
        this.pinZenbakia = pinZenbakia;
        this.izena = izena;
        this.telefonoZenbakia = telefonoZenbakia;
    }
    //ERAIKITZAILEA 2 PARAMETRO
    public Bezeroa(int bezeroId, int pinZenbakia) {
        this.bezeroId = bezeroId;
        this.pinZenbakia = pinZenbakia;
    }
    public int getBezeroId() {
        return bezeroId;
    }
    public void setBezeroId(int bezeroId) {
        this.bezeroId = bezeroId;
    }
    public int getPinZenbakia() {
        return pinZenbakia;
    }
    public void setPinZenbakia(int pinZenbakia) {
        this.pinZenbakia = pinZenbakia;
    }
    public String getIzena() {
        return izena;
    }
    public void setIzena(String izena) {
        this.izena = izena;
    }
    public long getTelefonoZenbakia() {
        return telefonoZenbakia;
    }
    public void setTelefonoZenbakia(long telefonoZenbakia) {
        this.telefonoZenbakia = telefonoZenbakia;
    }
}
