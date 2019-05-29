//	Jesus Serna
//	1000975501
//	CSE 4344-001
//	Project 2

import java.util.Collections;
import java.util.TreeMap;
import java.util.TreeSet;

public class Node {
	public static final int INFINITY = 16;

	public int ID;
	public TreeMap<Integer, TreeMap<Integer, Integer>> VectorTable; //distance vector table
	public TreeMap<Integer, Integer> routingTable;
	public boolean UnSent_;
	public boolean NewMessage;

	//Constructor
	public Node(int ID, TreeSet<Integer> ids) {
		this.ID = ID;

		VectorTable = new TreeMap<Integer, TreeMap<Integer, Integer>>();
		routingTable = new TreeMap<Integer, Integer>();
		//add this nodes row into VectorTable
		VectorTable.put(ID, new TreeMap<Integer, Integer>());
		//add all the "to" columns for this row
		for (int id : ids) {
			if (id == this.ID) {
				VectorTable.get(this.ID).put(id, 0);
				routingTable.put(this.ID, this.ID);
			} else {
				VectorTable.get(this.ID).put(id, INFINITY);
				routingTable.put(id, INFINITY);
			}
		}

		UnSent_ = true;
		NewMessage = false;
	}

	//Runs the Bellman-Ford algorithm on the routing table
	public void MakeTable() {
		for (int destinationID : VectorTable.get(this.ID).keySet()) {
			TreeMap<Integer, Integer> neighborDistances = new TreeMap<Integer, Integer>();
			for (int neighborID : VectorTable.keySet()) {
				int thisToNeighbor = VectorTable.get(this.ID).get(neighborID);
				int neighborToDestination = VectorTable.get(neighborID).get(destinationID);
				neighborDistances.put(thisToNeighbor + neighborToDestination, neighborID);
			}

			int leastCost = Collections.min(neighborDistances.keySet());
			int oldLeastCost = VectorTable.get(this.ID).get(destinationID);
			if (leastCost < oldLeastCost) {
				UnSent_ = true;
				VectorTable.get(this.ID).put(destinationID, leastCost);
			}
		}

		NewMessage = false; //node has handled new message
	}

	//Replace row in routing table with received row from neighbor
//	@SuppressWarnings("unchecked")
	public void receiveMessage(int senderID, TreeMap<Integer, Integer> tableEntry) {
		NewMessage = true;

		VectorTable.put(senderID, (TreeMap<Integer, Integer>) tableEntry.clone()); //override the entire row of the sender node
	}

	//Override link between two specified nodes with given cost
	public void setLink(int neighborID, int cost) {
		VectorTable.get(this.ID).put(neighborID, cost);
		//VectorTable.get(neighborID).put(this.ID, cost);
		UnSent_ = true;
	}

	//Convert routing table into string representation
	public String toString() {
		String result = "";
		//header
		result += "Node: " + this.ID + ":\n\n";
		//destination IDs line
		result += " ";
		for (int destinationID : VectorTable.get(this.ID).keySet()) {
			result += String.format("%3d", destinationID);
		}
		result += "\n";

		//Print each row
		for (int originID : VectorTable.keySet()) {
			result += originID + "|";
			for (int destinationID : VectorTable.get(originID).keySet()) {
				result += String.format("%2d|", VectorTable.get(originID).get(destinationID));
			}
			result += "\n";
		}

		return result;
	}

	//Add neighbor as a row into this node's routing table and initialize values
	public void addNeighbor(int neighborID, int distance, TreeSet<Integer> ids) {
		//add new row for neighbor in the VectorTable
		VectorTable.put(neighborID, new TreeMap<Integer, Integer>());
		//add all the "to" columns for the neighbor row
		for (int id : ids) {
			if (id == neighborID) {
				VectorTable.get(neighborID).put(id, 0);
			} else {
				VectorTable.get(neighborID).put(id, INFINITY);
			}
		}

		//set distance to the neighbor for this node's entry in the VectorTable
		VectorTable.get(this.ID).put(neighborID, distance);
		//set distance to this node from neighbor in neighbors entry in table
		//VectorTable.get(neighborID).put(this.ID, distance);
	}
}
