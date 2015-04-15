
package dao;

import java.util.List;
import model.Sendagilea;

public interface SendagileaDao {

    public Sendagilea bilatuSendagilea_UP(String user, String pass);
    public List<Sendagilea> bilatu_denak();
    public Sendagilea bilatuSendagilea(String sendagileaZenbakia);         
    
    
}
