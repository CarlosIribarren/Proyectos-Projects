package dao.impl;

import dao.LanOrduakIdazkariaDao;
import java.util.List;
import model.LanOrduakIdazkaria;
import org.hibernate.Session;
import util.HibernateUtil;

public class LanOrduakIdazkariaDaoImp implements LanOrduakIdazkariaDao{

    private Session session = HibernateUtil.getSessionFactory().openSession();
    
    @Override
    public List<LanOrduakIdazkaria> lortuOrduak(Integer idazkarizenbakia, String eguna) {
         return  session.createQuery("from LanOrduakIdazkaria where idazkarizenbakia=" + idazkarizenbakia  + 
                                     "and eguna='" + eguna + "'").list();
    }
    
}
