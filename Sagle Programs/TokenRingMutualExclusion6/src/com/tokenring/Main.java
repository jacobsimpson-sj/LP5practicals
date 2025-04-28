package com.tokenring;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create processes
		 Process process1 = new Process(1);
		 Process process2 = new Process(2);
		 Process process3 = new Process(3);
		 // Set up the ring
		 process1.setNextProcess(process2);
		 process2.setNextProcess(process3);
		 process3.setNextProcess(process1);
		 // Start with the token at Process 1
		 process1.setToken(true);
		// Start the processes
		 process1.start();
		 process2.start();
		 process3.start();
		 }

	}


