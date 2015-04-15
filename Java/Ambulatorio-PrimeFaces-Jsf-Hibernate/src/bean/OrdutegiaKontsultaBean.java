package bean;

import dao.LanOrduakErizainaDao;
import dao.impl.LanOrduakErizainaDaoImp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.LanOrduakErizaina;
import org.primefaces.event.DateSelectEvent;
import util.KudeatuOrdutegia;


@ManagedBean
@SessionScoped
public class OrdutegiaKontsultaBean {

    private Date date1;  
    private List<LanOrduakErizaina> orduak;
    
    
    public OrdutegiaKontsultaBean() {
    }
    
    public Date getDate1() {  
        return date1;  
    }  
    public void setDate1(Date date1) { 
        this.date1 = date1;   
    }  
    public List<LanOrduakErizaina> getOrduak() {
        return orduak;
    }
    public void setOrduak(List<LanOrduakErizaina> orduak) {
        this.orduak = orduak;
    } 
    public void handleDateSelect(DateSelectEvent event) {  
        FacesContext facesContext = FacesContext.getCurrentInstance();  
        SimpleDateFormat format = new SimpleDateFormat("d-M-yyyy");  
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aukeratutako eguna ", format.format(event.getDate())));  
        date1=event.getDate();
    } 
    public List lortuOrduak(Integer zenbakia,String deskribapena) {

        if (date1!=null)
        {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");    
            KudeatuOrdutegia kudeatuOrdutegia = new KudeatuOrdutegia();
            orduak=kudeatuOrdutegia.lortuOrdutegiak(zenbakia,format.format(date1),deskribapena);
            return orduak;
        }
        else
        {
            return null;
        }
    }

}
