import java.io.Serializable;

public class Message implements Serializable {
	private static final long serialVersionUID = 1L;
	private String aa;
	
	public Message(){}
	
	public Message(String a){
		this.aa = a;
	}
	
	public void setString(String a){
		this.aa = a;
	}
	
	public String getString(){
		return this.aa;
	}
}
