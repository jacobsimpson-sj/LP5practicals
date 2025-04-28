package com.berkeley;

public class Node {
	private int id;
	 private int clock;
	 public Node(int id, int clock) {
	 this.id = id;
	 this.clock = clock;
	 }
	 public int getId() {
	 return id;
	 }
	 public int getClock() {
		 return clock;
		 }
		 public void setClock(int clock) {
		 this.clock = clock;
		 }
		 public void adjustClock(int adjustment) {
		 this.clock += adjustment;
		 }

}
