
/*
	This is implementation shows to create an 
	adjacency list representation of a graph based
	on a list of vertices and edges. 

	Let v be the number of vertices 
	and e the number of edges.

	Time complexity: O(e + v) 
	Space complexity: O(e + v)
*/
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class AdjacencyList {
	private static Map<Integer, List<Integer>> graph = new HashMap<>();

	public static void main(String[] args) {
		List<Integer> vertices = new ArrayList<>();
		List<Integer[]> edges = new ArrayList<>();
		// Vertices are represented as integers
		// 4 vertices labeled between 1 and 4
		for (int idx = 1; idx <= 4; idx++) {
			vertices.add(idx);
		}
		// An edge is a tuple connecting one
		// vertex to another.
		edges.add(new Integer[] { 1, 2 });
		edges.add(new Integer[] { 1, 3 });
		edges.add(new Integer[] { 3, 2 });
		edges.add(new Integer[] { 4, 2 });
		edges.add(new Integer[] { 4, 3 });
		// Use utility method to create the graph
		createGraph(vertices, edges);

		// Map representation of graph
		// Key is vertex and value is list of adjacent vertices
		System.out.println(graph); // {1=[2, 3], 2=[], 3=[2], 4=[2, 3]}
	}

	private static void createGraph(List<Integer> vertices,
			List<Integer[]> edges) {
		// Populate the graph with all vertices as keys
		for (int vertex : vertices) {
			graph.put(vertex, new ArrayList<>());
		}

		// Associate with every vertex a list of
		// its adjacent vertices.
		for (Integer[] edge : edges) {
			int src = edge[0];
			int dest = edge[1];

			List<Integer> neighbors = graph.get(src);
			neighbors.add(dest);
			graph.put(src, neighbors);
		}
	}
}
