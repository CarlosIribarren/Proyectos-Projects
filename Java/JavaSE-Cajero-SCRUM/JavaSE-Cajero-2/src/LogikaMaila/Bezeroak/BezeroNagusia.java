package LogikaMaila.Bezeroak;
// Class izena: 	LogikaMaila.Bezeroak.BezeroNagusia.java
// Function:	Bezeroaren objektuen kontrolatzailea 
import IraunkortasunaMaila.KontuDatuBasea;
import java.util.HashMap;

public class BezeroNagusia
{
    //HashMap bezeroGuztiak gordetzeko
    private HashMap bezeroGuztiak;
    
    public BezeroNagusia()
    {
            bezeroGuztiak = KontuDatuBasea.instantzia().irakurriBezeroak();
    }
    //bezeroa ez badu balidatzen orduan NULL bestela bezeroa hitzultzen du
    public Bezeroa aurkituBezeroa(int BezeroID, int pinZenbakiBat)
    {
            Bezeroa bezero_bat;
            bezero_bat = (Bezeroa) bezeroGuztiak.get(new Integer(BezeroID));
            if (bezero_bat!=null)
            {
                    if (bezero_bat.getPinZenbakia() == pinZenbakiBat)
                    {
                        return bezero_bat;
                    }
                    else
                    {
                         return null;
                    }
             }
            else
            {
                return null;
            }
    }
    public HashMap getBezeroGuztiak() {
        return bezeroGuztiak;
    }
    public void setBezeroGuztiak(HashMap bezeroGuztiak) {
        this.bezeroGuztiak = bezeroGuztiak;
    }
    public String toString() {
        return "BezeroNagusia{" + "bezeroGuztiak=" + bezeroGuztiak + '}';
    }    
}
