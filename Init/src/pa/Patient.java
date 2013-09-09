package pa;

import java.util.Observer;
import java.util.Observable;
//Model 
public class Patient  implements Observer {

	private static int BG;
	
	Patient() {
		BG = 10;
	}
	
	public int getBG() {
		
		return BG;
	}

	@Override public void update(Observable o, Object arg ) {	
		BG=BG+4;
		System.out.println("My Bloodglucose value is " + BG);
		//send BG to NXT
		PCIn.sendInt(BG);
		
	}
	
	
}