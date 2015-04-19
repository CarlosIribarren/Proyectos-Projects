package LogikaMaila;
// Class izena: 	LogikaMaila.GureJcalendar.java
// Function:	Jcalendar egitura klasea
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import org.freixas.jcalendar.DateEvent;
import org.freixas.jcalendar.DateListener;
import org.freixas.jcalendar.JCalendar;

/**
 * This example shows various instances of the JCalendar class.
 * <hr>
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the Artistic License. You should have
 * received a copy of the Artistic License along with this program. If
 * not, a copy is available at
 * <a href="http://opensource.org/licenses/artistic-license.php">
 * opensource.org</a>.
 *
 * @author Antonio Freixas
 */

// Copyright � 2004 Antonio Freixas
// All Rights Reserved.

public class GureJcalendar
  extends JPanel
  
{
String emanData;
 String data_Time_katea; 
//**********************************************************************
// main
//**********************************************************************


//**********************************************************************
// Constructors
//**********************************************************************

/**
 * Create various instances of a JCalendar.
 */

public
GureJcalendar()
{
    // Set up the frame
this.setFont(new Font("Arial", Font.PLAIN, 12));
	this.setBackground(Color.LIGHT_GRAY);
	
	this.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
   

    // contentPane.setLayout(new GridLayout(2, 2, 5, 5));

    // Create a border for all calendars

    Border etchedBorder =
	BorderFactory.createEtchedBorder();
    Border emptyBorder =
	BorderFactory.createEmptyBorder(10, 10, 10, 10);
    Border compoundBorder =
	BorderFactory.createCompoundBorder(etchedBorder, emptyBorder);

    // Create a date listener to be used for all calendars

    MyDateListener listener = new MyDateListener();

    // Display date and time using the default calendar and locale.
    // Display today's date at the bottom.
    // | JCalendar.DISPLAY_TIME

    JCalendar calendar1 =
	new JCalendar(
          Calendar.getInstance(Locale.ENGLISH),
	    Locale.ENGLISH,
	    JCalendar.DISPLAY_DATE,
	    true);
    calendar1.addDateListener(listener);
    calendar1.setBorder(compoundBorder);

    // Set fonts rather than using defaults

    calendar1.setTitleFont(new Font("Serif", Font.BOLD|Font.ITALIC, 24));
    calendar1.setDayOfWeekFont(new Font("SansSerif", Font.BOLD|Font.ITALIC, 16));
    calendar1.setDayFont(new Font("SansSerif", Font.BOLD, 16));
    calendar1.setTimeFont(new Font("DialogInput", Font.PLAIN, 10));
    calendar1.setTodayFont(new Font("Dialog", Font.PLAIN, 14));

    // Display date only

    JCalendar calendar2 = new JCalendar(JCalendar.DISPLAY_DATE, false);
    calendar2.addDateListener(listener);
    calendar2.setBorder(compoundBorder);

    // Display time only and set the time pattern to use as a duration
    // from 00:00 to 23:59

    JCalendar calendar3 =
	new JCalendar(
	    Calendar.getInstance(),
	    Locale.getDefault(),
	    JCalendar.DISPLAY_TIME,
	    false,
	    "HH:mm");
    calendar3.addDateListener(listener);
    calendar3.setBorder(compoundBorder);

    // Display a French calendar

    JCalendar calendar4 =
	new JCalendar(
	    Calendar.getInstance(Locale.FRENCH),
	    Locale.FRENCH,
	    JCalendar.DISPLAY_DATE | JCalendar.DISPLAY_TIME,
	    false);
    calendar4.addDateListener(listener);
    calendar4.setBorder(compoundBorder);

    // Add all the calendars to the content pane

    JPanel panel1 = new JPanel(new FlowLayout());
    panel1.add(calendar1);
    this.add(panel1);

    JPanel panel2 = new JPanel(new FlowLayout());
    //panel2.add(calendar2);
    //contentPane.add(panel2);

    
    // Make the window visible

  
    setVisible(true);
}

//**********************************************************************
// Inner Classes
//**********************************************************************

private class MyDateListener   implements DateListener
{
       

        
        
public void dateChanged( DateEvent e)
{
    int urtea, hilea, eguna; 
    Calendar c = e.getSelectedDate();
    
  
    // Aukera 1:
    Date d = c.getTime();  
     
    //------------- DATA ETA ORDUA ESKURATU -------------------------
    SimpleDateFormat formatua;
    formatua = new SimpleDateFormat("yyyy-MM-dd"); 
    data_Time_katea = formatua.format(d);
    if (Kutxazaina.instantzia().getUneko_zinema()!=null)
    {
        Kutxazaina.instantzia().getZinema_nagusia().egunaEguneratu(data_Time_katea);
    }

    
    
    if (c != null) {
    }
    
    else {
	System.out.println("No time selected.");
    }
}

}
    public String getData_Time_katea() {
        return data_Time_katea;
    }

    public void setData_Time_katea(String data_Time_katea) {
        this.data_Time_katea = data_Time_katea;
    }

public String eguna()
{
	return data_Time_katea;
} 

}
