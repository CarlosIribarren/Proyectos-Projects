package bean;
import dao.EpisodioaDao;
import dao.FrogaDao;
import dao.GaixoaDao;
import dao.KontsultaDao;
import dao.SendagileaDao;
import dao.impl.EpisodioaDaoImp;
import dao.impl.FrogaDaoImp;
import dao.impl.GaixoaDaoImp;
import dao.impl.KontsultaDaoImp;
import dao.impl.SendagileaDaoImp;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Episodioa;
import model.Froga;
import model.Gaixoa;
import model.Kontsulta;
import model.Sendagilea;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

@ManagedBean
@SessionScoped
public class HistorialBean {

    private Gaixoa unekoGaixoa;
    private Episodioa unekoepisodioa;
    private List<Episodioa> episodio_lista_taula;
    private List<Froga> froga_taula;
 
    public HistorialBean() {
        unekoGaixoa = new Gaixoa();
    }
    
    public void prestatuKontsulta(String gaixozenbakia, String gela, Date ordua, String sendagilezenbakia)
    {
        Date gaur = new Date(System.currentTimeMillis());    
        GaixoaDao gaixoaDao = new GaixoaDaoImp();
        unekoGaixoa= gaixoaDao.bilatuGaixo(Integer.parseInt(gaixozenbakia));
        SendagileaDao sendagileaDao = new SendagileaDaoImp();
        Sendagilea sendagilea;
        sendagilea=sendagileaDao.bilatuSendagilea(sendagilezenbakia);
        Kontsulta kontsulta = new Kontsulta(unekoGaixoa, sendagilea, gaur, ordua, gela);
        KontsultaDao kontsultaDao = new KontsultaDaoImp();
        kontsultaDao.gordeKontsulta(kontsulta);    
    }    

    public void prestatuEpisodio(String episodiozenbakia)
    {
        EpisodioaDao episodioaDao = new EpisodioaDaoImp();
        unekoepisodioa = episodioaDao.bilatuEpisodioa(Integer.parseInt(episodiozenbakia));
        FrogaDao frogaDao = new FrogaDaoImp();
        froga_taula = frogaDao.bilatuFroga_lista(unekoGaixoa.getGaixozenbakia().toString());
        
    }
    
    public Gaixoa getUnekoGaixoa() {
        return unekoGaixoa;
    }

    public void setUnekoGaixoa(Gaixoa unekoGaixoa) {
        this.unekoGaixoa = unekoGaixoa;
    }

    public List<Episodioa> getEpisodio_lista_taula() {
        EpisodioaDao episodioaDao = new EpisodioaDaoImp(); 
        episodio_lista_taula=  episodioaDao.bilatuEpisodioak(unekoGaixoa.getGaixozenbakia().toString());
        return episodio_lista_taula;
    }


    public void setEpisodio_lista_taula(List<Episodioa> episodio_lista_taula) {
        this.episodio_lista_taula = episodio_lista_taula;
    }

    public Episodioa getUnekoepisodioa() {
        return unekoepisodioa;
        
    }

    public void setUnekoepisodioa(Episodioa unekoepisodioa) {
        this.unekoepisodioa = unekoepisodioa;
    }

    public List<Froga> getFroga_taula() {
        if (unekoepisodioa!=null)
        {
            
        
        FrogaDao frogaDao = new FrogaDaoImp();
        froga_taula = frogaDao.bilatuFroga_lista(unekoepisodioa.getEpisodiozenbakia().toString());
        return froga_taula;
        }
        else
            return null;
    }

    public void setFroga_taula(List<Froga> froga_taula) {
        this.froga_taula = froga_taula;
    }

    
    
    
    
}
