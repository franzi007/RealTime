
package pa;

import java.util.Observable;

//controller
public class Timer extends Observable implements Runnable {

		public void run() 
		{
			
			for(int i = 0; i < 10; i++) {
				try {
					Thread.sleep(1000);
					setChanged();
					notifyObservers();
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}		
}
}
