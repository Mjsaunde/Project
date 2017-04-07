import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String [] args) throws UnknownHostException, IOException, ClassNotFoundException{
		int firstNumber = 1;
		int secondNumber = 2;
		Socket socket = new Socket("localhost", 4444);
		ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
		ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
		Message message = new Message(firstNumber, secondNumber);
		out.writeObject(message);
		Message returnMessage = (Message)in.readObject();
		System.out.println(returnMessage.getResult() );
		socket.close();
		}
}
