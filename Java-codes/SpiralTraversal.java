
/*
	This is an implementation that demonstrates
	how to efficiently spiral traverse a two
	dimensional array. In particular, the program
	acts on an M*N 2-D array, returning 
	its elements in spiral order.

	Let M be the number of rows of 2-D array and
	N be its number of columns.

	Time complexity: O(M*N) 
	Space complexity: O(1)
*/
import java.util.List;
import java.util.ArrayList;

public class SpiralTraversal {
	public static void main(String[] args) {
		int[][] twoDArray = {
				{ 1, 2, 3, 4 },
				{ 12, 13, 14, 5 },
				{ 11, 16, 15, 6 },
				{ 10, 9, 8, 7 }
		};
		// Below prints:
		// [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]
		System.out.println(spiralOrder(twoDArray));
	}

	private static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<>();
		int rows = matrix.length;
		int columns = matrix[0].length;
		int up = 0;
		int left = 0;
		int right = columns - 1;
		int down = rows - 1;

		while (result.size() < rows * columns) {
			// Left to right direction.
			for (int col = left; col <= right; col++) {
				result.add(matrix[up][col]);
			}
			// Top down direction
			for (int row = up + 1; row <= down; row++) {
				result.add(matrix[row][right]);
			}
			// Make sure we are on a different row
			if (up != down) {
				// Right to left direction
				for (int col = right - 1; col >= left; col--) {
					result.add(matrix[down][col]);
				}
			}
			// Make sure we are on a different column
			if (left != right) {
				// Bottom up direction
				for (int row = down - 1; row > up; row--) {
					result.add(matrix[row][left]);
				}
			}

			left++;
			right--;
			up++;
			down--;
		}

		return result;
	}

}
