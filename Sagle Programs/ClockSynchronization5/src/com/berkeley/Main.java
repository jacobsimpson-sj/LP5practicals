package com.berkeley;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create nodes with initial clock values
		 Node node1 = new Node(1, 10);
		 Node node2 = new Node(2, 15);
		 Node node3 = new Node(3, 20);
		 // Create the master node
		 MasterNode masterNode = new MasterNode();
		 masterNode.addNode(node1);
		 masterNode.addNode(node2);
		 masterNode.addNode(node3);
		 // Synchronize clocks
		 System.out.println("Before synchronization:");
		 System.out.println("Node 1: " + node1.getClock());
		 System.out.println("Node 2: " + node2.getClock());
		 System.out.println("Node 3: " + node3.getClock());
		 masterNode.synchronizeClocks();
		 System.out.println("After synchronization:");
		 System.out.println("Node 1: " + node1.getClock());
		 System.out.println("Node 2: " + node2.getClock());
		 System.out.println("Node 3: " + node3.getClock());
		 }


	}


