

import java.io.*;
import java.net.Socket;
public class RequestHandler implements Runnable {
	Socket socket; //This is the client socket from which we will pull and push data

	//Constructor
	public RequestHandler(Socket socket) throws Exception {
		this.socket = socket;
	}

	//Implements the run() method of the Runnable interface, which allows this class to be used in a m1ultithreaded approach.
	//It tries to run processRequest() and reports any errors.
	public void run() {
		try {
			process();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	//Parses HTTP request from the socket and handles it. Is able to handle responses for 200, 301, and 404 status codes.
	private void process() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); //to read data from socket
		DataOutputStream out = new DataOutputStream(socket.getOutputStream()); //to write data to socket

		//Get request line of the HTTP request message
		String request = in.readLine();
		//Prints every GET request
		System.out.print(request+"\n");
		//Extract the filename from the request line
		String filename = "." + request.split(" ")[1]; //add . in front of filename so that file request is within current directory
		FileInputStream InputStream = null; //to check if file exists and if so, used to push requested file data to client socket
		//Logic checking for 301 response. If a html file is requested other than index.html that contains "index", forward traffic to index.html
		if (!filename.equals("./index.html") && filename.contains("index") && filename.endsWith(".html")) {
			out.writeBytes("HTTP/1.1 301 Moved Permanently" + "\r\n"); //write 301 status code
			//Prints what server code has replied
			System.out.print("HTTP/1.1 301 Moved Permanently"+"\n");
			//this sets the file that would be displayed and that the header lines will report info about
			filename = "./301.html";
			InputStream = new FileInputStream(filename);
		} else {
			//Open requested file
			boolean fileExists = true; //assume file exists
			try {
				InputStream = new FileInputStream(filename);
			} catch (Exception e) {
				fileExists = false; //if there is error, that means file doesn't exist
			}
			//Send status
			if (fileExists) {
				out.writeBytes("HTTP/1.1 200 OK" + "\r\n");
				//Prints what server code has replied
				System.out.print("HTTP/1.1 200 OK"+"\n");
			} else {
				out.writeBytes("HTTP/1.1 404 Not Found" + "\r\n");
				//Prints what server code has replied
				System.out.print("HTTP/1.1 404 Not Found"+"\n");
				//this sets the file that will be displayed and that the header lines will report info about
				filename = "./404.html";
				InputStream = new FileInputStream(filename);
			}
		}
		//Send header line
		out.writeBytes("Connection: close" + "\r\n");
		//Send blank line to indicate end of header lines
		out.writeBytes("\r\n");
		//Send data
		sendBytes(InputStream, out);
		//Close streams and client socket
		InputStream.close();
		in.close();
		socket.close();
	}


	//Parameters: fis - input stream for reading desired file
	//Parameters: out - output stream for sending desired chunks to client
	private void sendBytes(FileInputStream fis, OutputStream out) throws Exception {
		//Construct a 1KB buffer to hold bytes on way to socket
		byte[] buffer = new byte[1024];
		int bytes = 0; //used for detecting when no more bytes have been read from file

		//Copy requested file into socket's output stream
		while ((bytes = fis.read(buffer)) != -1) { //continuously read chunks of file and send it to client
			out.write(buffer, 0, bytes);
		}
	}
}
