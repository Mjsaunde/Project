import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
 public int port = 4444;
 
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Server server = new Server();
		server.runServer();
	}
	
	public void runServer() throws IOException, ClassNotFoundException{
		ServerSocket serverSocket = new ServerSocket(this.port);
		System.out.println("Server is running...");
		while(true){
		Socket socket = serverSocket.accept();
		FlightCatalog flightcatalog = new FlightCatalog();
		new ServerThread(socket, flightcatalog).start();
		}
	}

}
