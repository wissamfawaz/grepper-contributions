
/*
	This is an implementation that demonstrates
	how to efficiently find a target element
	within a sorted matrix of distinct ints.
	Each row of the matrix is sorted. Moreover, 
	each column is sorted 
	
	Let n be the number of rows and m be the number
	of columns.

	Time complexity: O(n+m) 
	Space complexity: O(1)
*/
import java.util.Arrays;

public class SortedMatrixSearch {

	public static void main(String[] args) {
		int[][] matrix = {
				{ 1, 4, 7, 12, 15 },
				{ 2, 5, 19, 31, 32 },
				{ 3, 8, 24, 33, 35 },
				{ 40, 41, 42, 44, 45 },
				{ 99, 100, 103, 106, 128 }
		};
		int target = 44;
		// Below outputs: [3, 3] idxes at which 44 is found
		System.out.println(
				Arrays.toString(findInSortedMatrix(matrix, target)));
		target = 1000;
		// Below outputs: [-1, -1] as 1000 is not part of matrix
		System.out.println(
				Arrays.toString(findInSortedMatrix(matrix, target)));
	}

	private static int[] findInSortedMatrix(int[][] matrix, int target) {
		final int ROWS = matrix.length, COLS = matrix[0].length;
		int rowIdx = 0;
		int colIdx = COLS - 1;

		while (rowIdx < ROWS && colIdx >= 0) {
			if (matrix[rowIdx][colIdx] > target) {
				// Go to previous column
				colIdx--;
			} else if (matrix[rowIdx][colIdx] < target) {
				// Go to next row
				rowIdx++;
			} else {
				// Return row and column idxes at which target is found
				return new int[] { rowIdx, colIdx };
			}
		}
		// Failed to find target element
		return new int[] { -1, -1 };
	}

}
