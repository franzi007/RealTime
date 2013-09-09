package pa;

import java.util.Observer;
import java.util.Observable;
//Model 
public class Battery  implements Observer {

	private static int Volt;
	
	Battery() {
		Volt = 100;
	}
	
	public int getVolt() {
		
		return Volt;
	}

	@Override public void update(Observable o, Object arg ) {	
		Volt=Volt-4;
		System.out.println("Volt value is " + Volt);
		//send BG to NXT
		PCIn.sendInt(Volt);
		
	}
}