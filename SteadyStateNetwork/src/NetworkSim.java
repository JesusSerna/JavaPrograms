//	Jesus Serna
//	1000975501
//	CSE 4344-001
//	Project 2

import java.util.Scanner;

public class NetworkSim {
	public static final int INFINITY = 16;
	public static void main(String[] args) {
		int itterations = 0;
		boolean show_itterations = false;
		
		try {
			String input = "";
			String answer = "";
			Scanner reader = new Scanner(System.in);
			System.out.print("Would you like to use the default Network.txt file? Yes(Default)/No  ");
			answer = reader.nextLine();
			if (answer.equals("No") || answer.equals("no") || answer.equals("N") || answer.equals("n")) {
				System.out.print("Please enter filename: ");
				input = reader.nextLine(); //change to input argument
			}
			else input = "Network.txt";

			Network net = new Network(input);
			
			//main loop
			do {
				System.out.println(net);
				if(net.isStable()) {
					System.out.print("==================================================\n");
					System.out.print("||   STABLE STATE HAS BEEN REACHED AT TIME " + net.time + "!   ||\n");
					if(show_itterations) {
						System.out.println("||   " + itterations + " itteration(s) after stabilize started    ||");
						show_itterations = false;
					}
					System.out.print("==================================================\n\n");
				}
				System.out.print("Enter a command \n  [n]ext step \n  [s]tablize \n  [c]hange cost \n  [q]uit \n   ");
				input = reader.nextLine();
				
				if(input.equals("n") && !net.isStable()) {
					net.itterate_();
				} else if(input.equals("s") && !net.isStable()) {
					int start = net.time;
					net.stabilize();
					int end = net.time;
					itterations = end - start;
					show_itterations = true;
				} else if(input.equals("c")) {
					System.out.print("Enter change ([nodeID] [nodeID] [cost]): ");
					input = reader.nextLine();
					String data[] = input.split(" ");
					int nodeID1 = Integer.parseInt(data[0]);
					int nodeID2 = Integer.parseInt(data[1]);
					int cost = Integer.parseInt(data[2]);
					
					net.changeLink(nodeID1, nodeID2, cost);
				}
			} while(!input.equals("q"));
			
			reader.close();
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
	}
}
