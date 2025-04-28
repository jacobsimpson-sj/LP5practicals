package com.servercodes;

import java.io.*;
import java.net.*;

public class Server {
	public static void main(String[] args) {
		try {
// Step 1: Create a ServerSocket object and bind it to a port (e.g., 5000)
			ServerSocket serverSocket = new ServerSocket(5000);
			System.out.println("Server is waiting for client connection...");
// Step 2: Wait for a client to connect
			Socket socket = serverSocket.accept();
			System.out.println("Client connected!");
// Step 3: Create input and output streams for communication
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
//Step 4: Read data from the client
			String message = in.readLine();
			System.out.println("Client says: " + message);
// Step 5: Send a response back to the client
			out.println("Hello from Server!");
// Step 6: Close the connection
			socket.close();
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}