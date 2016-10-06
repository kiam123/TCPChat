import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ServerThread extends Thread {
	private Socket client = null;

	public ServerThread(Socket client) {
		this.client = client;
	}

	 @Override
	public void run() {
		 super.run();
		boolean flag = true;
		try {
			PrintStream getClientInput = new PrintStream(client.getOutputStream());
			BufferedReader buffReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			while (flag) {
				String receiveMsg = buffReader.readLine();
				System.out.println("receive the Messeger "  + receiveMsg);
			}
			getClientInput.close();
			client.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		System.out.println("EXIT");
	}

}
