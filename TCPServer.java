import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;



public class TCPServer {
	public final static int PORT = 9999;
	public final static String ADDRESS = "127.0.0.1";
	

	public static void main(String[] args) throws IOException{
		ServerSocket socket = null;
		try {
			socket = new ServerSocket(PORT);
			Socket client = null;
			System.out.println("Server open!");
			while (true) {
				client = socket.accept();
				System.out.println(client+" connect success");
				//asdasd
//				ServerThread thread = new ServerThread(client);
//				thread.start();
				new Thread(new ServerThread(client)).start();
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}finally {
			if(socket != null)
				socket.close();
		}

	}

}
