
package dao.impl;

import dao.SendagileaDao;
import java.util.List;
import model.Sendagilea;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;


public class SendagileaDaoImp implements SendagileaDao{

            Session session = HibernateUtil.getSessionFactory().openSession();
    
    @Override
    public Sendagilea bilatuSendagilea_UP(String user, String pass) {

        String sql = "select u from Sendagilea u where user=:user_aldagaia and pass=:pass_aldagaia";
        Query query = session.createQuery(sql);
        query.setString("user_aldagaia",user);
        query.setString("pass_aldagaia",pass);
        return (Sendagilea) query.uniqueResult(); 
    }

    @Override
    public List<Sendagilea> bilatu_denak() {
        return session.createQuery("from Sendagilea").list();
    }
    @Override
    public Sendagilea bilatuSendagilea(String sendagileaZenbakia){
        String sql = "select u from Sendagilea u where sendagilezenbakia=:sendagilezenbakia_aldagaia ";
        Query query = session.createQuery(sql);
        query.setString("sendagilezenbakia_aldagaia",sendagileaZenbakia);
        return (Sendagilea) query.uniqueResult();
            }
    
}
