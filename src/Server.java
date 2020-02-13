import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		
		try {
			System.out.println("Waiting for a connection: ");
			ServerSocket serverSoc = new ServerSocket (4506);
			Socket soc = serverSoc.accept();					//.accept used to wait for a connection to be established
			System.out.println("Connection established.");
			
			DataInputStream DIS = new DataInputStream(soc.getInputStream());
			DataOutputStream DOS = new DataOutputStream(soc.getOutputStream());
			
			BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
			String messageIn ="", messageOut = "";
			
			while (!messageIn.equals("end")) {
				messageIn = DIS.readUTF();
				System.out.println(messageIn);
				messageOut = br.readLine();
				DOS.writeUTF(messageOut);
				DOS.close();
			}
			soc.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
