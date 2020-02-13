import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) {
		
		try {
			System.out.println("Client Started");
			Socket clientSoc = new Socket("127.0.0.1",4506);
			
			DataInputStream DIS = new DataInputStream(clientSoc.getInputStream());
			DataOutputStream DOS = new DataOutputStream(clientSoc.getOutputStream());
			
			BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
			String messageIn ="", messageOut = "";
			
			while (!messageIn.equals("end chat")) {
				messageOut = br.readLine();	
				DOS.writeUTF(messageOut);
				messageIn = DIS.readUTF();
				System.out.println(messageIn);
			}
			clientSoc.close();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
