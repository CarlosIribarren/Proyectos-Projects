package IraunkortasunaMaila;
// Class izena: 	IraunkortasunaMaila.KontuDatuBasea.java
// Function:	Arkitekturaren iraunkortasun maila Singleton patroia
import LogikaMaila.Bezeroak.Bezeroa;
import LogikaMaila.Kontuak.Kontua;
import java.util.Vector;
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
                		urla = "jdbc:sqlite:/home/erabiltzailea/workspace/JavaSE-Cajero-2/DB/bankua2bertsioa";
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
        public String getUrl()
        {
                return urla;
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
        public void sartuTransakzioa(int transakzioZenbakiBat, int kontuZenbakiBat, java.util.Date dataBat, double kantitateBat, String motaBat)
        {
                // Deklarazioak
                String sql;
                int count;
                //------------- DATA ETA ORDUA ESKURATU -------------------------
                java.util.Date gaurkoDataOrdua = new java.util.Date();
                SimpleDateFormat formatua;
                formatua = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String data_Time_katea;
                data_Time_katea = formatua.format(gaurkoDataOrdua);
                //---------------- INSERT TRANSAKZIOA ---------------------
                sql = "INSERT into Transakzioa VALUES (" + transakzioZenbakiBat + "," + kontuZenbakiBat + ",'"  + data_Time_katea + "'," + kantitateBat + ", '" + motaBat + "')";
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
        }
        public HashMap irakurriBezeroak()
        {
                // Deklarazioak
                String query = "select * from Bezeroa";
                HashMap accounts;
                ResultSet resultSet;
                // Initilization
                accounts = new HashMap();
                try
                {
                        // SQL exekutatu
                        resultSet = sententzia.executeQuery(query);
                        //Resultset-eko errenkada eta zutabe guztiak kapturatu
                        while (resultSet.next())
                        {
                                int bezeroID = Integer.parseInt(resultSet.getString(1));
                                int pinZenbakia = Integer.parseInt(resultSet.getString(2));
                                String bezeroaIzena = resultSet.getString(3);
                                long bezeroaTelefonoZenbakia = Long.parseLong(resultSet.getString(4));
                                System.out.println("Bezeroa: bezeroID = " + bezeroID + " | " + "pinZenbakia = " + pinZenbakia + " | " + "bezeroaIzena = " + bezeroaIzena + " | " + "bezeroaTelefonoZenbakia = " + bezeroaTelefonoZenbakia + " | ");
                                Bezeroa nire_bezeroa;
                                nire_bezeroa = new Bezeroa(bezeroID,pinZenbakia,bezeroaIzena, bezeroaTelefonoZenbakia);
                                //public V put(K key, V value)|| HashMap key,value SARTU
                                accounts.put(new Integer(bezeroID), nire_bezeroa);
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
        public void saldoaEguneratu(int kontuZenbakia, double saldoa)
        {
             //----UPDATE KONTUA -----KONTUAREN SALDOA EGUNERATU ---------------------
                // Deklarazioak
                String sql2;
                // Hasieraketa
                sql2 = "UPDATE Kontua Set Saldo_Zaharra= " + saldoa + " WHERE Kontu_Zenbakia = "  + kontuZenbakia ;
                try
                {
                        // Insert sql exekutatu sartutako erregistroak itzuliz
                         sententzia.executeUpdate(sql2);
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
        public double saldoaEman( int kontuZenbakia)
        {
            ResultSet resultSet;
            double saldoa;
            saldoa = 0.0;
            String query = "select Saldo_Zaharra from Kontua where Kontu_Zenbakia=" + kontuZenbakia ;
            try
                {
                        // SQL exekutatu
                        resultSet = sententzia.executeQuery(query);
                        //Resultset-eko errenkada eta zutabe guztiak kapturatu
                        while (resultSet.next())
                        {
                            saldoa=Double.parseDouble(resultSet.getString(1));
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
                        return saldoa;
                }
        }
        public boolean bezeroaBalidatu(int bezeroID, int pin) throws SQLException
        {
            ResultSet resultSet = null;
            boolean emaitza = false;
            String query = "select * from Bezeroa where BezeroID=" + bezeroID + " and Pin_Zenbakia= " + pin+" ";
            try
                {
                        // SQL exekutatu
                        resultSet = sententzia.executeQuery(query);
                        //BEGIRATU EA ZEOZER DAUKAN
                        while (resultSet.next())
                        {
                             emaitza=true;
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
                        //resultSet.close();
                        return emaitza;
                }

        }
        public Vector<Integer> bezero_Baten_Kontuak_Kargatu(int bezeroID)
        {
            Vector<Integer> emaitza = null;
            ResultSet resultSet;
            emaitza=new Vector<>();
            String query = "select A.Kontu_Zenbakia,Saldo_Zaharra from Kontua as A inner join Bezeroaren_Kontuak as B on A.Kontu_Zenbakia=B.Kontu_Zenbakia where Bezero_ID=" + bezeroID ;
            try
                {
                        // SQL exekutatu
                        resultSet = sententzia.executeQuery(query);
                        //Resultset-eko errenkada eta zutabe guztiak kapturatu
                        while (resultSet.next())
                        {     
                               Integer zenbakia = new Integer(resultSet.getString(1));
                               emaitza.add(zenbakia);   
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
                        return emaitza;
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
}

