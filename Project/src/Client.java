import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	Socket socket;
	public Client() throws UnknownHostException, IOException{
		Socket socket = new Socket("localhost", 4444);
	}
	public static void main(String [] args) throws UnknownHostException, IOException, ClassNotFoundException{
		Client client = new Client();
		ObjectOutputStream out = new ObjectOutputStream(client.socket.getOutputStream());
		ObjectInputStream in = new ObjectInputStream(client.socket.getInputStream());
		FlightCatalog flightCatalog = (FlightCatalog)in.readObject();
		PassengerGUI passgui = new PassengerGUI(flightCatalog);
		////////////////////////// RUN METHOD
		client.socket.close();
		}
	public FlightCatalog recieve() throws IOException, ClassNotFoundException{
		ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
		FlightCatalog flightCatalog = (FlightCatalog)in.readObject();
		return flightCatalog;
	}
	public void send(FlightCatalog flightCatalog) throws IOException{
		ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
		out.writeObject(flightCatalog);
	}
}
