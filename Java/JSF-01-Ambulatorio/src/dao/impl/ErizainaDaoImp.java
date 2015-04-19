
package dao.impl;

import dao.ErizainaDao;
import model.Erizaina;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

public class ErizainaDaoImp implements ErizainaDao{

    @Override
    public Erizaina bilatuErizaina_UP(String user, String pass) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String sql = "select u from Erizaina u where user=:user_aldagaia and pass=:pass_aldagaia";
        Query query = session.createQuery(sql);
        query.setString("user_aldagaia",user);
        query.setString("pass_aldagaia",pass);
        return (Erizaina) query.uniqueResult(); 
    }

    @Override
    public void eguneratu(Erizaina erizaina) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(erizaina);
            session.beginTransaction().commit();
        } catch (Exception e) {
            System.out.println("Eguneratzean errorea" + e.getMessage() );
            session.beginTransaction().rollback(); 
        }
       
    }

    @Override
    public Erizaina bilatuErizaina_UP(String erizainzenbakia) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String sql = "select u from Erizaina u where erizainzenbakia=:erizainzenbakia_aldagaia ";
        Query query = session.createQuery(sql);
        query.setString("erizainzenbakia_aldagaia",erizainzenbakia);
        return  (Erizaina) query.uniqueResult();
    }
    
    
    
}
