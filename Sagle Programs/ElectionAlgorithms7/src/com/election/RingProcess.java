package com.election;

public class RingProcess extends Thread {
	private int id;
	private RingProcess nextProcess;
	private boolean isCoordinator;
	private int[] electionMessage;

	public RingProcess(int id) {
		this.id = id;
		this.isCoordinator = false;
		this.electionMessage = new int[0];
	}

	public void setNextProcess(RingProcess nextProcess) {
		this.nextProcess = nextProcess;
	}

	public void startElection() {
		System.out.println("Process " + id + " started an election.");
		electionMessage = new int[] { id };
		nextProcess.receiveElection(electionMessage);
	}

	public void receiveElection(int[] message) {
		if (message.length == 0) {
			declareVictory();
			return;
		}
		int maxId = message[0];
		for (int id : message) {
			if (id > maxId)
				maxId = id;
		}
		if (maxId == this.id) {
			declareVictory();
		} else {
			int[] newMessage = new int[message.length + 1];
			System.arraycopy(message, 0, newMessage, 0, message.length);
			newMessage[message.length] = this.id;
			nextProcess.receiveElection(newMessage);
		}
	}

	public void declareVictory() {
		this.isCoordinator = true;
		System.out.println("Process " + id + " is the new coordinator.");
		nextProcess.receiveCoordinator(this.id);
	}

	public void receiveCoordinator(int coordinatorId) {
		this.isCoordinator = false;
		System.out.println("Process " + id + " acknowledged Process " + coordinatorId + " as coordinator.");
		if (coordinatorId != this.id) {
			nextProcess.receiveCoordinator(coordinatorId);
		}
	}
}