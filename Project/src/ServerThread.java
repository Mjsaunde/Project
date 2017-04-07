import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ServerThread extends Thread{
	private BufferedReader socketInput;
	private PrintWriter socketOutput;
	private ServerSocket serverSocket;
	private Socket aSocket;
	ObjectInputStream objectIn;
	ObjectOutputStream objectOut;

	/**
	 * Construct a Server with Port 9090
	 */
	public ServerThread(Socket socket){
		try {
			
			this.aSocket = socket;
			objectIn = new ObjectInputStream(aSocket.getInputStream());
			objectOut = new ObjectOutputStream(aSocket.getOutputStream());
			//socketInput = new BufferedReader(new InputStreamReader(aSocket.getInputStream()));
			//socketOutput = new PrintWriter(aSocket.getOutputStream(), true);
			}
		 catch (IOException e) {
		}
	}

	/**
	 * Get input from Client.
	 */
	public void run() {
		Message recieved = new Message();
		try {
			recieved = (Message) objectIn.readObject();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		recieved.setString("bye");
		try {
			objectOut.writeObject(recieved);
		} catch (IOException e) {
			e.printStackTrace();
		}
		/*
		StringBuffer line = null;
		while (true) {
			try {
				line = new StringBuffer(socketInput.readLine());
				//Message message = ((Message)objectIn.readObject());
				//System.out.println(message.getString());
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (line != null) {
				if (line.toString().equals("QUIT")) {
					break;
				}
				if (line.toString().equals("DATE")) {
					Calendar cal = Calendar.getInstance();
					SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
					socketOutput.println( sdf.format(cal.getTime()));
				} else if (line.toString().equals("TIME")) {
					Calendar cal = Calendar.getInstance();
					SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
					socketOutput.println( sdf.format(cal.getTime()));
				}else {
					socketOutput.println("Wrong input, please try again");
				}
			}
		}
		try {
			socketInput.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		socketOutput.close();
		try {
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
	}


}