package bean;

import dao.GaixoaDao;
import dao.SendagileaDao;
import dao.impl.GaixoaDaoImp;
import dao.impl.SendagileaDaoImp;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import model.Gaixoa; 
import model.Sendagilea;


@ManagedBean
@SessionScoped
public class GaixoBerriaBean {

    private Gaixoa gaixoa;
    private String sendagilezenbakia;
    private List<Gaixoa> gaixo_lista;
    private List<Sendagilea> lista;   
    
    
    public GaixoBerriaBean() { 
        gaixoa = new Gaixoa();
        Sendagilea sendagilea = new Sendagilea();
        SendagileaDao sendagileaDao = new SendagileaDaoImp();
        lista = sendagileaDao.bilatu_denak(); 
    }

    public void gaixoBerriaPrestatu(ActionEvent actionEvent)
    {
        gaixoa = new Gaixoa();
        sendagilezenbakia="";
    }
    
    public Gaixoa getGaixoa() {
        return gaixoa;
    }

    public void setGaixoa(Gaixoa gaixoa) {
        this.gaixoa = gaixoa;
    }

    public List<Gaixoa> getGaixo_lista() {
        GaixoaDao gaixoaDao = new GaixoaDaoImp();
        gaixo_lista= gaixoaDao.bilatuDenak(); 
        return gaixo_lista;
    }

    public List<Sendagilea> getLista() {
        return lista;
    }

    public void setLista(List<Sendagilea> lista) {
        this.lista = lista;
    }

    public String getSendagilezenbakia() {
        return sendagilezenbakia;
    }

    public void setSendagilezenbakia(String sendagilezenbakia) {
        this.sendagilezenbakia = sendagilezenbakia;
    }
    

    
    public void gordeGaixoBerria(ActionEvent actionEvent) { 
        
        //bilatu sendagilea
        SendagileaDao sendagileaDao = new SendagileaDaoImp();
        Sendagilea sendagilea = sendagileaDao.bilatuSendagilea(sendagilezenbakia);
        gaixoa.setSendagilea(sendagilea);
        //gorde gaixo berria
        GaixoaDao gaixoaDao = new GaixoaDaoImp();
        gaixoaDao.gordeGaixoa(gaixoa); 
        FacesContext context = FacesContext.getCurrentInstance();  
        context.addMessage(null, new FacesMessage("Successful"));  
        
  
    }  

    
   
    
    
    
    
    
}
