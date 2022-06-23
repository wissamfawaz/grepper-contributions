
/*
	This is an implementation that efficiently
	finds the number of islands (groups of adjacent
	1s) in a grid of 1s (land) and 0s (water). 

	Let R be the number of rows and C be 
	the number of columns of the input grid.

	Time complexity: O(C * R)
	Space complexity: O(C * R)
*/

public class NumberOfIslands {
	public static void main(String[] args) {
		int[][] grid = {
				{ 1, 1, 1, 1, 0 },
				{ 1, 1, 0, 1, 0 },
				{ 1, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0 }
		};
		System.out.println(numIslands(grid)); // 1
	}

	private static int numIslands(int[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}

		int numIslands = 0;

		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[row].length; col++) {
				if (grid[row][col] == 1) {
					// Update islands count and reset
					// adjacent cells by setting them to 0
					numIslands++;
					resetIslandLand(grid, row, col);
				}

			}
		}
		return numIslands;
	}

	public static void resetIslandLand(int[][] grid, int row, int col) {
		if (row < 0 || row >= grid.length || col < 0
				|| col >= grid[0].length || grid[row][col] == 0) {
			return;
		}
		// Mark current cell as visited
		grid[row][col] = 0;
		// DFS through the grid
		resetIslandLand(grid, row + 1, col);
		resetIslandLand(grid, row - 1, col);
		resetIslandLand(grid, row, col + 1);
		resetIslandLand(grid, row, col - 1);
	}
}
