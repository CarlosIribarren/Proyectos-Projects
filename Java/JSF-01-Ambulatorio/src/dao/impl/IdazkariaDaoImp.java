
package dao.impl;

import dao.IdazkariaDao;
import model.Idazkaria;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

public class IdazkariaDaoImp implements IdazkariaDao{

    @Override
    public Idazkaria bilatuIdazkaria_UP(String user, String pass) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String sql = "select u from Idazkaria u where user=:user_aldagaia and pass=:pass_aldagaia";
        Query query = session.createQuery(sql);
        query.setString("user_aldagaia",user);
        query.setString("pass_aldagaia",pass);
        return  (Idazkaria) query.uniqueResult(); 
    }
    
    
    
}
