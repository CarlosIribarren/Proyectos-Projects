package IraunkortasunaMaila;
// Class izena: 	IraunkortasunaMaila.KontuDatuBasea.java
// Function:	Arkitekturaren iraunkortasun maila Singleton patroia
import LogikaMaila.Bezeroak.Bezeroa;
import LogikaMaila.Kontuak.Kontua;
import LogikaMaila.Sarrerak.Zinema;
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
		urla = "jdbc:sqlite:/home/erabiltzailea/workspace/JavaSE-Cajero-3/DB/bankua3bertsioa";
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
        formatua = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String data_Time_katea;
        data_Time_katea = formatua.format(gaurkoDataOrdua);
        //---------------- INSERT TRANSAKZIOA ---------------------
	java.text.DateFormat dateFormat = java.text.DateFormat.getDateTimeInstance();
	// Hasieraketa
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
    String query = "select * from Bezeroa where BezeroID=" + bezeroID + " and Pin_Zenbakia=" + pin;
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
public Vector<String> eman_Hiria()
{
    Vector<String> emaitza = null;
    ResultSet resultSet;
    emaitza=new Vector<>();
    String query = "select distinct(Hiria) from Zinema ORDER BY 1  " ;
    try
	{
		// SQL exekutatu
		resultSet = sententzia.executeQuery(query);
		//Resultset-eko errenkada eta zutabe guztiak kapturatu
		while (resultSet.next())
		{     
                       String hiria_bat = new String(resultSet.getString(1));
                       emaitza.add(hiria_bat);   
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


public int lortuSaldutakoSarrerak(String zinema, String data)
{
    int emaitza = -1;
    ResultSet resultSet;
    String query = "select ErositakoSarrerak from Zinema_Data where Zinema='" + zinema + "' and Data=   '" + data + "'";
    
    try
	{
		// SQL exekutatu
		resultSet = sententzia.executeQuery(query);
		//Resultset-eko errenkada eta zutabe guztiak kapturatu
		while (resultSet.next())
		{     
                     
                       emaitza = Integer.parseInt(resultSet.getString(1));
                         
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


public Vector<Zinema> eman_ZinemaLista( String hiria)
{
    Vector<Zinema> emaitza = null;
    ResultSet resultSet;
    emaitza=new Vector<>();
    String query = "select * from Zinema where Hiria=   '" + hiria + "' ";
    
    try
	{
		// SQL exekutatu
		resultSet = sententzia.executeQuery(query);
		//Resultset-eko errenkada eta zutabe guztiak kapturatu
		while (resultSet.next())
		{     
                       String zinema_bat = new String(resultSet.getString(1));
                       String hiria_bat = new String(resultSet.getString(2));
                       int sarrera_total = Integer.parseInt(resultSet.getString(3));
                       Zinema zinemasartu = new Zinema(zinema_bat,hiria_bat,sarrera_total);
                       emaitza.add(zinemasartu);   
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

public Zinema emanZineBat( String izena)
{
    Zinema emaitza = null;
    ResultSet resultSet;
    emaitza=new Zinema();
    String query = "select * from Zinema where Zinema= '" + izena + "' ";
    
    try
	{
		// SQL exekutatu
		resultSet = sententzia.executeQuery(query);
		//Resultset-eko errenkada eta zutabe guztiak kapturatu
		while (resultSet.next())
		{     
                       String zinema_bat = new String(resultSet.getString(1));
                       String hiria_bat = new String(resultSet.getString(2));
                       int sarrera_total = Integer.parseInt(resultSet.getString(3));
                       emaitza.setIzena(izena);
                       emaitza.setHiria(hiria_bat);   
                       emaitza.setSarrera_totala(sarrera_total);
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




public void sartuErosketa(int bezeroID, int kontuZenbakiBat,String zinemaIzena, String sarreraEguna)
{
	// Deklarazioak
	String sql;
	int count;
        //-------------  ORDUA ESKURATU -------------------------
        java.util.Date gaurkoDataOrdua = new java.util.Date();
        SimpleDateFormat formatua;
        formatua = new SimpleDateFormat("HH:mm:ss");
        String time_katea;
        time_katea = formatua.format(gaurkoDataOrdua);
        //---------------- INSERT EROSKETA ---------------------
	sql = "INSERT into Erosketak VALUES (" + bezeroID + "," + kontuZenbakiBat + ",'" + zinemaIzena + "', '"  + sarreraEguna + "', '" + time_katea + "')";
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


public void sartu_DataZinema(String zinema, String data)
{
    int salduta;
    salduta= this.lortuSaldutakoSarrerak(zinema, data);
    if (salduta==-1)
    {
            //Egun horrten ez daude sarrerak salduta oraindik 
            //insert
   // Deklarazioak
        salduta=1;
            String sql3;
            // Hasieraketa
            sql3 = "INSERT into Zinema_Data values ('" + zinema + "', '"  + data + "', " + salduta + ")";
            try
            {
                    // Insert sql exekutatu sartutako erregistroak itzuliz
                     sententzia.executeUpdate(sql3);
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
    else
    {   
            salduta=salduta+1;
             //Egun horrten bai daude sarrerak salduta  
             //update
         
            // Deklarazioak
            String sql2;
            // Hasieraketa
            sql2 = "UPDATE Zinema_Data Set ErositakoSarrerak= " + salduta + " WHERE  Zinema='" + zinema + "' and Data=   '" + data + "'";
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

