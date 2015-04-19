/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import model.CitaSendagile;
import model.CitaSendagileId;

/**
 *
 * @author IBON
 */
public interface CitaSendagileDao {
    
    public List<CitaSendagile> lurtugarkoCITAK(String sendagilezenbakia );
    public boolean gordeCitaSendagile( CitaSendagile citaSendagile , Time ordua, Date eguna,int SendagileZen); 
}
