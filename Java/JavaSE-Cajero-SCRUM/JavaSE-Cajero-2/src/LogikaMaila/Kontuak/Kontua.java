package LogikaMaila.Kontuak;
// Class izena: 	LogikaMaila.Kontuak.Kontua.java
// Function:	Kontu baten datuak eskuratzeko klasea
import IraunkortasunaMaila.KontuDatuBasea;
import LogikaMaila.Bezeroak.Bezeroa;
import LogikaMaila.Transakzioak.DiruAteratze;
import LogikaMaila.Transakzioak.Gordailua;
import LogikaMaila.Transakzioak.Kontsulta;
import LogikaMaila.Transakzioak.Transakzioa;
import java.util.*;
import java.text.*;
public class Kontua
{
    private int kontuZenbakia;
    private double saldoZaharra;
    private ArrayList transakzioak;

    public Kontua(int kontuZenbakia, double saldoZaharra)
    {
        this.kontuZenbakia = kontuZenbakia;
        this.saldoZaharra = saldoZaharra;
        this.setTransakzioak(new ArrayList());
    }     
    public Kontsulta eginKontsulta()
    {
            // Deklarazioak
            Transakzioa transakzioa;
            int transakzioZenbakia, kontuZenbakia;
            double kantitatea;
            Date data;
            String mota;
            // Hasieraketa
            transakzioa = new Kontsulta();
            // Kontua-ri gehitu
            double balioBerria=0.0;
            this.getTransakzioak().add(transakzioa);
            // SQL taulan sartu Transakzioa
            transakzioZenbakia = transakzioa.getTransakzioZenbakia();
            data = transakzioa.getData();
            kontuZenbakia = this.getKontuZenbakia();
            kantitatea = 0.0;
            mota = new String(transakzioa.getClass().getName().substring(16, transakzioa.getClass().getName().length()));
            KontuDatuBasea.instantzia().sartuTransakzioa(transakzioZenbakia, kontuZenbakia, data, kantitatea, mota);
            // Irteera
            return (Kontsulta) transakzioa;
    }
    public Gordailua eginGordailua(double kantitateBat)
    {
            // Deklarazioak
            Transakzioa transakzioa;
            int transakzioZenbakia, kontuZenbakia;
            double kantitatea;
            Date data;
            String mota;
            // Hasieraketa
            transakzioa = new Gordailua(kantitateBat);
            // Kontua-ri gehitu
            this.getTransakzioak().add(transakzioa);
            // SQL taulan sartu Transakzioa
            transakzioZenbakia = transakzioa.getTransakzioZenbakia();
            data = transakzioa.getData();
            kontuZenbakia = this.getKontuZenbakia();
            kantitatea = transakzioa.kantitatea();
            //Kontuaren saldoa eguneratu
            double balioBerria=0.0;
            balioBerria=this.getSaldoZaharra()+kantitatea;
            this.setSaldoZaharra(balioBerria);
            KontuDatuBasea.instantzia().saldoaEguneratu(kontuZenbakia, balioBerria);
            mota = new String(transakzioa.getClass().getName().substring(16, transakzioa.getClass().getName().length()));
            KontuDatuBasea.instantzia().sartuTransakzioa(transakzioZenbakia, kontuZenbakia, data, kantitatea, mota);
            // Irteera
            return (Gordailua) transakzioa;
    }
    public DiruAteratze ateraDirua(double kantitateBat)
    {
            // Deklarazioak
            Transakzioa transakzioa;
            int transakzioZenbakia, kontuZenbakia;
            double kantitatea;
            Date data;
            String mota;
            // Hasieraketa
            transakzioa = new DiruAteratze(kantitateBat);
            // Kontua-ri gehitu
            this.getTransakzioak().add(transakzioa);
            // SQL taulan sartu Transakzioa
            transakzioZenbakia = transakzioa.getTransakzioZenbakia();
            data = transakzioa.getData();
            kontuZenbakia = this.getKontuZenbakia();
            kantitatea = transakzioa.kantitatea();
            //Kontuaren saldoa eguneratu
            double balioBerria=0.0;
            balioBerria=this.getSaldoZaharra()+kantitatea;
            this.setSaldoZaharra(balioBerria);
            KontuDatuBasea.instantzia().saldoaEguneratu(kontuZenbakia, balioBerria);

            mota = new String(transakzioa.getClass().getName().substring(16, transakzioa.getClass().getName().length()));
            KontuDatuBasea.instantzia().sartuTransakzioa(transakzioZenbakia, kontuZenbakia, data, kantitatea, mota);
            // Irteera
            return (DiruAteratze) transakzioa;
    }
    public double saldoBerria()
    {
            // Deklarazioak
            double saldoBerria;
            Iterator iterator;
            Transakzioa transakzioa;
            // Hasieraketa
            saldoBerria = this.getSaldoZaharra();
            iterator = this.transakzioak.iterator();
            // Prozesua
            while (iterator.hasNext())
            {
                    transakzioa = (Transakzioa) iterator.next();
                    saldoBerria += transakzioa.kantitatea();
            }
            // Irteera
            return saldoBerria;
    }
    public void setKontuZenbakia(int kontuZenbakiBerria)
    {
            this.kontuZenbakia = kontuZenbakiBerria;
    }

    public int getKontuZenbakia()
    {
            return this.kontuZenbakia;
    }
    public double getSaldoZaharra()
    {
            return this.saldoZaharra;
    }
    public ArrayList getTransakzioak()
    {
            return this.transakzioak;
    }
    public void setSaldoZaharra(double saldoZaharra) {
        this.saldoZaharra = saldoZaharra;
    }
    public Kontua() 
    {
    }
    public void setTransakzioak(ArrayList transakzioBerria)
    {
            this.transakzioak = transakzioBerria;
    }
}
