/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Kontsulta;

/**
 *
 * @author IBON
 */
public interface KontsultaDao {
    public Kontsulta bilatuKontsulta(Integer kontsultazenbakia );
    public Kontsulta bilatuKontsultaGaur(String sendagilezenbakia, String gaixozenbakia, String ordua);
    public void gordeKontsulta(Kontsulta kontsulta);
}
