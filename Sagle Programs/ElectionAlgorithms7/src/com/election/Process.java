package com.election;

import java.util.ArrayList;
import java.util.List;

public class Process {
	private int id;
	private boolean isCoordinator;
	private List<Process> processes;

	public Process(int id) {
		this.id = id;
		this.isCoordinator = false;
		this.processes = new ArrayList<>();
	}

	public void addProcess(Process process) {
		processes.add(process);
	}

	public void startElection() {
		System.out.println("Process " + id + " started an election.");
		for (Process process : processes) {
			if (process.id > this.id) {
				System.out.println("Process " + id + " sent election message to Process " + process.id);
				if (process.receiveElection(this.id)) {
					return; // Higher process responded, stop election
				}
			}
		}
		declareVictory();
	}

	public boolean receiveElection(int senderId) {
		if (this.id > senderId) {
			System.out.println("Process " + id + " responded to Process " + senderId);
			startElection();
			return true;
		}
		return false;
	}

	public void declareVictory() {
		this.isCoordinator = true;
		System.out.println("Process " + id + " is the new coordinator.");
		for (Process process : processes) {
			process.receiveCoordinator(this.id);
		}
	}

	public void receiveCoordinator(int coordinatorId) {
		this.isCoordinator = false;
		System.out.println("Process " + id + " acknowledged Process " + coordinatorId + " as coordinator.");
	}
}