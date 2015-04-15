package dao;

import model.Erizaina;

public interface ErizainaDao {
   
    public Erizaina bilatuErizaina_UP(String user, String pass);
    public Erizaina bilatuErizaina_UP(String erizainzenbakia);
    public void eguneratu(Erizaina erizaina);
}



    



