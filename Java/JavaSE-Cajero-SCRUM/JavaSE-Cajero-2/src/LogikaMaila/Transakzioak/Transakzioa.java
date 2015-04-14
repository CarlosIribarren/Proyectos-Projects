package LogikaMaila.Transakzioak;

// Class izena: 	banku_kutxazain.Transakzioa.java
// Function:	Transakzioaren domeinu abstraktua 

import LogikaMaila.ObjetuIkuskatzailea;
import IraunkortasunaMaila.KontuDatuBasea;
import LogikaMaila.ObjetuIkuskatzailea;
import java.util.Date;

public abstract class Transakzioa
{
	private Date data;
	private int transakzioZenbakia;
	private static int azkenTransakzioarenZenbakia = 30000;
	private int kontuZenbakia;
        private int bezeroa;
	
static public void Transkazioa()
{
	azkenTransakzioarenZenbakia = KontuDatuBasea.instantzia().irakurriHasierakoTransakzioZenbakia();
}
  
public double kantitatea()
{
	return 0.0;
}
public int getKontuZenbakia()
{
	return kontuZenbakia;
}
public Date getData()
{
	return data;
}
public static int getAzkenTransakzioarenZenbakia()
{
	return azkenTransakzioarenZenbakia;
}
public int getTransakzioZenbakia()
{
	return transakzioZenbakia;
}
public void setKontuZenbakia(int KontuZenbakiBerria)
{
	kontuZenbakia = KontuZenbakiBerria;
}
public void setData(Date dataBerria)
{
	this.data = dataBerria;
}
public static void setAzkenTransakzioarenZenbakia(int azkenTransakzioarenZenbakiBerria)
{
	azkenTransakzioarenZenbakia = azkenTransakzioarenZenbakiBerria;
}
public void setTransakzioZenbakia(int transakzioZenbakiBerria)
{
	this.transakzioZenbakia = transakzioZenbakiBerria;
}

    public int getBezeroa() {
        return bezeroa;
    }

    public void setBezeroa(int bezeroa) {
        this.bezeroa = bezeroa;
    }
public String toString()
{
	try
	{
		return ObjetuIkuskatzailea.toString(this);
	}
	catch (Exception exception)
	{
		return "errorea To String -n";
	}
}
}
