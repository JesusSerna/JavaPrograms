

import java.net.Socket;
import java.net.ServerSocket;

public class Server {
	public static void main(String argv[]) throws Exception {		
		//Set the port number
		int portNumber = 8080;
		
		//Open the server socket
		ServerSocket serverSocket = new ServerSocket(portNumber);
		
		try {
			//Process HTTP requests indefinitely
			while (true) {
				//Connect to client
				Socket clientSocket = serverSocket.accept();
				//Generate new request using client connection
				RequestHandler request = new RequestHandler(clientSocket);
				//Spawn new thread to handle the request. This allows server to execute many requests in parallel
				Thread thread = new Thread(request);
				//start thread
				thread.start();
			}
		} catch (Exception e) { //Print any error messages
			System.out.println(e);
		} finally { //Close the server socket when the server is done listening
			serverSocket.close();
		}
	}
}
