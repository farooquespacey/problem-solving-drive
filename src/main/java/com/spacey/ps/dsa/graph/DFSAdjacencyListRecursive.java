package com.spacey.ps.dsa.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * An implementation of a recursive approach to DFS
 * 
 * Time Complexity: O(V + E)
 * 
 * @author Spacey4uq
 *
 */
public class DFSAdjacencyListRecursive {

	static class Edge {
		int from;
		int to;
		int cost;

		public Edge(int from, int to, int cost) {
			super();
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

	}

	// Perform a depth first search on the graph counting
	// the number of nodes traversed starting at some position
	static long dfs(Map<Integer, List<Edge>> graph, int at, boolean[] visited) {

		// We have already visited this node
		if (visited[at])
			return 0L;

		// Visit this node
		visited[at] = true;
		long count = 1;
		System.out.print(at + " ");

		// Visit all edges adjacent to where we're at
		List<Edge> edges = graph.get(at);
		if (edges != null) {
			for (Edge edge : edges) {
				count += dfs(graph, edge.to, visited);
			}
		}

		return count;
	}

	public static void main(String[] args) {
	    // Create a fully connected graph
	    //           (0)
	    //           / \
	    //        5 /   \ 4
	    //         /     \
	    // 10     <   -2  >
	    //   +->(2)<------(1)      (4)
	    //   +--- \       /
	    //         \     /
	    //        1 \   / 6
	    //           > <
	    //           (3)
		int numNodes = 5;
		Map<Integer, List<Edge>> graph = new HashMap<>();
		addDirectedEdge(graph, 0, 1, 4);
		addDirectedEdge(graph, 0, 2, 5);
		addDirectedEdge(graph, 1, 2, -2);
		addDirectedEdge(graph, 1, 3, 6);
		addDirectedEdge(graph, 2, 3, 1);
		addDirectedEdge(graph, 2, 2, 10); // Self loop

		System.out.print("DFS Traversal at node " + 0 + ": ");
		long nodeCount = dfs(graph, 0, new boolean[numNodes]);
		System.out.println("\nDFS node count starting at node 0: " + nodeCount);
		if (nodeCount != 4)
			System.err.println("Error with DFS");

		System.out.print("DFS Traversal at node " + 4 + ": ");
		nodeCount = dfs(graph, 4, new boolean[numNodes]);
		System.out.println("\nDFS node count starting at node 4: " + nodeCount);
		if (nodeCount != 1)
			System.err.println("Error with DFS");
	}

	// Helper method to setup graph
	private static void addDirectedEdge(Map<Integer, List<Edge>> graph, int from, int to, int cost) {
		List<Edge> edges = graph.get(from);
		if (edges == null) {
			edges = new ArrayList<>();
			graph.put(from, edges);
		}
		edges.add(new Edge(from, to, cost));
	}

}
