package bean;

import dao.CitaSendagileDao;
import dao.KontsultaDao;
import dao.impl.CitaSendagileDaoImp;
import dao.impl.KontsultaDaoImp;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.CitaSendagile;
import model.Kontsulta;

@ManagedBean
@SessionScoped
public class GaurkoKontsultaBean {

    boolean aurkakoa;
    
    public GaurkoKontsultaBean() {
    }
    
    public List<CitaSendagile> lortuGarkoCitak(String sendagilezenbakia)
    {
        CitaSendagileDao citaSendagileDao = new CitaSendagileDaoImp();
        return citaSendagileDao.lurtugarkoCITAK(sendagilezenbakia);    
    }
    
    public boolean dagoGaurKontsulta(String sendagilezenbakia, String gaixozenbakia, String ordua)
    {
        KontsultaDao kontsultaDao = new KontsultaDaoImp();
        Kontsulta kontsulta = new Kontsulta();
        kontsulta = kontsultaDao.bilatuKontsultaGaur(sendagilezenbakia, gaixozenbakia, ordua);
        if (kontsulta==null)
        {
            aurkakoa=true;
            return false;
        }
        else
        {
            aurkakoa=false;
            return true;
        }
        
        
        
    }

    public boolean isAurkakoa() {
        return aurkakoa;
    }

    public void setAurkakoa(boolean aurkakoa) {
        this.aurkakoa = aurkakoa;
    }
}
