/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.EpisodioaDao;
import java.util.List;
import model.Episodioa;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author IBON
 */
public class EpisodioaDaoImp implements EpisodioaDao {
     private Session session = HibernateUtil.getSessionFactory().openSession();
     
    
         
    

    @Override
    public Episodioa bilatuEpisodioa(Integer episodiozenbakia) {
        return (Episodioa) session.load(Episodioa.class, episodiozenbakia);
    }

    @Override
    public List<Episodioa> bilatuEpisodioak(String gaixoazenbakia) {
        return  session.createQuery("from Episodioa where gaixozenbakia=" + gaixoazenbakia).list();
    }



}
