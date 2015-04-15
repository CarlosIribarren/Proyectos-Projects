package dao;

import java.util.Date;
import java.util.List;
import model.LanOrduakErizaina;

public interface LanOrduakErizainaDao {
    
    public List<LanOrduakErizaina> bilatuLanOrduak(Integer erizainzenbakia,String eguna);
    
}
