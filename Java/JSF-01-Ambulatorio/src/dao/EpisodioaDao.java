/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Episodioa;

/**
 *
 * @author IBON
 */
public interface EpisodioaDao {
     public Episodioa bilatuEpisodioa(Integer episodiozenbakia );
     public List<Episodioa> bilatuEpisodioak(String gaixoazenbakia );
    
}
