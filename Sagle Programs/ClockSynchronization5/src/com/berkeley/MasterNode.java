package com.berkeley;
import java.util.ArrayList;
import java.util.List;

public class MasterNode {
	private List<Node> nodes;
	 public MasterNode() {
	 nodes = new ArrayList<>();
	 }
	 public void addNode(Node node) {
	 nodes.add(node);
	 }
	 public void synchronizeClocks() {
		 // Step 1: Collect clock values from all nodes
		 int sum = 0;
		 for (Node node : nodes) {
		 sum += node.getClock();
		 }
		 // Step 2: Calculate the average clock value
		 int average = sum / nodes.size();
		 // Step 3: Send the adjustment to each node
		 for (Node node : nodes) {
		 int adjustment = average - node.getClock();
		 node.adjustClock(adjustment);
		 System.out.println("Node " + node.getId() + " adjusted by " + adjustment);
		 }
	 }


}
