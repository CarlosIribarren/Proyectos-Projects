package bean;


import dao.CitaSendagileDao;
import dao.EpisodioaDao;
import dao.ErizainaDao;
import dao.FrogaDao;
import dao.GaixoaDao;
import dao.IdazkariaDao;
import dao.LanOrduakErizainaDao;
import dao.SendagileaDao;
import dao.impl.CitaSendagileDaoImp;
import dao.impl.EpisodioaDaoImp;
import dao.impl.ErizainaDaoImp;
import dao.impl.FrogaDaoImp;
import dao.impl.GaixoaDaoImp;
import dao.impl.IdazkariaDaoImp;
import dao.impl.LanOrduakErizainaDaoImp;
import dao.impl.SendagileaDaoImp;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import model.CitaSendagile;
import model.CitaSendagileId;
import model.Episodioa;
import model.Erizaina;
import model.Froga;
import model.Gaixoa;
import model.Idazkaria;
import model.LanOrduakErizaina;
import model.Sendagilea;


@ManagedBean
@SessionScoped
public class EmanCitaBean {
private List<Gaixoa> lista;
private List<Sendagilea> Sendagilelista;
private String GaixoZen; 
private String SendagileZen;
private String probaMota;
private List<LanOrduakErizaina> LanOrduak; 
private Date probaEguna;
private Time probaOrdua;
private String user;
private String pass;
private int h ;
private int m;
private int s;   

    public String getSendagileZen() {
        return SendagileZen;
    }

    public void setSendagileZen(String SendagileZen) {
        this.SendagileZen = SendagileZen;
    }

    public List<Sendagilea> getSendagilelista() {
        return Sendagilelista;
    }

    public void setSendagilelista(List<Sendagilea> Sendagilelista) {
        this.Sendagilelista = Sendagilelista;
    }
    
    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    public Date getProbaEguna() {
        return probaEguna;
    }

    public void setProbaEguna(Date probaEguna) {
        this.probaEguna = probaEguna;
    }

    public Time getProbaOrdua() {
        return probaOrdua;
    }

    public void setProbaOrdua(Time probaOrdua) {
        this.probaOrdua = probaOrdua;
    }
    public String getProbaMota() {
        return probaMota;
    }

    public void setProbaMota(String probaMota) {
        this.probaMota = probaMota;
    }

    public List<LanOrduakErizaina> getLanOrduak() {
        return LanOrduak;
    }

    public void setLanOrduak(List<LanOrduakErizaina> LanOrduak) {
        this.LanOrduak = LanOrduak;
    }



  public void gordeCitaBerria(ActionEvent actionEvent) {  
        ErizainaDao b = new ErizainaDaoImp();
        Erizaina erizaina= b.bilatuErizaina_UP("e", "e");      
        GaixoaDao gaixoDao = new GaixoaDaoImp();     
        Gaixoa gaixo = gaixoDao.bilatuGaixo(Integer.parseInt(GaixoZen));
        Date egindakoEguna= new Date();
        IdazkariaDao k = new IdazkariaDaoImp();
        Idazkaria idazkaria = k.bilatuIdazkaria_UP(user,pass);
        EpisodioaDao EpiDao = new EpisodioaDaoImp();
        //fantasma
        Episodioa episodioa = EpiDao.bilatuEpisodioa(1);
        
        
        
        Froga froga = new Froga(idazkaria,gaixo,erizaina,episodioa,"Froga gela",probaEguna,probaOrdua,egindakoEguna,egindakoEguna,probaMota,"egin gabe",false,false);
                          
        FrogaDao frogaDao = new FrogaDaoImp();      
       
     if (frogaDao.gordeFroga(froga,probaOrdua,probaEguna)==true){ 
          
               FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Gaixo  " + gaixo.getIzena() + " " + gaixo.getAbizena() + "ondo gorde da!"));  
      }else{
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); 
       String myString = sdf.format(probaEguna);
       
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ez dago "+ myString+" eguneko "+probaOrdua.toString()+" ordua libre"));
     }
    }  
  
  public void gordeSendagileCitaBerria(ActionEvent actionEvent) {
     IdazkariaDao k = new IdazkariaDaoImp();       
      Idazkaria idazkaria = k.bilatuIdazkaria_UP(user,pass);
      GaixoaDao gaixoDao = new GaixoaDaoImp();     
      Gaixoa gaixo = gaixoDao.bilatuGaixo(Integer.parseInt(GaixoZen));
      SendagileaDao sendagileaDao = new SendagileaDaoImp();
      
      Sendagilea sendagilea = sendagileaDao.bilatuSendagilea(this.SendagileZen);
      probaOrdua = new Time(h,m,s);
      
      CitaSendagileId citaId = new CitaSendagileId(idazkaria.getIdazkarizenbakia(),gaixo.getGaixozenbakia(),Integer.parseInt(this.SendagileZen),this.probaEguna);
      CitaSendagile cita = new CitaSendagile(citaId,idazkaria,gaixo,sendagilea,"gela",probaOrdua);
      
      CitaSendagileDao citaSendagileDao=new CitaSendagileDaoImp();
     if( citaSendagileDao.gordeCitaSendagile(cita,probaOrdua,this.probaEguna,Integer.parseInt(this.SendagileZen))==true){
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(gaixo.getIzena() +" nen cita gorde da"));
     }
     else
     {
      
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("egun horretako ordu hori okupatu dago"));
     }
  }
  
  
    public String getprobaMota() {
        return probaMota;
    }

    public void setprobaMota(String probaMota) {
        this.probaMota = probaMota;
    }
    public EmanCitaBean() {
        Gaixoa gaixoa = new Gaixoa();
        GaixoaDao gaixoaDao = new GaixoaDaoImp();
        this.lista = gaixoaDao.bilatuDenak();
        Sendagilea sendagile = new Sendagilea();
        SendagileaDao sendagileaDao = new SendagileaDaoImp();
        this.Sendagilelista = sendagileaDao.bilatu_denak();
    }

    public String getGaixoZen() {
        return GaixoZen;
    }

    public void setGaixoZen(String GaixoZen) {
        this.GaixoZen = GaixoZen;
    }
   
    public List<Gaixoa> getLista() {
        return lista;
    }

    public void setLista(List<Gaixoa> lista) {
        this.lista = lista;
    }


 

}
