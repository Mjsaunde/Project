import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread {
Socket socket;
	public ServerThread(Socket aSocket){
			this.socket = aSocket;
	}
	
	
	public void start() throws IOException, ClassNotFoundException{
		ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
		ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
		Message message = (Message)in.readObject();
		message.result();
		out.writeObject(message);
		socket.close();
	}

}
