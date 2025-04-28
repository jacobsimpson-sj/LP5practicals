package com.election;

public class Main {
	 public static void main(String[] args) {
	 // Create processes
	 RingProcess process1 = new RingProcess(1);
	 RingProcess process2 = new RingProcess(2);
	 RingProcess process3 = new RingProcess(3);
	 // Set up the ring
	 process1.setNextProcess(process2);
	 process2.setNextProcess(process3);
	 process3.setNextProcess(process1);
	 // Start the election from Process 1
	 process1.startElection();
	 }
	 }
