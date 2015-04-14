package AurkezpenMaila;
// Class izena: 	AurkezpenMaila.PanelaSarrerak.java
// Function:	Arkitekturaren aurkezpen maila zinemako sarrerak erosteko
import LogikaMaila.GureJcalendar;
import IraunkortasunaMaila.KontuDatuBasea;
import LogikaMaila.Kutxazaina;
import LogikaMaila.Sarrerak.Zinema;
import java.awt.Color;
import java.awt.Container;
import java.util.*;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import javax.swing.event.EventListenerList;

class PanelaSarrerak extends JPanel implements ActionListener
{       private String eguna;
        private NirePanela nirePanela;
        private GureJcalendar calenda;
        private JComboBox hiria,zinema;
        private JButton ordaindu;
        private JLabel zarrera,taula,hiriText,zineText,ordainduText;
        static private TextArea testuArea;
        private int kont=0;
 public PanelaSarrerak()
{     	     
       
      this.setBackground(Color.LIGHT_GRAY);
       this.setLayout(null);
    
       // Nire Panela
        nirePanela = new NirePanela();
        this.add(nirePanela);
        nirePanela.setBounds (0,0,486,500);
      
       //textu area
       testuArea = new TextArea();
        this.add(testuArea);
       testuArea .setBounds (20,550,466,100);
       testuArea.setEnabled(false);
      
       //Egutegia
       calenda = new GureJcalendar();
       this.add(calenda);
       calenda.setBounds(486, 100, 400, 400);
      
       
               
       // Text   
      taula   = new JLabel("Aplikazioaren gertaera nagusiak");
      this.add(taula);
      taula  .setBounds (20,500,200,50);
      
      zarrera = new JLabel("SARRERA-TXARTELA EROSI :");
      this.add(zarrera);
      zarrera .setBounds (486,15,250,50);
       
      hiriText  = new JLabel("HIRIA :");
      this.add(hiriText);
      hiriText  .setBounds (486,50,50,50);
     
      zineText = new JLabel("ZINEMA :");
      this.add(zineText);
      zineText  .setBounds (680,50,200,50);
       
      ordainduText  = new JLabel("AUKERATU KONTUA ETA ORDAINDU");
      this.add(ordainduText);
      ordainduText.setBounds (500,500,250,50);
       
      //combobox
      hiria= new JComboBox();
      this.add(hiria);      
      hiria.setBounds (540,66,90,20);
      
      Vector<String> hiriak_lista = new Vector<String>();
      hiriak_lista =Kutxazaina.instantzia().hiri_Guztiak_Eman();
           
     
          
      Iterator iteratzailea;
      iteratzailea = hiriak_lista.iterator();
      hiria.setEnabled(true);
      for(int a=0;a<hiriak_lista.size();a++) 
      {	
          hiria.addItem(hiriak_lista.elementAt(a));                                
      }
        
      //añadir;
      //ACTION LISTENER
      hiria.addActionListener(this);
         
      zinema  =new JComboBox();
      this.add(zinema);
      zinema.setBounds (730,66,90,20);
      zinema.addActionListener(this);     
      //botoia
       ordaindu= new JButton("ORDAINDU");
       this.add(ordaindu);
       ordaindu.setBounds (730,505,140,40);
       ordaindu.addActionListener(this);
         
     
        zinema.setEnabled(false);
        ordaindu.setEnabled(false);
        this.setBounds(0, 0, 900, 700);
        this.setVisible(true); 
        
        
        
}  
 static void aldatu(String A){
     testuArea.setText("");
     PanelaSarrerak.testuArea.append(A);

 }
 public void setEguna(String Eguna)
{
	eguna = Eguna;
}


 
   
   
 
    public void actionPerformed(ActionEvent event)
{
   
    
      if (event.getSource() == hiria)
      {
        if( nirePanela.getBalioztatua()==false)
        {
             PanelaSarrerak.aldatu("Lehenengo zure bezeroa balidatua egon behar du");
        }
        else
        {
            
            //zinema.removeAllItems();
            if (zinema.isEnabled()==false)
            {
                zinema.setEnabled(true);
            }
            if (ordaindu.isEnabled()==false)
            {
               ordaindu.setEnabled(true);
               ordaindu.addActionListener(this);
               
                
            }
            zinema.removeActionListener(this);
            zinema.removeAllItems();
            zinema.addActionListener(this);
            
                  //ZINEMA COMBO BETE
                  Vector<Zinema> zinema_lista = new Vector<Zinema>();
                  zinema_lista =Kutxazaina.instantzia().lortu_zinemaLista(hiria.getSelectedItem().toString());
                  Iterator iteratzailea;
                  iteratzailea = zinema_lista.iterator();
                  for(int a=0;a<zinema_lista.size();a++) 
                      {	
                          zinema.addItem(zinema_lista.elementAt(a).getIzena());                                
                      }
                  zinema_lista.clear();
                           
              
        }
      }
      
        if(event.getSource()==zinema)
        {
            //aukeratua dago

            //ZINEMA OBJ SORTU KUTXAZAINEAN 
            String aukera_zinema= new String();
            aukera_zinema=zinema.getSelectedItem().toString();
            Zinema z1=new Zinema();
            z1=Kutxazaina.instantzia().lortu_Zinema(aukera_zinema);
            Kutxazaina.instantzia().setUneko_zinema(z1);
            calenda.setEnabled(true);
   
             PanelaSarrerak.aldatu("hau da zinema" + Kutxazaina.instantzia().getUneko_zinema().getIzena());    

        }         
      
      
        if(event.getSource()==ordaindu)
        {
              kont++;
              if (kont==1)
              {           
                  kont=kont-2;
                        if (zinema.getSelectedIndex()==-1 && calenda.eguna()==null)
                        {
                               JOptionPane.showMessageDialog(this, "Aukeratu zinema bat mesedez", "Title", JOptionPane.WARNING_MESSAGE);
                               ordaindu.setEnabled(false);
                        }
                        else
                        {
                            
                            if ( calenda.getData_Time_katea()==null)
                            {
                                    JOptionPane.showMessageDialog(this, "Aukeratu egun bat mesedez", "", JOptionPane.WARNING_MESSAGE);
                                    
                            }
                            else
                            {                           
                                int sarrera_max=0,saldutako_kop=0;
                                saldutako_kop= Kutxazaina.instantzia().getZinema_nagusia().getSaldutakoSarrera_Kop();
                                sarrera_max=Kutxazaina.instantzia().getZinema_nagusia().getUneko_zinema().getSarrera_totala();
                                if (sarrera_max-saldutako_kop>0)
                                {

                                    if (nirePanela.eman_Balioztaturen_Enable_Panelean()==false)
                                    {     
                                        
                                        
                                        
                                       eguna=calenda.eguna();
                                       Kutxazaina.instantzia().sarreraErosi(eguna.toString());  
                                        saldutako_kop= Kutxazaina.instantzia().getZinema_nagusia().getSaldutakoSarrera_Kop();
                                       PanelaSarrerak.aldatu("<<<<<<Erosketa Laburpena>>>>>>>\n-Kontu zenbakia: " + Kutxazaina.instantzia().getKontua().getKontuZenbakia() + " -Zinema : " +  Kutxazaina.instantzia().getZinema_nagusia().getUneko_zinema().getIzena().toString() + "\n-Eguna: " + eguna.toString() +  "   -Prezioa : 5 Euro  \n-Kutxazaina egun horretako saldutako sarrera kopurua " + saldutako_kop +  "/ " + Kutxazaina.instantzia().getUneko_zinema().getSarrera_totala().toString()+"\n-Kutzainaren saldoa hau da:" + Kutxazaina.instantzia().getKutxazainSaldoa());
                                       nirePanela.garbitu();
                                       JOptionPane.showMessageDialog(this, "Erosketa ondo egin da", "Sarrera Erosketa", JOptionPane.WARNING_MESSAGE);
                                       
                                      
                                       
                                    }
                                    //mezua
                                    else
                                    {
                                        JOptionPane.showMessageDialog(this, "Balioztatu berezo bezala mesedez", "Bezero", JOptionPane.WARNING_MESSAGE);
                                    }
                
                                    
                                }
                                else
                                {
                                    JOptionPane.showMessageDialog(this, "Ez daude sarrera gehiago, agortu egin dira.", "", JOptionPane.WARNING_MESSAGE);
                                }
                                    
                            }
                        }

              }
       

 
        }    


}
} 

