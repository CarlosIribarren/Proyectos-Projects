package LogikaMaila.Kontuak;
// Class izena: 	LogikaMaila.Kontuak.KontuNagusia.java
// Function:	Kontu objetuen kontrolatzailea
import IraunkortasunaMaila.KontuDatuBasea;
import java.sql.SQLException;
import java.util.*;
public class KontuNagusia
{
    //Bezeroaren kontuak gordetzeko egitura
    private Vector<Integer> bezeroaren_kontuen_lista;
    private int bezeroID;
      
    
    public Double eman_Saldoa(int kontuZenbakia)
    {
        return KontuDatuBasea.instantzia().saldoaEman(kontuZenbakia);
    }


    public void kontuak_lortu()
    {
        bezeroaren_kontuen_lista=KontuDatuBasea.instantzia().bezero_Baten_Kontuak_Kargatu(bezeroID);
    }

    public Vector<Integer> getBezeroaren_kontuen_lista() {
        return bezeroaren_kontuen_lista;
    }

    public int getBezeroID() {
        return bezeroID;
    }

    public void setBezeroID(int bezeroID) {
        this.bezeroID = bezeroID;
    }


}
