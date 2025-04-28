package com.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class AddClient {
	public static void main(String[] args) {
		try {
			Registry registry = LocateRegistry.getRegistry("localhost", 1099);
			AddServerIntf server = (AddServerIntf) registry.lookup("AddServer");
			double result = server.add(5.5, 10.5);
			System.out.println("Result: " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}