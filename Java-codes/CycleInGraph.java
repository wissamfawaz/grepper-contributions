
/*
	This is an implementation that determines
	whether or not a directed graph contains a 
	cycle. A cycle is a number of vertices that
	are connected in a closed chain.
	
	Let V be the number of vertices and E the 
	number of edges.
	Time complexity: O(V + E) 
	Space complexity: O(V)
*/
import java.util.List;
import java.util.ArrayList;

public class CycleInGraph {
	private boolean cycle;
	// WHITE: Vertex not processed yet
	// GRAY: Vertex is being processed
	// BLACK: Vertex already processed
	private final int WHITE = 0, GRAY = 1, BLACK = 2;
	private int[] colors;
	private List<Integer[]> edges;

	public CycleInGraph() {
		cycle = false; // Cycle indicator

		// Create list of Graph edges
		edges = new ArrayList<>();
		edges.add(new Integer[] { 1, 3 }); // Edges sourced at vertex 0
		edges.add(new Integer[] { 2, 3, 4 }); // Edges sourced at 1
		edges.add(new Integer[] { 0 }); // Edges sourced at vertex 2
		edges.add(new Integer[] {}); // Edges sourced at vertex 3
		edges.add(new Integer[] { 2, 5 }); // Edges sourced at vertex 4
		edges.add(new Integer[] {}); // Edges sourced at vertex 5

		// Colors array to assign a color per vertex
		colors = new int[edges.size()];
	}

	public static void main(String[] args) {
		CycleInGraph application = new CycleInGraph();
		// There are multiple cycles in considered graph:
		// 1) 0 -> 1 -> 2 -> 0
		// 2) 0 -> 1 -> 4 -> 2 -> 0
		// 3) 1 -> 2 -> 0 -> 1
		System.out.println(application.cycleInGraph()); // true
	}

	public boolean cycleInGraph() {
		for (int vertex = 0; vertex < edges.size(); vertex++) {
			// Traverse graph using DFS algorithm
			if (!cycle && colors[vertex] == WHITE) {
				dfs(vertex);
			}
		}

		return cycle;
	}

	private void dfs(int vertex) {
		colors[vertex] = GRAY;
		// Examine neighbors of current vertex
		Integer[] neighbors = edges.get(vertex);

		for (int neighbor : neighbors) {
			// There is cycle if neighbor already
			// processed in DFS traversal.
			if (colors[neighbor] == GRAY) {
				cycle = true;
				return;
			} else {
				dfs(neighbor);
			}
		}

		colors[vertex] = BLACK;
	}
}
