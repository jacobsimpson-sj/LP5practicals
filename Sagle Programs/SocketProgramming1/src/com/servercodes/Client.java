package com.servercodes;

import java.io.*;
import java.net.*;

public class Client {
	public static void main(String[] args) {
		try {
// Step 1: Create a Socket object and connect to the server (localhost, port 5000)
			Socket socket = new Socket("localhost", 5000);
			System.out.println("Connected to server!");
// Step 2: Create input and output streams for communication
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
// Step 3: Send a message to the server
			out.println("Hello from Client!");
// Step 4: Read the server's response
			String response = in.readLine();
			System.out.println("Server says: " + response);
// Step 5: Close the connection
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}