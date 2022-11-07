package aPackage;

import java.util.ArrayList;

public class Graph {
	
	ArrayList<ArrayList<Integer>> graph;
	int nodes;
	
	public Graph(int nodes) {
		this.nodes = nodes;
		graph = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < nodes; i++) {
			graph.add(new ArrayList<Integer>());
		}
	}
	
	public void addEdge(int x, int y) {
		graph.get(x).add(y);
	}
	
	public void printGraph() {
		for (int i = 0; i < nodes; i++) {
			System.out.print("Node " + i + ":");
			for (int j : graph.get(i)) {
				System.out.print(" -> " + j);
			}
			System.out.print("\n");
		}
		
	}
}
