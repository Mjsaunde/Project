import javax.swing.JFrame;

/**
 * This class is for testing purposes only. to be replaced by ClientSocket
 * @author Brendon
 *
 */
public class TempClientSocket {
	FlightCatalog flightCat;
	
	TempClientSocket()
	{
		flightCat = new FlightCatalog();
		JFrame f = new AdminGUI(flightCat);
		f.setVisible(true);
	}
	
	
	
	public static void main(String[] args)
	{
		TempClientSocket t = new TempClientSocket();
		
	}
	
}
