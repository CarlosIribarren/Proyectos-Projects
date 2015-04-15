package dao;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import model.Erizaina;
import model.Froga;


public interface FrogaDao {
    
    public List<Froga> lortuCitakFroga();
    public Froga bilatuFroga(String frogaZenbakia);
    public List<Froga> bilatuFroga_lista(String episodioZenbakia);
    public void eguneratuErizainaFrogan(String frogazenbakia,String erizainzenbakia,String emaitza);
    public boolean gordeFroga(Froga froga, Time ordua, Date eguna ); 
    public void gordeFroga(Froga froga);
    public void eguneratuFroga(Froga froga);
}
