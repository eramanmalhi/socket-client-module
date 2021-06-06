import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class MessageClient {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		try {
			System.out.println("STARTING CLIENT...");
			Socket socket=new Socket("localhost", 1989);
			DataInputStream din=new DataInputStream(socket.getInputStream());  
			DataOutputStream dos=new DataOutputStream(socket.getOutputStream());  
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); 
			
		String s1="",s2="";
		while(!s1.equals("stop")){  
			s1=br.readLine();  
			dos.writeUTF(s1);  
			dos.flush();  
			s2=din.readUTF();  
			System.out.println("Server Message: "+s2);  
			}
		dos.close();  
		socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
