
package bean;

import dao.ErizainaDao;
import dao.FrogaDao;
import dao.impl.ErizainaDaoImp;
import dao.impl.FrogaDaoImp;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Froga;

@ManagedBean
@SessionScoped
public class GaurkoProbakBean {

    private List<Froga> froga_lista;
    private Froga unekoFroga;
    private String baxua;
    private String altua;
    
    public GaurkoProbakBean() {
        unekoFroga = new Froga();
    }

    public void prestatuFroga(String frogazenbakia)
    {
        unekoFroga = new Froga();
        FrogaDao frogaDao = new FrogaDaoImp();
        unekoFroga=frogaDao.bilatuFroga(frogazenbakia);
    }
    
    public List<Froga> getFroga_lista() {
        FrogaDao frogaDao = new FrogaDaoImp();
        froga_lista = frogaDao.lortuCitakFroga();
        return froga_lista;
    }

    public void setFroga_lista(List<Froga> froga_lista) {
        this.froga_lista = froga_lista;
    }
    
    public boolean lortuAurkakoa(String zenb)
    {
        if ( zenb.equals("false")) 
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public String zeinProbaEgin(String probaDeskribapena )
    {
        if (probaDeskribapena.equals("Analisia"))
        {
            return "modalDialogAnalisia";
        }
        if (probaDeskribapena.equals("Elektrokardiograma"))
        {
            return "modalDialogElektr";
        }
        if (probaDeskribapena.equals("X-izpiak"))
        {
            return "modalDialogIzpiak";
        }
        if (probaDeskribapena.equals("Tentsioa"))
        {
            return "modalDialogTentsioa";
        }
        else
        {
            return "";
        }        
    }
    public Froga getUnekoFroga() {
        return unekoFroga;
    }

    public void setUnekoFroga(Froga unekoFroga) {
        this.unekoFroga = unekoFroga;
    }
    public String getBaxua() {
        return baxua;
    }

    public void setBaxua(String baxua) {
        this.baxua = baxua;
    }

    public String getAltua() {
        return altua;
    }

    public void setAltua(String altua) {
        this.altua = altua;
    }
    public void eginProba(String erizainzenbakia)
    {
        ErizainaDao erizainaDao = new ErizainaDaoImp();  
        unekoFroga.setErizaina(erizainaDao.bilatuErizaina_UP(erizainzenbakia));
        unekoFroga.setEginda(true);  
        FrogaDao frogaDao = new FrogaDaoImp();
        frogaDao.eguneratuFroga(unekoFroga);
        FacesContext context = FacesContext.getCurrentInstance();   
        context.addMessage(null, new FacesMessage( unekoFroga.getDeskribapena() + " proba ondo gorde da")); 
    }
    public void eginProbaTentsioa(String erizainzenbakia)
    {
        unekoFroga.setEmaitza("- Tentsio baxua : " + baxua + " - Tentsio altua :" + altua);
        ErizainaDao erizainaDao = new ErizainaDaoImp();  
        unekoFroga.setErizaina(erizainaDao.bilatuErizaina_UP(erizainzenbakia));
        unekoFroga.setEginda(true);  
        FrogaDao frogaDao = new FrogaDaoImp();
        frogaDao.eguneratuFroga(unekoFroga);
    }

    
    

    
    
    
    
}
