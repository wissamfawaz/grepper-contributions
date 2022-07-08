
/*
	This is an implementation that demonstrates
	how to solve a partially filled 9*9 Sudoku board. 
	

	Time complexity: O(1) 
	Space complexity: O(1)
*/
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class SudokuSolver {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> board = new ArrayList<>();
		board.add(new ArrayList<>(Arrays.asList(7, 8, 0, 4, 0, 0, 1, 2, 0)));
		board.add(new ArrayList<>(Arrays.asList(6, 0, 0, 0, 7, 5, 0, 0, 9)));
		board.add(new ArrayList<>(Arrays.asList(0, 0, 0, 6, 0, 1, 0, 7, 8)));
		board.add(new ArrayList<>(Arrays.asList(0, 0, 7, 0, 4, 0, 2, 6, 0)));
		board.add(new ArrayList<>(Arrays.asList(0, 0, 1, 0, 5, 0, 9, 3, 0)));
		board.add(new ArrayList<>(Arrays.asList(9, 0, 4, 0, 6, 0, 0, 0, 5)));
		board.add(new ArrayList<>(Arrays.asList(0, 7, 0, 3, 0, 0, 0, 1, 2)));
		board.add(new ArrayList<>(Arrays.asList(1, 2, 0, 0, 0, 7, 4, 0, 0)));
		board.add(new ArrayList<>(Arrays.asList(0, 4, 9, 2, 0, 6, 0, 0, 7)));
		board = solveSudoku(board);
		for (List<Integer> row : board)
			System.out.println(row);
		/*
		 * The above outputs:
		 * [7, 8, 5, 4, 3, 9, 1, 2, 6]
		 * [6, 1, 2, 8, 7, 5, 3, 4, 9]
		 * [4, 9, 3, 6, 2, 1, 5, 7, 8]
		 * [8, 5, 7, 9, 4, 3, 2, 6, 1]
		 * [2, 6, 1, 7, 5, 8, 9, 3, 4]
		 * [9, 3, 4, 1, 6, 2, 7, 8, 5]
		 * [5, 7, 8, 3, 9, 4, 6, 1, 2]
		 * [1, 2, 6, 5, 8, 7, 4, 9, 3]
		 * [3, 4, 9, 2, 1, 6, 8, 5, 7]
		 */
	}

	private static ArrayList<ArrayList<Integer>> solveSudoku(ArrayList<ArrayList<Integer>> board) {
		solveSudokuRec(board, 0, 0);
		return board;
	}

	private static boolean solveSudokuRec(ArrayList<ArrayList<Integer>> board, int row, int col) {
		if (col == board.get(row).size()) {
			row += 1;
			col = 0;
			if (row == board.size()) {
				return true;
			}
		}

		if (board.get(row).get(col) == 0) {
			return tryDigitsAtPosition(board, row, col);
		}

		return solveSudokuRec(board, row, col + 1);
	}

	private static boolean tryDigitsAtPosition(ArrayList<ArrayList<Integer>> board, int row, int col) {
		for (int digit = 1; digit < 10; digit++) {
			if (isValidAtPosition(digit, board, row, col)) {
				board.get(row).set(col, digit);
				if (solveSudokuRec(board, row, col + 1))
					return true;
			}
		}

		board.get(row).set(col, 0);
		return false;
	}

	private static boolean isValidAtPosition(int digit, ArrayList<ArrayList<Integer>> board, int row, int col) {
		boolean isRowValid = !board.get(row).contains(digit);
		boolean isColumnValid = true;

		for (int rowIdx = 0; rowIdx < board.size(); rowIdx++) {
			if (board.get(rowIdx).get(col) == digit) {
				isColumnValid = false;
			}
		}

		if (!isRowValid || !isColumnValid) {
			return false;
		}

		int subgridRowStart = (row / 3) * 3;
		int subgridColStart = (col / 3) * 3;

		for (int rowIdx = 0; rowIdx < 3; rowIdx++) {
			for (int colIdx = 0; colIdx < 3; colIdx++) {
				int rowToCheck = subgridRowStart + rowIdx;
				int colToCheck = subgridColStart + colIdx;
				int existingValue = board.get(rowToCheck).get(colToCheck);

				if (existingValue == digit) {
					return false;
				}
			}
		}

		return true;
	}

}
