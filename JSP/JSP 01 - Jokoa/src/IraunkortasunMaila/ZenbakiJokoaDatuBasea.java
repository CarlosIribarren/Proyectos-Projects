package IraunkortasunMaila;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.sql.*;
import java.text.SimpleDateFormat;
public class ZenbakiJokoaDatuBasea
{
	private static ZenbakiJokoaDatuBasea instantzia;
	private String urla;
	private Connection konekzioa;
	private Statement sententzia;
        
        public static ZenbakiJokoaDatuBasea instantzia()
        {
            if (instantzia == null)
                    instantzia = new ZenbakiJokoaDatuBasea();
            return instantzia;
        }
        private ZenbakiJokoaDatuBasea()
        {
                try
                {
                        urla = "jdbc:sqlite:/home/erabiltzailea/workspace/JSP - Jokoa/DB/ZenbakiaIgarriJokoaDB";
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
        
        public boolean eginLogin(String erabi, String pass)
        {
            
            boolean emaitza=false;
            String baimena;
            ResultSet resultSet;
            String query = "select Baimena from Erabiltzailea where ErabiltzaileaID='" + erabi + "' and ErabilPasahitza='" + pass + "'";
            try
                {
                        // SQL exekutatu
                        resultSet = sententzia.executeQuery(query);
                        //Resultset-eko errenkada eta zutabe guztiak kapturatu
                        while (resultSet.next())
                        {
                            baimena=resultSet.getString(1);
                            if (baimena.equals("BAI"))
                            {
                                emaitza=true;
                            }
                            else
                            {
                                emaitza=false;
                            }
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
        public boolean existitzendaErabil(String erabi)
        {
            
            boolean emaitza=false;
            String baimena;
            ResultSet resultSet;
            String query = "select Baimena from Erabiltzailea where ErabiltzaileaID='" + erabi + "'" ;
            try
                {
                        // SQL exekutatu
                        resultSet = sententzia.executeQuery(query);
                        //Resultset-eko errenkada eta zutabe guztiak kapturatu
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
                        return emaitza;
                }           
        }        
         public int lortuAzkenSaioID()
        {
                // Deklarazioak
                String query = "select MAX(SaioaID) as Zenbat from Saioa";
                int SaioID = 0;
                ResultSet resultSet;	
                try
                {
                        // SQL exekutatu
                        resultSet = sententzia.executeQuery(query);
                        //	Resultset-eko errenkada eta zutabe guztiak kapturatu
                        while (resultSet.next())
                        {     
                                SaioID = Integer.parseInt(resultSet.getString(1));		
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
                        return SaioID;
                }
        }
 public int lortuAzkenSaiakeraID()
        {
                // Deklarazioak
                String query = "select MAX(SaiakeraID) as Zenbat from Saiakera";
                int SaiakeraID = 0;
                ResultSet resultSet;	
                try
                {
                        // SQL exekutatu
                        resultSet = sententzia.executeQuery(query);
                        //	Resultset-eko errenkada eta zutabe guztiak kapturatu
                        while (resultSet.next())
                        {     
                                SaiakeraID = Integer.parseInt(resultSet.getString(1));		
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
                        return SaiakeraID;
                }
        }         
         
         
        public void baimenaAldatu(String erabil, String baimena)
        {
            // Deklarazioak
            String sql;
             sql = "UPDATE Erabiltzailea Set Baimena= '" + baimena + "' WHERE ErabiltzaileaID = '"  + erabil + "'" ;
            System.out.println("SQL : " + sql);
            try
            {
                        // Insert sql exekutatu sartutako erregistroak itzuliz
                        sententzia.executeUpdate(sql);
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
        

    public void sartuSaioBerria(String erabil,int erantzuna, int saioa)
    {
            String sql;
            //-------------  ORDUA ESKURATU -------------------------
            java.util.Date gaurkoDataOrdua = new java.util.Date();
            SimpleDateFormat formatua;
            formatua = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String katea_data;
            katea_data = formatua.format(gaurkoDataOrdua);
            //---------------- INSERT  ---------------------
            sql = "INSERT into Saioa VALUES (" + saioa + ",'" + katea_data + "'," + 0 + ", "  + 0 + ", " + erantzuna + ", '" + erabil + "')";
            System.out.println("SQL : " + sql);
            try
            {
                    // Insert sql exekutatu sartutako erregistroak itzuliz
                    sententzia.executeUpdate(sql);
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
    
    
    
    
    public void sartuSaiakeraBat(int balioa, String laguntza, int saioaID)
    {
            String sql;
            int saiakera;
            //---------lortu saiakera zenbakia-----------------
            saiakera=lortuAzkenSaiakeraID();
            saiakera=saiakera+1;
            //eguneratu saiakera kop Saio taulan
            eguneratuSaiakeraKop(saioaID);
            sql = "INSERT into Saiakera VALUES (" + saiakera + "," + balioa + ",'" + laguntza + "', " + saioaID + ")";
            System.out.println("SQL : " + sql);
            try
            {
                    // Insert sql exekutatu sartutako erregistroak itzuliz
                    sententzia.executeUpdate(sql);
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
 public void eguneratuSaiakeraKop(int saiozenbakia)
        {
                // Deklarazioak
                String query = "select SaiakeraKopurua from Saioa where SaioaID=" + saiozenbakia ;
                int Saiakerakop = 0;
                ResultSet resultSet;	
                try
                {
                        // SQL exekutatu
                        resultSet = sententzia.executeQuery(query);
                        //	Resultset-eko errenkada eta zutabe guztiak kapturatu
                        while (resultSet.next())
                        {     
                                Saiakerakop = Integer.parseInt(resultSet.getString(1));		
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
                        Saiakerakop=Saiakerakop+1;
                        
                        String sql2;
                        // Hasieraketa
                        sql2 = "UPDATE Saioa Set SaiakeraKopurua= " + Saiakerakop + " WHERE SaioaID = "  + saiozenbakia ;
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
        }       
 public void eguneratuSarreraAkatsakKop(int saiozenbakia)
        {
                // Deklarazioak
                String query = "select SarreraAkatsak from Saioa where SaioaID=" + saiozenbakia ;
                int SarreraAkatsakop = 0;
                ResultSet resultSet;	
                try
                {
                        // SQL exekutatu
                        resultSet = sententzia.executeQuery(query);
                        //	Resultset-eko errenkada eta zutabe guztiak kapturatu
                        while (resultSet.next())
                        {     
                                SarreraAkatsakop = Integer.parseInt(resultSet.getString(1));		
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
                        SarreraAkatsakop=SarreraAkatsakop+1;
                        
                        String sql2;
                        // Hasieraketa
                        sql2 = "UPDATE Saioa Set SarreraAkatsak= " + SarreraAkatsakop + " WHERE SaioaID = "  + saiozenbakia ;
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
        }      
            
 public String DirectorioActual(){
	 String filePath="";
	try {
		filePath = new File("/DB/ZenbakiaIgarriJokoaDB").getCanonicalPath();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 String directorio = System.getProperty("java.class.path");
	 File dir = new File(directorio);
	 String directorioPadre = dir.getParent();
	 return filePath;
 }
 
 
        
}

