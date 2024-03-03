// Java implementation for the above approach

import java.io.*;
import java.util.*;

class KNearestNeighbour {

	static class Node {

		List<Node> neighbors;
		int val;
		public Node(int val)
		{
			this.val = val;
			neighbors = new ArrayList<>();
		}
	}

	// Function to find the number of nodes
	// in the graph with sum less than K
	public static int nodeSumLessThanK(
		Node root, int K)
	{

		// Initialize the variable count
		// to count the answer
		int[] count = new int[1];

		// Initialize a HashSet to
		// store the visited nodes
		Set<Node> visited = new HashSet<>();

		// Apply DFS on the graph
		dfs(root, visited, count, K);

		// Return the answer stored in count
		return count[0];
	}

	// Depth first search function to visit
	// every node of the graph and check if
	// sum of neighbor nodes is less than K
	public static void dfs(
		Node root,
		Set<Node> visited,
		int[] count, int K)
	{

		// If the current node is
		// already visited then return
		if (visited.contains(root))
			return;

		// Mark the current node as visited
		visited.add(root);

		// Initialize a variable sum to
		// calculate sum of neighbors
		int sum = 0;

		// Iterate through all neighbors
		for (Node n : root.neighbors) {
			sum += n.val;
		}

		// If sum is less than K then
		// increment count by 1
		if (sum < K)
			count[0]++;

		for (Node n : root.neighbors) {

			// Visit the neighbor nodes
			dfs(n, visited, count, K);
		}
	}

	// Driver code
	public static void main(String[] args)
	{

		// Initialize the graph
		Node root = new Node(2);
		root.neighbors.add(new Node(3));
		root.neighbors.add(new Node(1));
		root.neighbors.get(0)
			.neighbors.add(new Node(5));
		root.neighbors.get(1)
			.neighbors.add(new Node(6));
		int K = 5;

		// Call the function
		// and print the result
		System.out.println(
			nodeSumLessThanK(root, K));
	}
}
