import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread {
Socket socket;
FlightCatalog flightcatalog;
	public ServerThread(Socket aSocket, FlightCatalog flightcatalog){
			this.socket = aSocket;
			this.flightcatalog = flightcatalog;
	}
	
	
	public void start() throws IOException, ClassNotFoundException{
		ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
		ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
		out.writeObject(flightcatalog);
		flightcatalog = (FlightCatalog)in.readObject();
		socket.close();
	}

}
