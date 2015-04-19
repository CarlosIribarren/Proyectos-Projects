package bean;

import dao.ErizainaDao;
import dao.IdazkariaDao;
import dao.LanOrduakErizainaDao;
import dao.SendagileaDao;
import dao.impl.ErizainaDaoImp;
import dao.impl.IdazkariaDaoImp;
import dao.impl.LanOrduakErizainaDaoImp;
import dao.impl.SendagileaDaoImp;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import model.Erizaina;
import model.Idazkaria;
import model.LanOrduakErizaina;
import model.Sendagilea;
import org.primefaces.context.RequestContext;

@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean {
    
    private String user;
    private String pass;
    private Object Erabiltzailea;
    private Integer zenbakia;
    
    public LoginBean() {
    }

    public void login(ActionEvent actionEvent) {  
        RequestContext context = RequestContext.getCurrentInstance();  
        FacesMessage msg = null;  
        boolean loggedIn = false;  
        
        IdazkariaDao idazkariaDao = new IdazkariaDaoImp();
        Idazkaria idazkaria = idazkariaDao.bilatuIdazkaria_UP(user, pass);
        if(idazkaria!=null)
        {
            zenbakia=idazkaria.getIdazkarizenbakia();
            Erabiltzailea = new Idazkaria();
            Erabiltzailea=idazkaria;
        }
        ErizainaDao erizainaDao = new ErizainaDaoImp();
        Erizaina erizaina = erizainaDao.bilatuErizaina_UP(user, pass);
        if(erizaina!=null)
        {
            zenbakia=erizaina.getErizainzenbakia();
            Erabiltzailea = new Erizaina();
            Erabiltzailea=erizaina;
        }
        SendagileaDao sendagileaDao = new SendagileaDaoImp();
        Sendagilea sendagilea = sendagileaDao.bilatuSendagilea_UP(user, pass);
        if(sendagilea!=null)
        {
             zenbakia=sendagilea.getSendagilezenbakia();
             Erabiltzailea = new Sendagilea();
             Erabiltzailea=sendagilea;
        }
        
        if( erizaina!=null || idazkaria!=null || sendagilea != null ) {  
            loggedIn = true;  
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ongi etorri ", user);
        } else {  
            loggedIn = false;  
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Datu Okerrak", "Saiatu berriro");  
        }  
          
        FacesContext.getCurrentInstance().addMessage(null, msg);  
        context.addCallbackParam("loggedIn", loggedIn); 
       
    }  
    
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Object getErabiltzailea() {
        return Erabiltzailea;
    }

    public void setErabiltzailea(Object Erabiltzailea) {
        this.Erabiltzailea = Erabiltzailea;
    }

    public Integer getZenbakia() {
        return zenbakia;
    }

    public void setZenbakia(Integer zenbakia) {
        this.zenbakia = zenbakia;
    }

    

    
        
    
    
    
}
