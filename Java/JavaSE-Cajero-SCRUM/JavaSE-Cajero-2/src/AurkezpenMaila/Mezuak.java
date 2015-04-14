package AurkezpenMaila;
// Class izena: 	AurkezpenMaila.Mezuak.java
// Function:	Arkitekturaren aurkezpen maila Mezuak erakusteko
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

class Mezuak extends JPanel implements ActionListener
{       
      
	
	private NirePanela nirePanela;
        private JLabel taula;
        static private TextArea testuArea;
 
 public Mezuak()
{     	     
      this.setBackground(Color.LIGHT_GRAY);
      this.setLayout(null);
      //textu area
      testuArea = new TextArea();
      this.add(testuArea);
      testuArea .setBounds (20,550,466,100);
      testuArea.setEnabled(false);         
       // Text   
      taula   = new JLabel("Aplikazioaren gertaera nagusiak");
      this.add(taula);
      taula  .setBounds (20,500,200,50);
      // Nire Panela
      nirePanela = new NirePanela();
      this.add(nirePanela);
      nirePanela.setBounds (0,0,600,500);
      this.setBounds(0, 0, 900, 700);
      this.setVisible(true);       
} 
 static void aldatu(String A){
     testuArea.setText("");
     Mezuak.testuArea.append(A);

 }

    public void actionPerformed(ActionEvent event)
{
}
}