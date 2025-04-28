package com.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class AddServer {
	public static void main(String[] args) {
		try {
			AddServerImpl server = new AddServerImpl();
			Registry registry = LocateRegistry.createRegistry(1099);
			registry.rebind("AddServer", server);
			System.out.println("Server is ready.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
