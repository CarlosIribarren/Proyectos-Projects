package dao.impl;

import dao.FrogaDao;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import model.Erizaina;
import model.Froga;
import model.LanOrduakErizaina;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

public class FrogaDaoImp implements FrogaDao{

    private Session session = HibernateUtil.getSessionFactory().openSession();
    
    @Override
    public List<Froga> lortuCitakFroga() {
    Date gaur = new Date(System.currentTimeMillis());    
    SimpleDateFormat formatua = new SimpleDateFormat("yyyy-MM-dd"); 
    String data_katea = formatua.format(gaur);
    return  session.createQuery("from Froga where frogadata='" + data_katea + "' order by frogaordua asc").list();
    }

    @Override
    public Froga bilatuFroga(String frogaZenbakia) {
        String sql = "select u from Froga u where frogazenbakia=:frogazenbakia_aldagaia ";
        Query query = session.createQuery(sql);
        query.setString("frogazenbakia_aldagaia",frogaZenbakia);
        return  (Froga) query.uniqueResult();
    }

    @Override
    public void eguneratuErizainaFrogan(String frogazenbakia,String erizainzenbakia,String emaitza) {
        
            session.createQuery("update Froga c set c.name = :newName where c.name = :oldName");
    }

    @Override
    public boolean gordeFroga(Froga froga, Time ordua, Date eguna) {
        try {  
           
             SimpleDateFormat formatua=new SimpleDateFormat("yyyy-MM-dd"); 
             String egunaStrin = formatua.format(eguna);
             List<LanOrduakErizaina> lista = session.createQuery("from LanOrduakErizaina where eguna='" + egunaStrin + "'and hasiera='" + ordua.toString() + "'and okupatua='" +false+ "'").list();
            
            if (lista.isEmpty()){
                    return false;
             }else{
               session.beginTransaction();
               session.save(froga);
               session.beginTransaction().commit();
               session.createQuery("update LanOrduakErizaina set okupatua = '"+ "1" + " 'where  eguna='" + egunaStrin + "'and hasiera='" + ordua.toString() + "'and okupatua='" +false+ "'");
                return true;
             }
         
            } catch (Exception ex) {
                 System.out.println("Erorea froga gordetzean : " + ex.getMessage());    
                session.beginTransaction().rollback();
            }
        return false;
    }

    @Override
    public void gordeFroga(Froga froga) {
        try {
                session.beginTransaction();
                session.save(froga);
                session.beginTransaction().commit();
            } catch (Exception ex) {
                 System.out.println("Errorea Froga gordetzean : " + ex.getMessage());    
                session.beginTransaction().rollback();
            }
    }

    @Override
    public void eguneratuFroga(Froga froga) {
        try {
                session.beginTransaction();
                session.update(froga);
                session.beginTransaction().commit();
            } catch (Exception ex) {
                 System.out.println("Errorea Froga gordetzean : " + ex.getMessage());    
                session.beginTransaction().rollback();
            }
    }

    @Override
    public List<Froga> bilatuFroga_lista(String episodioZenbakia) {
            return  session.createQuery("from Froga where episodiozenbakia=" + episodioZenbakia ).list();
    }

    
    
}
