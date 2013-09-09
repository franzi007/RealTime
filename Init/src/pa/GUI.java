package pa;    

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import lejos.pc.comm.NXTConnector;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

//PC Initiator
public class GUI extends JFrame implements ActionListener{
	
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JLabel label;
    JPanel panel;
    public static DataOutputStream outData;
    public static NXTConnector link;
    public static int n = 1;
    
    JScrollBar scrollbar;
    

	
    public GUI() {
        JFrame meinJFrame = new JFrame();
        meinJFrame.setTitle("JScrollBar Beispiel");
        
        this.setTitle("ActionListener Beispiel");
        this.setSize(400, 200);
        
        panel = new JPanel();
 
        // Leeres JLabel-Objekt wird erzeugt
        label = new JLabel();


        
        //Drei Buttons werden erstellt
        button1 = new JButton("Connect");
        button2 = new JButton ("Insulin");
        button3 = new JButton ("Dosconnect");
        button4 = new JButton ("Exit");
 
        //Buttons werden dem Listener zugeordnet
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        // XXXXXTextfeld bei den Listenern registrieren
       // meinTextFeld.addActionListener(this);
 
        //Buttons werden dem JPanel hinzugefügt
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        //getContentPane().add(meinTextFeld);
 
        //JScrollBar wird erzeugt
        scrollbar = new JScrollBar
                (JScrollBar.VERTICAL, 30, 10, 0, 100);
        //...und dem JPanel hinzugefügt
        panel.add(scrollbar);
        
        //JLabel wird dem Panel hinzugefügt
        panel.add(label);
        meinJFrame.add(panel);
        meinJFrame.setVisible(true);
        
        this.add(panel);	
    }
    
/*	public static void main(String[] args) {
		GUI bl = new GUI();
		bl.setVisible(true);	
	}*/

    public void actionPerformed (ActionEvent ae){
        // Die Quelle wird mit getSource() abgefragt und mit den
        // Buttons abgeglichen. Wenn die Quelle des ActionEvents einer
        // der Buttons ist, wird der Text des JLabels entsprechend geändert
        if(ae.getSource() == this.button1){connect();}
      
        if(ae.getSource() == this.button2){ sendInt(); }
        if (ae.getSource() == this.button3){disconnect();}
        if (ae.getSource() == this.button4){label.setText("" + scrollbar.getValue());}
    }
    
	//Connect to NXT brick
	public static void connect()
    {
       link = new NXTConnector();
     
       if (!link.connectTo("usb://"))
       {
          System.out.println("\nNo NXT find using USB");
          }
      
       //outData = link.getDataOut();
       System.out.println("\nNXT is Connected");   
     }//End connect
   
	public static void sendInt() {
		try {
			OutputStream os = link.getOutputStream();
			outData = new DataOutputStream(os);
    	  
			outData.writeInt(1);
			outData.flush();
        }
		catch (Exception e) {
			System.out.println("error");
		}
	}//End sendInt
	
    public static void disconnect()
    {
       try{
          //outData.close();
          link.close();
          }
       catch (IOException ioe) {
          System.out.println("\nIO Exception writing bytes");
       }
       System.out.println("\nClosed data streams");
      
    }//End disconnect


}//End PC11
