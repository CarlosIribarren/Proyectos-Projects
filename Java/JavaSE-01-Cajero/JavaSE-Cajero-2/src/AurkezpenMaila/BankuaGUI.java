package AurkezpenMaila;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.awt.Dimension;

class BankuaGUI extends JFrame
{       
        private Mezuak mezuakBistaratu;
	private Container contentPane;
	private NirePanela nirePanela;

        private JComboBox hiria,zinema;
        private JButton ordaindu;
        private JLabel zarrera,taula,hiriText,zineText,ordainduText;
        private TextArea testuArea;

        
 public BankuaGUI(String izenburua)
{       
        setTitle(izenburua);
	setSize(425, 350);
        
	addWindowListener(new WindowAdapter()
	{
		public void windowClosing(WindowEvent anEvent)
		{
			// Irteeratik kontu nagusi guztia ikuskapenerako
			
			System.exit(0);
		}
	});
        contentPane = getContentPane();
	contentPane.setLayout(null);
	contentPane.setBackground(Color.lightGray);	
        mezuakBistaratu=new Mezuak();
        contentPane.add(mezuakBistaratu);  
        this.setResizable(false);
        this.setBounds(0, 0, 600, 700);
        contentPane.setVisible(true); 
        setLocationRelativeTo(null);     
}
public static void main(String[] args)
{
	new BankuaGUI("KUTXAZAIN AUTOMATIKO <<<< BERRIA >>>>").show();
}

  public BankuaGUI()
  {
    try
    {
      jbInit();
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }

  }

  private void jbInit() throws Exception
  {
    this.setSize(new Dimension(454, 300));
  }
}
