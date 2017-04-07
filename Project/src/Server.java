import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Server{

	private int port;


	/**
	 * Run the Server.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Server ds = new Server();
		ds.runServer();
	}
	
	public void runServer()throws IOException{
		ServerSocket serverSocket = new ServerSocket(9090);
		System.out.println("Flight Server is running.");
		while(true){
			Socket socket = serverSocket.accept();
			new ServerThread(socket).start();
		}
	}
	}