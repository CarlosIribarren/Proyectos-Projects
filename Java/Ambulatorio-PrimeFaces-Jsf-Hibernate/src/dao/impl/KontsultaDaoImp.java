/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.KontsultaDao;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.Kontsulta;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author IBON
 */
public class KontsultaDaoImp implements KontsultaDao {
     private Session session = HibernateUtil.getSessionFactory().openSession();

    @Override
    public Kontsulta bilatuKontsulta(Integer kontsultazenbakia) {
       return (Kontsulta) session.load(Kontsulta.class, kontsultazenbakia);
    }

    @Override
    public Kontsulta bilatuKontsultaGaur(String sendagilezenbakia, String gaixozenbakia, String ordua) {
        Date gaur = new Date(System.currentTimeMillis());    
        SimpleDateFormat formatua = new SimpleDateFormat("yyyy-MM-dd"); 
        String data_katea = formatua.format(gaur);
        
        String sql = "select u from Kontsulta u where hasiera=:ordua_aldagaia and gaixozenbakia=:gaixozenbakia_aldagaia"
                + " and sendagilezenbakia=:sendagilezenbakia_aldagaia and data=:data_aldagaia ";
        Query query = session.createQuery(sql);
        
        query.setString("data_aldagaia",data_katea);        
        query.setString("ordua_aldagaia",ordua);
        query.setString("gaixozenbakia_aldagaia",gaixozenbakia);
        query.setString("sendagilezenbakia_aldagaia",sendagilezenbakia);
        return   (Kontsulta) query.uniqueResult();
    }

    @Override
    public void gordeKontsulta(Kontsulta kontsulta) {
        try {
                session.beginTransaction();
                session.save(kontsulta);
                session.beginTransaction().commit();
            } catch (Exception ex) {
                 System.out.println("Errorea Gaixoa gordetzean : " + ex.getMessage());    
                session.beginTransaction().rollback();
            }
    }
}
