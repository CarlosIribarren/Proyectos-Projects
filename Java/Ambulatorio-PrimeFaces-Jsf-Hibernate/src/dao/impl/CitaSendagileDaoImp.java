/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.CitaSendagileDao;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import model.CitaSendagile;
import model.CitaSendagileId;
import model.LanOrduakErizaina;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author IBON
 */
public class CitaSendagileDaoImp implements CitaSendagileDao {

        private Session session = HibernateUtil.getSessionFactory().openSession();
        
    @Override
    public boolean gordeCitaSendagile( CitaSendagile citaSendagile,Time ordua, Date eguna, int SendagileZen) {
         try {
               SimpleDateFormat formatua=new SimpleDateFormat("yyyy-MM-dd"); 
             String egunaStrin = formatua.format(eguna);
              List<LanOrduakErizaina> lista = session.createQuery("from LanOrduakSendagilea where eguna='" + egunaStrin + "'and hasiera='" + ordua.toString() + "'and  	sendagilezenbakia='" +SendagileZen  + "'and okupatua='" +false+ "'").list();
            
            if (lista.isEmpty()){
                    return false;
             }else{
                session.beginTransaction();               
                session.save(citaSendagile);
                session.beginTransaction().commit();
                return true;
                        }
            } catch (Exception ex) {
                 System.out.println("Erorea Gaixoa gordetzean : " + ex.getMessage());    
                session.beginTransaction().rollback();
            }
           return false;
    }

    @Override
    public List<CitaSendagile> lurtugarkoCITAK(String sendagilezenbakia ) {  
        Date gaur = new Date(System.currentTimeMillis());    
        SimpleDateFormat formatua = new SimpleDateFormat("yyyy-MM-dd"); 
        String data_katea = formatua.format(gaur);
        String sql = "select u from CitaSendagile u where sendagilezenbakia=:sendagilezenbakia_aldagaia and data=:data_aldagaia ";
        return  session.createQuery("from CitaSendagile where data='" + data_katea + "' and sendagilezenbakia="+ sendagilezenbakia +" order by hasiera asc").list();
    }
    
}
