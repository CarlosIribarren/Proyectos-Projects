
package dao.impl;

import dao.GaixoaDao;
import java.util.List;
import java.util.Set;
import model.Gaixoa;
import model.Kontsulta;
import org.hibernate.Session;
import util.HibernateUtil;

public class GaixoaDaoImp implements GaixoaDao {

    private Session session = HibernateUtil.getSessionFactory().openSession();
    
    @Override
    public void gordeGaixoa(Gaixoa gaixoa) {
        try {
                session.beginTransaction();
                session.save(gaixoa);
                session.beginTransaction().commit();
            } catch (Exception ex) {
                 System.out.println("Errorea Gaixoa gordetzean : " + ex.getMessage());    
                session.beginTransaction().rollback();
            }
    }

    @Override
    public void eguneratuGaixoa(Gaixoa gaixoa) {
        try {
                session.beginTransaction();
                session.update(gaixoa);
                session.beginTransaction().commit();
            } catch (Exception ex) {
                 System.out.println("Errorea Gaixoa eguneratzean : " + ex.getMessage());    
                session.beginTransaction().rollback();
            }      
    }

    @Override
    public void ezabatuGaixoa(Gaixoa gaixoa) {
        try {
                session.beginTransaction();
                session.delete(gaixoa);
                session.beginTransaction().commit();
            } catch (Exception ex) {
                System.out.println("Errorea Gaixoa ezabatzean : " + ex.getMessage());    
                session.beginTransaction().rollback();
            }   
    }

    @Override
    public Gaixoa bilatuGaixo(Integer gaixozenbakia) {
         return (Gaixoa) session.load(Gaixoa.class, gaixozenbakia);
    }

    @Override
    public List<Gaixoa> bilatuDenak() {
         return session.createQuery("from Gaixoa").list();
    }
    
}
