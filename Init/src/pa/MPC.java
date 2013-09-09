package pa;


public class MPC {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	PCIn conn = new PCIn();
	conn.connect();
	Patient patient = new Patient();
	Battery battery = new Battery();
	
	Timer timer = new Timer();	
	timer.addObserver(patient);
	timer.addObserver(battery);
	
	Thread thr = new Thread(timer);
	thr.start();
	
	System.out.println("ENDE");
	
	
	}

}
