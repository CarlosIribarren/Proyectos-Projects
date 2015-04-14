package LogikaMaila;

// Class izena: 	LogikaMaila.Kutxazaina.java
// Function:	Bigarren mailaren kontrolatzailea edo Facade eta Singleton

import LogikaMaila.Transakzioak.Kontsulta;
import LogikaMaila.Transakzioak.Transakzioa;
import LogikaMaila.Bezeroak.Bezeroa;
import LogikaMaila.Bezeroak.BezeroNagusia;
import LogikaMaila.Kontuak.KontuNagusia;
import LogikaMaila.Kontuak.Kontua;
import LogikaMaila.Transakzioak.DiruAteratze;
import LogikaMaila.Transakzioak.Gordailua;
import java.sql.SQLException;
import java.text.*;
import java.util.Vector;

public class Kutxazaina
{
        private static Kutxazaina instantzia;
	private KontuNagusia kontuNagusia;
	private Kontua kontua;
        private double kutxazainSaldoa;
        private Bezeroa uneko_bezeroa;
        private BezeroNagusia bezeroNagusia;
          
        public static Kutxazaina instantzia()
        {
            if (instantzia == null)
                        instantzia = new Kutxazaina();
            return instantzia;
        }  
        private Kutxazaina()
        {
                this.setKontuNagusia(new KontuNagusia());
                this.setKontua(new Kontua());
                this.setBezeroNagusia(new BezeroNagusia() );
                this.setKutxazainSaldoa(2500.00);    
        }
        //bezeroa balidatzen bada true itzultzen da, bestela false
        public boolean bezeroaBalidatu(int bezeroID, int pinZenbakiBat)
        {
            Bezeroa  bez;
            bez=bezeroNagusia.aurkituBezeroa(bezeroID, pinZenbakiBat);
            if ( bez == null)
            {
               return false; 
            }
            else
            {
                //kutxazainan uneko bezeroa gorde bere datu guztiekin
                this.setUneko_bezeroa(bez);
                //Kontu Nagusian bezeroenID kargatu
                kontuNagusia.setBezeroID(uneko_bezeroa.getBezeroId());
                //Kontu Nagusian bezeroen kontuen lista kargatu
                kontuNagusia.kontuak_lortu();

                return true;
            }
        }
        public Vector<Integer> bezeroaren_Kontuak_Eman()
        {

            return kontuNagusia.getBezeroaren_kontuen_lista();
        }
        public Double lortu_saldoa()
        {
            return kontuNagusia.eman_Saldoa(kontua.getKontuZenbakia());
        }
        public void sartuBukaera()
        {
                this.setKontua(null);
        }
        public Kontsulta sartuKontsulta()
        {       
                Transakzioa transakzioa;
                System.out.println("\nuneko_bezeroa:" + uneko_bezeroa.getBezeroId() );
                transakzioa = this.getKontua().eginKontsulta();
                return (Kontsulta) transakzioa;
        }
        public Gordailua sartuGordailua(double kantitateBat)
        {
                Transakzioa transakzioa;
                transakzioa = this.getKontua().eginGordailua(kantitateBat);
                kutxazainSaldoa = this.getKutxazainSaldoa();
                kutxazainSaldoa =kutxazainSaldoa + kantitateBat;
                this.setKutxazainSaldoa(kutxazainSaldoa);
                return (Gordailua) transakzioa;
        }
        public DiruAteratze sartuDirua(double kantitateBat)
        {
                Transakzioa transakzioa;
                double kutxazainSaldoa;
                kutxazainSaldoa = this.getKutxazainSaldoa();
                kutxazainSaldoa =kutxazainSaldoa + kantitateBat;
                this.setKutxazainSaldoa(kutxazainSaldoa);
                transakzioa = this.getKontua().ateraDirua(kantitateBat);
                return (DiruAteratze) transakzioa;
        }
        public Kontua getKontua()
        {
                return this.kontua;
        }
        public KontuNagusia getKontuNagusia()
        {
                return this.kontuNagusia;
        }
        public double getKutxazainSaldoa()
        {
                return this.kutxazainSaldoa;
        }
        public void setKontua(Kontua kontuBerria)
        {
                this.kontua = kontuBerria;
        }
        public Bezeroa getUneko_bezeroa() 
        {
                return uneko_bezeroa;
        }
        public void setKontuNagusia(KontuNagusia kontuNagusiBerria)
        {
                this.kontuNagusia = kontuNagusiBerria;
        }
        public void setKutxazainSaldoa(double kutxazainSaldoBerria)
        {
                this.kutxazainSaldoa = kutxazainSaldoBerria;
        }
        public void setUneko_bezeroa(Bezeroa uneko_bezeroa) 
        {
                this.uneko_bezeroa = uneko_bezeroa;
        }
        public BezeroNagusia getBezeroNagusia()
        {
            return bezeroNagusia;
        }
        public void setBezeroNagusia(BezeroNagusia bezeroNagusia) 
        {
            this.bezeroNagusia = bezeroNagusia;
        }
        public String toString()
        {
                //  Decarations
                NumberFormat numberFormat;
                // Formatuak hasieratu
                numberFormat = NumberFormat.getCurrencyInstance();
                // Irteera
                return "(Kutxazaina = "
                + "kutxazainSaldoa = " + numberFormat.format(this.getKutxazainSaldoa()) + " | " 
                + "kontuNagusia = " + this.getKontuNagusia() + ")";
        }
}
