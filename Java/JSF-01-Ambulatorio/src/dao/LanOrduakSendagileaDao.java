
package dao;

import java.util.List;
import model.LanOrduakSendagilea;


public interface LanOrduakSendagileaDao {
    
    public List<LanOrduakSendagilea> lortuOrduak(Integer sendagilezenbakia,String eguna);
    
}
