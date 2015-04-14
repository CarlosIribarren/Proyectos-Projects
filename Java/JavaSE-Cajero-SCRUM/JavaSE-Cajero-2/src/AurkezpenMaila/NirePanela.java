package AurkezpenMaila;
// Class izena: 	banku_kutxazain.NirePanela.java
// Function:	Arkitekturaren aurkezpen maila
import IraunkortasunaMaila.KontuDatuBasea;
import LogikaMaila.Bezeroak.Bezeroa;
import LogikaMaila.Kontuak.Kontua;
import LogikaMaila.Kutxazaina;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NirePanela extends JPanel implements ActionListener
{
	// Kontrolak
        private JComboBox combo1;
	private JPasswordField testuEremuaPinZenbakia;
	private JButton botoiaBalioztatu, botoiaGordailua, botoiaDiruAteratzea, botoiaKontsulta, botoiaBukatu;
	private JTextField testuEremuaBezeroID, testuEremuaSaldoa, testuEremuaGordailua, testuEremuaDiruAteratzea, testuEremuaSaldoBerria ;
	private JLabel etiketaIzena, etiketaBezeroID, etiketaPinZenbakia, etiketaSaldoa, etiketaGordailua, etiketaDiruAteratzea, etiketaSaldoBerria;
	// Modeloak
	private Bezeroa bezero;
        private Kontua kontua;
	// Utilitatea
	private NumberFormat numberFormat;
	
	public NirePanela()
	{
		// Utilitatea hasieratu
		numberFormat = NumberFormat.getCurrencyInstance();
		// Leihoak doitu
		this.setFont(new Font("Arial", Font.PLAIN, 12));
		this.setBackground(Color.lightGray);
		this.setLayout(new GridLayout(7, 3, 25, 25));
		this.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
		// Kontrolak hasieratu
		gehituKontrolak();
		try
		{
		  jbInit();
		}
		catch(Exception e)
		{
		  e.printStackTrace();
		}
	}

        
	public void actionPerformed(ActionEvent event)
	{
		//BOTOIA SARTU BALIOZTATU
		if (event.getSource() == botoiaBalioztatu)
		{
                    //egiaztatu zenbakiak sartu dituela
                    if ( isNumeric(testuEremuaBezeroID.getText())==false || isNumeric(new String(testuEremuaPinZenbakia.getPassword()))==false ) 
                    {
                        JOptionPane.showMessageDialog(this, "Mesedez 2 eremuetan zenbakiak sartu!!", "Adi", JOptionPane.WARNING_MESSAGE);
                    }
                    else
                    {
			// Deklarazioak
			int bezeroID, pinZenbakia;
			// BEZEROAREN DATUAK(KONTUZENBAKIA ETA PINZENBAKIA) IRAKURRI
			bezeroID = Integer.parseInt(testuEremuaBezeroID.getText());
			pinZenbakia = Integer.parseInt(new String(testuEremuaPinZenbakia.getPassword()));				
                        // BEZEROA BALIDATU
			Boolean balidazioa = Kutxazaina.instantzia().bezeroaBalidatu(bezeroID, pinZenbakia);		   
                        // Erroreak egiaztatu
                        if (balidazioa == true)
                            {
				// KONTUZENBAKIA ETA PINZENBAKIA ONA 
				Vector kontu_Zerrenda;
				// BEZEROAREN KONTUAK COMBOAM KARGATU
				kontu_Zerrenda = Kutxazaina.instantzia().bezeroaren_Kontuak_Eman();        
				Iterator iteratzailea;
				iteratzailea = kontu_Zerrenda.iterator();
                                combo1.setEnabled(true);
				for(int a=0;a<kontu_Zerrenda.size();a++) 
				{	
					 combo1.addItem(kontu_Zerrenda.elementAt(a));
				}
                                Mezuak.aldatu("Balidatu egin da");
				// BOTOIAK ETA TESTU EREMUAK GAITU
				botoiaBalioztatu.setEnabled(false);
				botoiaKontsulta.setEnabled(true);
				botoiaGordailua.setEnabled(true);
				botoiaDiruAteratzea.setEnabled(true);
				botoiaBukatu.setEnabled(true);
				testuEremuaBezeroID.setEditable(false);
				testuEremuaPinZenbakia.setEditable(false);
				testuEremuaGordailua.setEditable(true);
				testuEremuaDiruAteratzea.setEditable(true);      
			}
			else		
                        {
				//KONTUZENBAKIA ETA PINZENBAKIA TXARRA
				JOptionPane.showMessageDialog(this, "BezeroID edo Pasahitz desegokiak!!", "Balioztatu", JOptionPane.WARNING_MESSAGE);
                                this.testuEremuaBezeroID.setText("");
                                this.testuEremuaPinZenbakia.setText("");
                                this.testuEremuaBezeroID.requestFocus();
			}
                    }
		}
                
		//COMBO1 AUKERA EGITEN DENEAN
                if (event.getSource() == combo1)
		{                                                     
                    if(combo1.isEnabled()==true)
                    {
                        if (combo1.getSelectedIndex()==-1 && this.testuEremuaBezeroID.getText()!="")
                        {
                            JOptionPane.showMessageDialog(this, "Aukeratu kontu bat mesedez", "Title", JOptionPane.WARNING_MESSAGE);
                        }
                        else
                        {
                             //datuak eskuratu
                             int kontuZenbakia= Integer.parseInt(combo1.getSelectedItem().toString()); 
                             Kutxazaina.instantzia().getKontua().setKontuZenbakia(kontuZenbakia);
                             double saldoa= (double)Kutxazaina.instantzia().lortu_saldoa();
                             Kontua kontua= new Kontua(kontuZenbakia , saldoa);
                             Kutxazaina.instantzia().setKontua(kontua);
                             kontua.setKontuZenbakia(kontuZenbakia);
                             testuEremuaSaldoa.setText("");
                             testuEremuaGordailua.setText("");
                             testuEremuaDiruAteratzea.setText("");
                             testuEremuaSaldoBerria .setText("");  
                             Mezuak.aldatu("");
                        }                  
                    } 		  
		}
                
		//----------------  KONTSULTA -------------------
		if (event.getSource() == botoiaKontsulta)
		{
			// Modeloa sartu 
			Kutxazaina.instantzia().sartuKontsulta();
			// Irteera
			testuEremuaSaldoa.setText(numberFormat.format(Kutxazaina.instantzia().getKontua().getSaldoZaharra()));
			// Botoiak eta testu eremuak gaitu  
			botoiaBalioztatu.setEnabled(false);
			botoiaKontsulta.setEnabled(true);
			botoiaGordailua.setEnabled(true);
			botoiaDiruAteratzea.setEnabled(true);
			botoiaBukatu.setEnabled(true);
			testuEremuaBezeroID.setEditable(false);
			testuEremuaPinZenbakia.setEditable(false);
			testuEremuaGordailua.setEditable(true);
			testuEremuaDiruAteratzea.setEditable(true);
                	testuEremuaGordailua.setText("");
			testuEremuaDiruAteratzea.setText("");
			testuEremuaSaldoBerria .setText("");
                        Mezuak.aldatu("Zure kontua " + combo1.getSelectedItem().toString()+ " saldoa " + this.testuEremuaSaldoa.getText() + " da");                        
		}
		//------------- GORDAILUA ------------------
		if (event.getSource() == botoiaGordailua)
		{ 
                    //egiaztatu zenbakiak sartu dituela
                    if ( isNumeric(testuEremuaGordailua.getText())==false ) 
                    {
                        JOptionPane.showMessageDialog(this, "Mesedez gordailu eremuan zenbakia bat sartu!!", "Adi", JOptionPane.WARNING_MESSAGE);
                        testuEremuaGordailua.setText("");
                        testuEremuaGordailua.requestFocus();
                    }
                    else          
                    { 
                        // Deklarazioak
                        double gordailuKantitatea, saldoBerria;
                        // Input
                        String sartutakoKantitatea = testuEremuaGordailua.getText();       
                        gordailuKantitatea = Double.valueOf(sartutakoKantitatea).doubleValue();
                        // Modeloa sartu 
                        Kutxazaina.instantzia().sartuGordailua(gordailuKantitatea);
                        // Irteera
                        testuEremuaGordailua.setText(numberFormat.format(gordailuKantitatea));
                        testuEremuaSaldoBerria.setText(numberFormat.format(Kutxazaina.instantzia().getKontua().getSaldoZaharra()));
                        // Botoiak eta testu eremuak gaitu
                        botoiaBalioztatu.setEnabled(false);
                        botoiaKontsulta.setEnabled(true);
                        botoiaGordailua.setEnabled(true);
                        botoiaDiruAteratzea.setEnabled(true);
                        botoiaBukatu.setEnabled(true);
                        testuEremuaBezeroID.setEditable(false);
                        testuEremuaPinZenbakia.setEditable(false);
                        testuEremuaGordailua.setEditable(true);
                        testuEremuaDiruAteratzea.setEditable(true);
                        Mezuak.aldatu("Zure kontu zenbaki " + combo1.getSelectedItem().toString() + " honetan, " + testuEremuaGordailua.getText() + " diru sarrera egin da!!\nZure kontua " + combo1.getSelectedItem().toString()+ " orain " + testuEremuaSaldoBerria.getText() + " diru dauka\nKutzainaren saldoa hau da:" + Kutxazaina.instantzia().getKutxazainSaldoa());
                        testuEremuaGordailua.setText("");
                        testuEremuaDiruAteratzea.setText("");
                        testuEremuaSaldoa.setText("");                   
                    }        
                }  
		if (event.getSource() == botoiaDiruAteratzea)
		{                           
                    //egiaztatu zenbakiak sartu dituela
                    if ( isNumeric(testuEremuaDiruAteratzea.getText())==false ) 
                    {
                        JOptionPane.showMessageDialog(this, "Mesedez ateratze eremuan zenbakia bat sartu!!", "Adi", JOptionPane.WARNING_MESSAGE);
                        testuEremuaDiruAteratzea.setText("");
                        testuEremuaDiruAteratzea.requestFocus();  
                    }
                    else          
                    {   
                        double kutxazainSaldoa, kantitatea;
                        kutxazainSaldoa= Kutxazaina.instantzia().getKutxazainSaldoa();    
                        kantitatea=   Double.valueOf(testuEremuaDiruAteratzea.getText()).doubleValue();
                        if ((kutxazainSaldoa) - (kantitatea) >= 0 )
                        {                        
                            // Deklarazioak
                            double diruAteratzeKantitatea, saldoBerria;
                            // Input
                            String sartutakoKantitatea = testuEremuaDiruAteratzea.getText();
                            diruAteratzeKantitatea = Double.valueOf(sartutakoKantitatea).doubleValue();
                            // Modeloa sartu 
                            Kutxazaina.instantzia().sartuDirua(diruAteratzeKantitatea*(-1));
                            // Irteera
                            saldoBerria = Kutxazaina.instantzia().getKontua().saldoBerria();
                            testuEremuaDiruAteratzea.setText(numberFormat.format(diruAteratzeKantitatea));
                            testuEremuaSaldoBerria .setText(numberFormat.format(Kutxazaina.instantzia().getKontua().getSaldoZaharra()));
                            // Botoiak eta testu eremuak gaitu
                            botoiaBalioztatu.setEnabled(false);
                            botoiaKontsulta.setEnabled(true);
                            botoiaGordailua.setEnabled(true);
                            botoiaDiruAteratzea.setEnabled(true);
                            botoiaBukatu.setEnabled(true);
                            testuEremuaBezeroID.setEditable(false);
                            testuEremuaPinZenbakia.setEditable(false);
                            testuEremuaGordailua.setEditable(true);
                            testuEremuaDiruAteratzea.setEditable(true);
                            Mezuak.aldatu("Zure kontu zenbaki " + combo1.getSelectedItem().toString() + " honetan, " + testuEremuaDiruAteratzea.getText() + " diru atera egin da!!\nZure kontua " + combo1.getSelectedItem().toString()+ " orain " + testuEremuaSaldoBerria.getText() + " diru dauka\nKutzainaren saldoa hau da:" + Kutxazaina.instantzia().getKutxazainSaldoa());
                            testuEremuaGordailua.setText("");
                            testuEremuaDiruAteratzea.setText("");
                            testuEremuaSaldoa.setText("");
                        }
                        else
                        {
                             //ez dago saldo nahikorik atera nahi duen diruarentzako
                             JOptionPane.showMessageDialog(this, "Kutxazainak ez dauka nahiko saldorik atera nahi duzun diruarentzako", "KUTXAZAINA SALDO GABE", JOptionPane.WARNING_MESSAGE);
                            testuEremuaGordailua.setText("");
                            testuEremuaDiruAteratzea.setText("");
                            testuEremuaSaldoa.setText(""); 
                            Mezuak.aldatu("");
                        }
                    }
                
		}
		if (event.getSource() == botoiaBukatu)
		{	
			// Eremuak ezabatu
			testuEremuaBezeroID.setText("");
			testuEremuaPinZenbakia.setText("");
			testuEremuaSaldoa.setText("");
			testuEremuaGordailua.setText("");
			testuEremuaDiruAteratzea.setText("");
			testuEremuaSaldoBerria .setText("");
			// Botoiak eta testu eremuak gaitu
			botoiaBalioztatu.setEnabled(true);
			botoiaGordailua.setEnabled(false);
			botoiaDiruAteratzea.setEnabled(false);
			botoiaBukatu.setEnabled(false);
			botoiaKontsulta.setEnabled(false);
			testuEremuaBezeroID.setEditable(true);
			testuEremuaPinZenbakia.setEditable(true);
			testuEremuaGordailua.setEditable(false);
			testuEremuaDiruAteratzea.setEditable(false);
                        combo1.setEnabled(false);
                        this.combo1.removeAllItems();
                        testuEremuaBezeroID.requestFocus();
                        Mezuak.aldatu("Mesedez bezeroID eta pasahitz bat sartu!");
		}
	}
	
	private void gehituKontrolak()
	{
		// private metodo lagungarria clutter-a paneleko eraiketzailetik kentzeko
		// Grid (row=1, col=1)
		etiketaBezeroID = new JLabel("Bezeroaren ID :");
		this.add(etiketaBezeroID);
		// Grid (row=1, col=2)
		testuEremuaBezeroID = new JTextField();
		this.add(testuEremuaBezeroID);
		// Grid (row=1, col=3)
		this.add(new JLabel("                 "));
		// Grid (row=2, col=1)
		etiketaPinZenbakia = new JLabel("Bezeroaren Pasahitz :");
		this.add(etiketaPinZenbakia);
		// Grid (row=2, col=2)
		testuEremuaPinZenbakia = new JPasswordField();
		this.add(testuEremuaPinZenbakia);
		// Grid (row=2, col=3)
		botoiaBalioztatu = new JButton("Balioztatu");
		this.add(botoiaBalioztatu);
		//KONTU ETIKETA	
		etiketaPinZenbakia = new JLabel("Kontua :");
		this.add(etiketaPinZenbakia);
		//BEZEROAREN KONTUAK COMBO	
		combo1 = new JComboBox ();	
		this.add(combo1);
		combo1.addActionListener(this);
		this.add(new JLabel("                 "));
                //combo1 izkutatu
                combo1.setEnabled(false);
		botoiaBalioztatu.addActionListener(this);
		// Grid (row=3, col=1)
		etiketaSaldoa = new JLabel("Saldoa :");
		this.add(etiketaSaldoa);
		// Grid (row=3, col=2)
		testuEremuaSaldoa = new JTextField();
		this.add(testuEremuaSaldoa);
		testuEremuaSaldoa.setEditable(false);
		// Grid (row=3, col=3) 
		botoiaKontsulta = new JButton("Kontsulta");
		this.add(botoiaKontsulta);
		botoiaKontsulta.addActionListener(this);
		// Grid (row=4, col=1)
		etiketaGordailua = new JLabel("Gordailua :");
		this.add(etiketaGordailua);
		// Grid (row=4, col=2)
		testuEremuaGordailua = new JTextField();
		this.add(testuEremuaGordailua);
		// Grid (row=4, col=3)
		botoiaGordailua = new JButton("Gordailua");
		this.add(botoiaGordailua);
		botoiaGordailua.addActionListener(this);
		// Grid (row=5, col=1)
		etiketaDiruAteratzea = new JLabel("DiruAteratzea :");
		this.add(etiketaDiruAteratzea);
		// Grid (row=5, col=2)
		testuEremuaDiruAteratzea = new JTextField();
		this.add(testuEremuaDiruAteratzea);
		// Grid (row=5, col=3)
		botoiaDiruAteratzea = new JButton("DiruAteratzea");
		this.add(botoiaDiruAteratzea);
		botoiaDiruAteratzea.addActionListener(this);
		// Grid (row=6, col=1)
		etiketaSaldoBerria = new JLabel("Saldo berria :");
		this.add(etiketaSaldoBerria);
		// Grid (row=6, col=2)
		testuEremuaSaldoBerria  = new JTextField();
		this.add(testuEremuaSaldoBerria );
		testuEremuaSaldoBerria .setEditable(false);
		// Grid (row=6, col=3)
		botoiaBukatu = new JButton("Bukatu");
		this.add(botoiaBukatu);
		botoiaBukatu.addActionListener(this);
		// Botoiak eta testu eremuak ezgaitu
		botoiaGordailua.setEnabled(false);
		botoiaDiruAteratzea.setEnabled(false);
		botoiaBukatu.setEnabled(false);
		botoiaKontsulta.setEnabled(false);
		testuEremuaGordailua.setEditable(false);
		testuEremuaDiruAteratzea.setEditable(false);
	}

	  private void jbInit() throws Exception
	  {
		testuEremuaGordailua.setSize(new Dimension(486, 300));
	  }

          public static boolean isNumeric(String string)
          {
              try{
                  Integer.parseInt(string);
              }catch (Exception e)
                      {
                         return false;
                      }
              return true;
          }
          
}
