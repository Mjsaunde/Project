import java.io.Serializable;

public class Message implements Serializable{

	private static final long serialVersionUID = -2723363051271966964L;
	int first;
	int second;
	int result = 0;
	public Message(int first, int second){
		this.first = first;
		this.second= second;
	}
	public int getFist(){
		return this.first;
	}
	public int getSecond(){
		return this.second;
	}
	public void result(){
		result = this.first + this.second;
	}
	public int getResult(){
		return result;
	}
}
