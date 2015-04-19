
package dao;

import java.util.List;
import model.LanOrduakIdazkaria;


public interface LanOrduakIdazkariaDao {
    
    public List<LanOrduakIdazkaria> lortuOrduak(Integer idazkarizenbakia,String eguna);
    
}
