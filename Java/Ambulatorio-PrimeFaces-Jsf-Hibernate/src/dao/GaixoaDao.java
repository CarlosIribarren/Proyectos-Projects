
package dao;

import java.util.List;
import model.Gaixoa;


public interface GaixoaDao {
    
    public void gordeGaixoa(Gaixoa gaixoa );
    public void eguneratuGaixoa(Gaixoa gaixoa );
    public void ezabatuGaixoa(Gaixoa gaixoa );
    public Gaixoa bilatuGaixo(Integer gaixozenbakia);
    public List<Gaixoa> bilatuDenak();
    
}
