package com.spacey.ps.dsa.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * An implementation of a iterative DFS with an adjacency list
 * 
 * Time Complexity: O(V + E)
 * 
 * @author Spacey4uq
 *
 */
public class DFSAdjacencyListIterative {

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

	// Perform a depth first search on a graph with n nodes
	// from a starting point to count the number of nodes
	// in a given component.
	static int dfs(Map<Integer, List<Edge>> graph, int start, int n) {

		int count = 0;
		boolean[] visited = new boolean[n];
		Stack<Integer> stack = new Stack<>();

		// Start by visiting the starting node
		stack.push(start);
		visited[start] = true;
		System.out.print("DFS Traversal at node " + start + ": ");
		
		while (!stack.isEmpty()) {
			int node = stack.pop();
			System.out.print(node + " ");
			count++;
			List<Edge> edges = graph.get(node);

			if (edges != null) {
				for (Edge edge : edges) {
					if (!visited[edge.to]) {
						stack.push(edge.to);
						visited[edge.to] = true;
					}
				}
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

		long nodeCount = dfs(graph, 0, numNodes);
		System.out.println("\nDFS node count starting at node 0: " + nodeCount);
		if (nodeCount != 4)
			System.err.println("Error with DFS");

		nodeCount = dfs(graph, 4, 5);
		System.out.println("\nDFS node count starting at node 4: " + nodeCount);
		if (nodeCount != 1)
			System.err.println("Error with DFS");
	}

	private static void addDirectedEdge(Map<Integer, List<Edge>> graph, int from, int to, int cost) {
		List<Edge> edges = graph.get(from);
		if (edges == null) {
			edges = new ArrayList<>();
			graph.put(from, edges);
		}
		edges.add(new Edge(from, to, cost));
	}

}
