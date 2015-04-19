package banku_kutxazain;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class KontuDatuBasea
{
	private static KontuDatuBasea instantzia;
	private String urla;
	private Connection konekzioa;
	private Statement sententzia;
        
        
    public static KontuDatuBasea instantzia()
    {
            if (instantzia == null)
                    instantzia = new KontuDatuBasea();
            return instantzia;
    }        
        
    private KontuDatuBasea()
    {
            try
            {
            		urla = "jdbc:sqlite:/home/erabiltzailea/workspace/JavaSE-Cajero-1/DB/bankua1bertsioa";
                    Class.forName("org.sqlite.JDBC");
                    konekzioa = DriverManager.getConnection(urla, "", "");
                    sententzia = konekzioa.createStatement();
            }
            catch (SQLException anException)
            {
                    while (anException != null)
                    {
                            System.out.println("SQL Exception:  " + anException.getMessage());
                            anException = anException.getNextException();
                    }
            }
            catch (java.lang.Exception anException)
            {
                    anException.printStackTrace();
            }
    }
    public void finalize()
    {
            try
            {
                    sententzia.close();
                    konekzioa.close();
            }
            catch (SQLException anException)
            {
                    while (anException != null)
                    {
                            System.out.println("SQL Exception:  " + anException.getMessage());
                            anException = anException.getNextException();
                    }
            }
            catch (Exception anException)
            {
                    anException.printStackTrace();
            }
    }
    public Connection getKonekzioa()
    {
            return konekzioa;
    }
    public Statement getSententzia()
    {
            return sententzia;
    }
    public String getUrl()
    {
            return urla;
    }
    public void sartuTransakzioa(int transakzioZenbakiBat, int kontuZenbakiBat, java.util.Date dataBat, double kantitateBat, String motaBat)
    {
            // Deklarazioak
            String sql;
            int count;
            //------------- DATA ETA ORDUA ESKURATU -------------------------
            java.util.Date gaurkoDataOrdua = new java.util.Date();
            SimpleDateFormat formatua;
            formatua = new SimpleDateFormat("yyyy-MM-dd H:mm:ss");
            String data_Time_katea;
            data_Time_katea = formatua.format(gaurkoDataOrdua);
            //---------------- INSERT TRANSAKZIOA ---------------------
            java.text.DateFormat dateFormat = java.text.DateFormat.getDateTimeInstance();
            // Hasieraketa
            sql = "INSERT into Transakzioa VALUES (" + transakzioZenbakiBat + ", " + kontuZenbakiBat + ", '"  + data_Time_katea + "'," + kantitateBat + ", '" + motaBat + "')";
            System.out.println("SQL : " + sql);
            try
            {
                    // Insert sql exekutatu sartutako erregistroak itzuliz
                    count = sententzia.executeUpdate(sql);
                    System.out.println("count : " + count);
            }
            catch (SQLException anException)
            {
                    while (anException != null)
                    {
                            System.out.println(" SQL Exception : " + anException.getMessage());
                            anException = anException.getNextException();
                    }
            }
            catch (java.lang.Exception anException)
            {
                    anException.printStackTrace();
            }
            //-------- SALDO ZAHARRA KONTSULATU ETA EGUNERATU
            String sql3;
            sql3 = "select Saldo_Zaharra from Kontua where Kontu_Zenbakia = "  + kontuZenbakiBat ;
            ResultSet resultSet1;
            double saldoZaharra_duena = 0;
            try {
                // SQL exekutatu
                resultSet1 = sententzia.executeQuery(sql3);
                while (resultSet1.next())
            {

                saldoZaharra_duena = Double.valueOf(resultSet1.getString(1)).doubleValue();
            }
            } catch (SQLException ex) {
                Logger.getLogger(KontuDatuBasea.class.getName()).log(Level.SEVERE, null, ex);
            }
            saldoZaharra_duena=saldoZaharra_duena + kantitateBat;

            //----UPDATE KONTUA -----KONTUAREN SALDOA EGUNERATU ---------------------
            // Deklarazioak
            String sql2;
            int count2;
            // Hasieraketa
            sql2 = "UPDATE Kontua Set Saldo_Zaharra= " + saldoZaharra_duena + " WHERE Kontu_Zenbakia = "  + kontuZenbakiBat ;
            System.out.println("SQL : " + sql2);
            try
            {
                    // Insert sql exekutatu sartutako erregistroak itzuliz
                    count2 = sententzia.executeUpdate(sql2);
                    System.out.println("count : " + count2);
            }
            catch (SQLException anException)
            {
                    while (anException != null)
                    {
                            System.out.println(" SQL Exception : " + anException.getMessage());
                            anException = anException.getNextException();
                    }
            }
            catch (java.lang.Exception anException)
            {
                    anException.printStackTrace();
            }
    }
    public HashMap irakurriKontuak()
    {
            // Deklarazioak
            String query = "select * from Kontua";
            HashMap accounts;
            ResultSet resultSet;
            // Initilization
            accounts = new HashMap();
            try
            {
                    // SQL exekutatu
                    resultSet = sententzia.executeQuery(query);
                    //	Resultset-eko errenkada eta zutabe guztiak kapturatu
                    while (resultSet.next())
                    {
                            int kontuZenbakia = Integer.parseInt(resultSet.getString(1));
                            int pinZenbakia = Integer.parseInt(resultSet.getString(2));
                            double saldoZaharra = Double.valueOf(resultSet.getString(3)).doubleValue();
                            String bezeroaIzena = resultSet.getString(4);
                            long bezeroaTelefonoZenbakia = Long.parseLong(resultSet.getString(5));
                            System.out.println("Kontua: kontuZenbakia = " + kontuZenbakia + " | " + "pinZenbakia = " + pinZenbakia + " | " + "saldoZaharra = " + saldoZaharra + " | " + "bezeroaIzena = " + bezeroaIzena + " | " + "bezeroaTelefonoZenbakia = " + bezeroaTelefonoZenbakia + " | ");
                            Kontua kontua;
                            Bezeroa bezeroa;
                            bezeroa = new Bezeroa(bezeroaIzena, bezeroaTelefonoZenbakia);
                            kontua = new Kontua(kontuZenbakia, saldoZaharra, pinZenbakia, bezeroa);
                            //public V put(K key, V value)|| HashMap key,value SARTU
                            accounts.put(new Integer(kontuZenbakia), kontua);
                    }
                    resultSet.close();
            }
            catch (SQLException anException)
            {
                    while (anException != null)
                    {
                            System.out.println("SQL Exception:  " + anException.getMessage());
                            anException = anException.getNextException();
                    }
            }
            catch (java.lang.Exception anException)
            {
                    anException.printStackTrace();
            }
            finally
            {
                    return accounts;
            }
    }
    public void setKonekzioa(Connection konekzioBerria)
    {
            konekzioa = konekzioBerria;
    }
    public void setSententzia(Statement sententziBerria)
    {
            sententzia = sententziBerria;
    }
    public void setUrl(String urlBerria)
    {
            urla = urlBerria;
    }

    public int irakurriHasierakoTransakzioZenbakia()
    {
            // Deklarazioak
            String query = "select MAX(Transakzio_Zenbakia) as Zenbat from Transakzioa";
            int transakzioZenbakia = 30000;
            ResultSet resultSet;	
            try
            {
                    // SQL exekutatu
                    resultSet = sententzia.executeQuery(query);
                    //	Resultset-eko errenkada eta zutabe guztiak kapturatu
                    while (resultSet.next())
                    {     
                            transakzioZenbakia = resultSet.getInt("Zenbat");		
                    }
                    resultSet.close();
            }
            catch (SQLException anException)
            {
                    while (anException != null)
                    {
                            System.out.println("SQL Exception:  " + anException.getMessage());
                            anException = anException.getNextException();
                    }
            }
            catch (java.lang.Exception anException)
            {
                    anException.printStackTrace();
            }
            finally
            {
          if (transakzioZenbakia == 0)
            transakzioZenbakia = 30000;
                    return transakzioZenbakia;
            }
    }
}
