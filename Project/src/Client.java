//Parent code supplied from exercise 1 Lab 6
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 
 * @author Mark
 *
 */
public class Client {


	private PrintWriter socketOut;
	private Socket palinSocket;
	private BufferedReader stdIn;
	private BufferedReader socketIn;
	ObjectInputStream objectIn;
	ObjectOutputStream objectOut;

	public Client(String serverName, int portNumber) {
		try {
			palinSocket = new Socket(serverName, portNumber);
			stdIn = new BufferedReader(new InputStreamReader(System.in));
			//socketIn = new BufferedReader(new InputStreamReader(palinSocket.getInputStream()));
			objectIn = new ObjectInputStream(palinSocket.getInputStream());
			objectOut = new ObjectOutputStream(palinSocket.getOutputStream());
			//socketOut = new PrintWriter((palinSocket.getOutputStream()), true);
		} catch (IOException e) {
			System.err.println(e.getStackTrace());
		}
	}

	public void communicate() throws ClassNotFoundException, IOException  {
		Message message = new Message("hi");
		System.out.println(message.getString());
		while(true){
			//message.setString(line);
		objectOut.writeObject(message);
		Message returnM = (Message)objectIn.readObject();
		System.out.println(returnM.getString());
		
		}
		/*
       // Message message= new Message("hi");
		String line = "";
		String response = "";
		boolean running = true;
		while (running) {
			try {
				System.out.println("Please select an option (Date/Time)");
				line = stdIn.readLine();
				if (!line.equals("QUIT")){
					System.out.println(line);
					socketOut.println(line);
					//objectOut.writeObject(message);
					response = socketIn.readLine();
					System.out.println(response);	
				}else{
					running = false;
				}
				
			} catch (IOException e) {
				System.out.println("Sending error: " + e.getMessage());
			}
		}
		try {
			stdIn.close();
			socketIn.close();
			socketOut.close();
		} catch (IOException e) {
			System.out.println("closing error: " + e.getMessage());
		}
*/
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException  {
		Client aClient = new Client("localhost", 9090);
		aClient.communicate();
	}
}
