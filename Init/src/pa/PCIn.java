package pa;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import lejos.pc.comm.NXTConnector;

public class PCIn {
	
    public static DataOutputStream outData;
    public static NXTConnector link;
    //public static int BG;
   // public static int n = 1;

    PCIn() {
    	
    }
    
  //Connect to NXT brick
  	public static void connect()
      {
         link = new NXTConnector();
       
         //Connection to any NXT Device
         if (!link.connectTo("usb://"))
         {
            System.out.println("\nNo NXT find using USB");
            }
         System.out.println("\nNXT is Connected");   
       }//End connect
     
  	public static void sendInt(int BG) {
  		try {
  			OutputStream os = link.getOutputStream();
  			outData = new DataOutputStream(os);
      	  
  			outData.writeInt(BG);
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
    
}
