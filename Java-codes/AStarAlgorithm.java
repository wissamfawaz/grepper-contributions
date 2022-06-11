
/*
	This is an implementation of the popular 
	A* path finding algorithm. This algorithm takes
	as input a grid-shaped graph, a starting point
	and a destination. The algorithm would then 
	find the shortest path between the starting point
	and the destination. 
	(https://en.wikipedia.org/wiki/A*_search_algorithm)

	Let w be the width of the grid-shaped graph and 
	h be the height of the graph.

	Time complexity: O(w * h * log2(w * h)) 
	Space complexity: O(w*h)
*/

import java.util.PriorityQueue;
import java.util.Arrays;

public class AStarAlgorithm {
	// A class representing every node in the graph
	class Node {
		int rowIdx, colIdx, value;
		int G, H, F;
		Node predecessor;

		public Node(int rowIdx, int colIdx, int value) {
			this.rowIdx = rowIdx;
			this.colIdx = colIdx;
			this.value = value;
			G = Integer.MAX_VALUE;
			H = 0;
			F = Integer.MAX_VALUE;
			predecessor = null;
		}

		public boolean equals(Object other) {
			Node otherNode = (Node) other;
			return (rowIdx == otherNode.rowIdx) && (colIdx == otherNode.colIdx);
		}

		public String toString() {
			return "RowIdx: " + rowIdx + ", colIdx: " + colIdx + "\n"
					+ "G: " + G + ", H: " + H + ", F: " + F;
		}
	}

	public int[][] aStarAlgorithm(int startRow, int startCol, int endRow, int endCol, int[][] graph) {
		int ROWS = graph.length, COLS = graph[0].length;
		Node[][] nodesGraph = new Node[ROWS][COLS];

		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLS; col++) {
				int H = getManhattanDistance(row, col, endRow, endCol);
				nodesGraph[row][col] = new Node(row, col, graph[row][col]);
				nodesGraph[row][col].H = H;
			}
		}

		PriorityQueue<Node> pq = new PriorityQueue<>((node1, node2) -> {
			if (node1.F != node2.F) {
				return node1.F - node2.F;
			} else {
				return node1.G - node2.G;
			}
		});
		Node startNode = nodesGraph[startRow][startCol];
		startNode.G = 0;
		startNode.F = startNode.H;
		pq.add(startNode);
		Node currentNode = null, endNode = nodesGraph[endRow][endCol];
		while (!pq.isEmpty()) {
			currentNode = pq.remove();
			// System.out.println("CurrentNode:\n" + currentNode);
			if (currentNode.equals(endNode)) {
				break;
			}
			updateNeighbors(currentNode, nodesGraph, pq);
		}

		if (!currentNode.equals(endNode)) {
			return new int[][] {};
		} else {
			int[][] path = constructPath(endNode);
			return path;
		}
	}

	// Get Manhattan distance to destination
	private int getManhattanDistance(int startRow, int startCol, int endRow, int endCol) {
		return Math.abs(endRow - startRow) + Math.abs(endCol - startCol);
	}

	// Update weights of neighboring nodes
	private void updateNeighbors(Node currentNode, Node[][] nodesGraph, PriorityQueue<Node> pq) {
		int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
		int ROWS = nodesGraph.length;
		int COLS = nodesGraph[0].length;
		int currentNodeRowIdx = currentNode.rowIdx;
		int currentNodeColIdx = currentNode.colIdx;
		int nextNodeRowIdx, nextNodeColIdx;
		int[] direction;
		Node nextNode;
		for (int i = 0; i < directions.length; i++) {
			direction = directions[i];
			nextNodeRowIdx = currentNodeRowIdx + direction[0];
			nextNodeColIdx = currentNodeColIdx + direction[1];
			if (nextNodeRowIdx < 0 || nextNodeRowIdx >= ROWS || nextNodeColIdx < 0 || nextNodeColIdx >= COLS) {
				continue;
			}
			nextNode = nodesGraph[nextNodeRowIdx][nextNodeColIdx];
			if (nextNode.value == 1) {
				continue;
			}
			if (currentNode.G + 1 < nextNode.G) {
				nextNode.G = currentNode.G + 1;
				nextNode.F = nextNode.G + nextNode.H;
				nextNode.predecessor = currentNode;
				pq.remove(nextNode);
				pq.add(nextNode);
			}
		}
	}

	// Construct the shortest path starting from destination
	private int[][] constructPath(Node endNode) {
		int[][] path = new int[endNode.F + 1][2];
		int idx = path.length - 1;
		Node tempNode = endNode;
		do {
			path[idx][0] = tempNode.rowIdx;
			path[idx][1] = tempNode.colIdx;
			tempNode = tempNode.predecessor;
			idx--;
		} while (tempNode != null);
		return path;
	}

	public static void main(String[] args) {
		AStarAlgorithm application = new AStarAlgorithm();
		int startRow = 0, startCol = 1, endRow = 4, endCol = 3;
		int[][] graph = {
				{ 0, 0, 0, 0, 0 },
				{ 0, 1, 1, 1, 0 },
				{ 0, 0, 0, 0, 0 },
				{ 1, 0, 1, 1, 1 },
				{ 0, 0, 0, 0, 0 }
		};
		int[][] path = application.aStarAlgorithm(startRow, startCol, endRow, endCol, graph);
		for (int[] node : path) {
			System.out.print(Arrays.toString(node) + " ");
		}
		// Output:
		// [0, 1] [0, 0] [1, 0] [2, 0] [2, 1] [3, 1] [4, 1] [4, 2] [4, 3]
	}
}
