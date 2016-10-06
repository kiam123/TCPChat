import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCPClient {

	public static void main(String[] args) {
		boolean clientOpen = true;
//		Scanner scan = new Scanner(System.in);
		String buffer="";
		
		try{
			Socket client = new Socket(TCPServer.ADDRESS, TCPServer.PORT);
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			PrintStream writer = new PrintStream(client.getOutputStream());
			
			while(clientOpen){
				try {
					System.out.print("send to Server: ");
					buffer = input.readLine();
					System.out.println(buffer);
					writer.println(buffer);
				} catch (Exception e) {
					System.out.println(e.toString());
				}
			}
			client.close();
		}catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
