/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;
import dao.LanOrduakSendagileaDao;
import java.util.List;
import model.LanOrduakSendagilea;
import org.hibernate.Session;
import util.HibernateUtil;

public class LanOrduakSendagileaDaoImp implements LanOrduakSendagileaDao{

    private Session session = HibernateUtil.getSessionFactory().openSession();
    
    @Override
    public List<LanOrduakSendagilea> lortuOrduak(Integer sendagilezenbakia, String eguna) {
         return  session.createQuery("from LanOrduakSendagilea where sendagilea.sendagilezenbakia=" + sendagilezenbakia  + 
                                     "and eguna='" + eguna + "'").list();
    }
    
    
}
