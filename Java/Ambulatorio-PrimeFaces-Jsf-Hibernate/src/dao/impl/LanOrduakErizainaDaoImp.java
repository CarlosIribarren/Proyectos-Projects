package dao.impl;

import dao.LanOrduakErizainaDao;
import java.util.Date;
import java.util.List;
import model.LanOrduakErizaina;
import org.hibernate.Session;
import util.HibernateUtil;

public class LanOrduakErizainaDaoImp  implements LanOrduakErizainaDao{

     private Session session = HibernateUtil.getSessionFactory().openSession();
    
    @Override
    public List<LanOrduakErizaina> bilatuLanOrduak(Integer erizainzenbakia, String eguna) {
         return  session.createQuery("from LanOrduakErizaina where erizainzenbakia=" + erizainzenbakia  + 
                                     "and eguna='" + eguna + "'").list();
    }
    
}
