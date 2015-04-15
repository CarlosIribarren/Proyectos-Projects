
package util;

import dao.LanOrduakErizainaDao;
import dao.LanOrduakIdazkariaDao;
import dao.LanOrduakSendagileaDao;
import dao.impl.LanOrduakErizainaDaoImp;
import dao.impl.LanOrduakIdazkariaDaoImp;
import dao.impl.LanOrduakSendagileaDaoImp;
import java.util.List;
import model.LanOrduakErizaina;


public class KudeatuOrdutegia {
    
    public List<LanOrduakErizaina> lortuOrdutegiak(Integer zenbakia, String data, String deskribapena)
    {
        List emaitza=null;
        if (deskribapena.equals("Sendagilea")||deskribapena.equals("Sendagile Espezialista")||deskribapena.equals("Administratzailea"))
        {
            LanOrduakSendagileaDao lanOrduakSendagileaDao = new LanOrduakSendagileaDaoImp();
            emaitza = lanOrduakSendagileaDao.lortuOrduak(zenbakia, data);     
        }
        if (deskribapena.equals("Idazkaria"))
        {
            LanOrduakIdazkariaDao lanOrduakIdazkariaDao = new LanOrduakIdazkariaDaoImp();
            emaitza = lanOrduakIdazkariaDao.lortuOrduak(zenbakia, data); 
        }
        if (deskribapena.equals("Erizaina"))
        {
            LanOrduakErizainaDao lanOrduakErizainaDao = new LanOrduakErizainaDaoImp();
            emaitza= lanOrduakErizainaDao.bilatuLanOrduak(zenbakia,data);
        }      
        return emaitza;
    }
    
}
